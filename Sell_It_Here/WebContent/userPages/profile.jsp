<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>username: ${user.username}</p>
	<p>email: ${user.email}</p>
	<p>credit: ${user.credit}</p>
	<p>joined on: ${user.created_at}</p>
	<a href="${pageContext.request.contextPath}/user/profile/edit">Edit</a>
</body>
</html>