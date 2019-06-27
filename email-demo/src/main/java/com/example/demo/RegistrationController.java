package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private NotificationService notificationService;

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String readyToSend(ModelMap model, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
		
		//creating user
		User user = new User();
		user.setFirstname(username);
		user.setPassword(password);
		user.setEmailAddress(email);
		
		try {
			notificationService.sendNotification(user, model);
		}catch(MailException e) {
			//catch error
			logger.info("error sending message"+e.getMessage());
		}
		
		return "again";
	}
}
