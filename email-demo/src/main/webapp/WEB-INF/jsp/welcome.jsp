<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Log in with your account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<title>Create an account</title>

</head>
<body>
	<form action="/welcome" method="POST">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 col-xs-12">
					<div class="jumbotron">

						<h2>Send an Email</h2>

						<div class="form-group">
							<label class="control-label" for="username">Username</label> <input
								type="text" name="username" class="form-control"
								placeholder="Username" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Password</label> <input
								type="password" name="password" class="form-control"
								placeholder="Password" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="email">Email</label> <input
								type="email" name="email" class="form-control"
								placeholder="Email-id" required>
						</div>
						<br>
						<div align="center">
							<button type="submit" class="btn btn-outline-info">Send</button>
							<button type="reset" class="btn btn-outline-dark">Close</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
