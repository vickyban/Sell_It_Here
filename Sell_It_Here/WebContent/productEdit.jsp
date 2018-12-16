<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit product</h1>
	<form action="${pageContext.request.contextPath}/products/product" method="post">
		<input type="hidden" name="action" value='<c:out value="${action}" default="new" />' /> 
		<input type="hidden" name="id" value="<c:out value="${product.productId}" />"  required />
		<input type="text" name="name" placeholder="Product name ..." value="${product.name}" required/>
		<input type="number" name="price" value="${product.price}" placeholder="Product price" min=0 step=".01" required/>
		<div id="category">
			<div>Category:</div>
			<select name="category">
				<option value="car"  selected="selected">Cars</option>
				<option value="tech">Tech</option>
				<option value="motor">Motors</option>
				<option value="leisure">Leisure</option>
				<option value="home">Home</option>
				<option value="entertainment">Entertainment</option>
				<option value="fashion">Fashion</option>
				<option value="child">Other</option>
			</select>
		</div>
		<div>
			<h3>Description:</h3>
			<textarea name="description">${product.description}</textarea>
		</div>
		
		<input type="submit" value='<c:out value="${submit}" default="Create Post" />' >

	</form>
</body>
</html>