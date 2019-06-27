package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private Configuration config;
	
	public void sendNotification(User user, Map<String, Object> model) throws MailException{
//		SimpleMailMessage mail = new SimpleMailMessage();
//		
//		mail.setTo(user.getEmailAddress());
//		mail.setFrom("travellingwebsiteproject@gmail.com");
//		mail.setSubject("This is an automated email");
//		mail.setText("Username entered: "+user.getFirstname() +"\n Password entered: "+ user.getPassword());
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			helper.setTo(user.getEmailAddress());
			helper.setText(html, true);
			helper.setSubject("Welcome to Flying Lion!");
			helper.setFrom("travellingwebsiteproject@gmail.com");
			
			javaMailSender.send(message);
		} catch(MessagingException | IOException |TemplateException e) {
			System.out.println(e.getMessage());
		}
	}
}
