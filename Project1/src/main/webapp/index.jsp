<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web</title>
</head>
<body>

Web strana firme

<br>
<a href="login.jsp">Login</a>
<br>
<a href="signup.jsp">Sign Up</a>
<br>
${requestScope.successMsg}
</body>
</html>