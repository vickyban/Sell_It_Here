<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles/productsStyle.css" rel="stylesheet" type="text/css" />
  <link href="styles/footerStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Products</title>
</head>
<body>
	<div id="header">
		<div id="logo_div">
			<img src="Images/logo.png" alt="logo icon" />
		</div>
		<div id="search_div">
			<form action="${pageContext.request.contextPath}/products">
				<input type="hidden" name="city"  value=<c:out value="${user.city}" /> />
				<div id="box1">
					<input type="text" name="search" placeholder="search..." value="${param.search}"/> <input
						type="submit" value="Search" />
				</div>
				<div id="box2">
					<div id="category">
						<div>Category:</div>
						<select name="category">
							<option value=""  selected="selected">all</option>
							<option value="car">Cars</option>
							<option value="tech">Tech</option>
							<option value="motor">Motors</option>
							<option value="leisure">Leisure</option>
							<option value="home">Home</option>
							<option value="entertainment">Entertainment</option>
							<option value="fashion">Fashion</option>
							<option value="child">Other</option>
						</select>
					</div>
					<div id="price">
						<div>Price:</div>
						<div class="dropdown_div">
							<input type="number" name="minPrice" min="0" placeholder="Price" value=0 />
							<div>to</div>
							<input type="number" name="maxPrice" min="0" placeholder="Price" value=2000 />
						</div>
					</div>
					
					<div id="sort">
						<div>Sort by:</div>
						<select name="sort">
							<option value="NEW_OLD" selected="selected">Date(most recent)</option>
							<option value="LOW_HIGH">Price: low to high</option>
							<option value="HIGH_LOW">Price: high to low</option>
						</select>
					</div>
				</div>
			</form>
		</div>

		<%@ include file="/login_out_div.jsp"%>
	</div>

	<div id="content" class="center">

		<c:forEach var="item" items="${products}">
			<a href="${pageContext.request.contextPath}/products/product?id=${item.productId}" class="card">
				<div>
					<img
						src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png" />
				</div>
				<div>
					<h3>${item.name}</h3>
					<p>${item.price}</p>
				</div>
			</a>

		</c:forEach>
		<%--     <a href="Product?id=${item.id}" class="card">
      <div>
        <img src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png" />
      </div>
      <div>
        <h3>${item.name}</h3>
        <p>${item.price}</p>
      </div>
    </a>

    <div class="card">
      <div>
        <img src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png" />
      </div>
      <div>
        <h3>${item.name}</h3>
        <p>${item.price}</p>
      </div>
    </div> --%>


	</div>

		<%@ include file="/footer_div.jsp" %>
	<script>
    let isOn = false;
    let user_div = document.getElementById("user_div");
    document.getElementById("toggle_btn").addEventListener("click", e => {
      if (isOn) {
        user_div.style.display = 'none';
        isOn = false;
      } else {
        user_div.style.display = 'block';
        isOn = true;
        e.stopPropagation();
      }
    })
    document.addEventListener('click', e => {
      if (isOn) {
        user_div.style.display = 'none';
        isOn = false;
      }
    })
  </script>
</body>
</html>