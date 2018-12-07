<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/profile" method="post">
		<input type="hidden" name="redirect_uri" value=<c:out value="${uri}" default="${pageContext.request.contextPath}/user/profile/" /> />
		<input type="text" name="username" placeholder="Username..." /><br>
		<input type="text" name="location" placeholder="City/Town..." /><br>
		<input type="submit" value="Login" />
	</form>
</body>
</html>