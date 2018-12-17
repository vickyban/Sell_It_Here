<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/styles/searchbarStyle.css" rel="stylesheet" type="text/css" />
<ink href="${pageContext.request.contextPath}/styles/productEditStyle.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
		<%@ include file="/searchbar.jsp"%>
<%-- 	<h1>Edit product</h1>
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

	</form> --%>
	
	 <form class="wrapper content" action="${pageContext.request.contextPath}/products/product" method="post">
	 <input type="hidden" name="action" value='<c:out value="${action}" default="new" />' /> 
		<input type="hidden" name="id" value="<c:out value="${product.productId}" />"  required />
    <div class="photo">
      <input type="file" id="img" name="photo" accept="image/png, image/jpeg" />
      <label for="file-input" class="file-label">
        <i class="fa fa-download fa-5x"></i><br>
        Choose a file or drag it here
      </label>
    </div>
    <div class="other"></div>
    <div class="product">

      <div class="product-title">
        <div>Title</div>
        <input type="text" name="title" placeholder="Title"  value="${product.name}" required />
      </div>
      <div class="product-price">
        <div>Price</div>
        <input type="number" name="price" placeholder="Price" min=0 step=0.1 required  value="${product.price}"/>
      </div>
      <div class="product-category">
        <div>Category:</div>
        <select name="category">
          <option value="car" selected="selected">Cars</option>
          <option value="tech">Tech</option>
          <option value="motor">Motors</option>
          <option value="leisure">Leisure</option>
          <option value="home">Home</option>
          <option value="entertainment">Entertainment</option>
          <option value="fashion">Fashion</option>
          <option value="child">Other</option>
        </select>
      </div>
      <div class="product-desc">
        <h3>Description:</h3>
        <textarea name="description">${product.description}</textarea>
      </div>
    </div>
    <div class="seller">
      <div class="product-btn">
        <input type="submit" value='<c:out value="${submit}" default="Create Post" />'  />
        <a href="${pageContext.request.contextPath}">Cancel</a>
      </div>
    </div>

    </div>
  </form>
</body>
</html>