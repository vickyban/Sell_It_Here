<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Product: ${product.name}</h2>
	<h4>Price: $${product.price}</h4>
	<p>Description: ${product.description}</p>
	
	<h2>Seller: ${seller.username}</h2>
	<h4>City: ${seller.city}</h4>
	
	<form action="${pageContext.request.contextPath}/transaction" method="post">
		<input type="hidden" name="action" value="buy" />
		<input type="submit" value="Process to Buy" />
	</form>
	
	<form action="${pageContext.request.contextPath}/transaction" method="post">
		<input type="hidden" name="action" value="cancel" />
		<input type="submit" value="Cancel" />
	</form>
</body>
</html>