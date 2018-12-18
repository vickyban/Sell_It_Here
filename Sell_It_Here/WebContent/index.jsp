<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell It Here</title>
<link href="styles/headerStyle.css" rel="stylesheet" type="text/css" />
<link href="styles/indexStyle.css" rel="stylesheet" type="text/css" />
<link href="styles/footerStyle.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/styles/footerStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="/header.jsp"%>

	<div class="wrapper">
		<section class="index-banner"> </section>
	</div>

	<!-- <div id="main" class="center"> -->
	<div class="wrapper">
		<div id="categories">
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/products?category=car">
						<div class="icons"></div> Cars
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=electonic">
						<div class="icons"></div> Electronics
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=fashion">
						<div class="icons"></div> Fashion
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=home">
						<div class="icons"></div> Home
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=garden">
						<div class="icons"></div> Garden
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=accessory">
						<div class="icons"></div> Accessories
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=motor">
						<div class="icons"></div> Motors
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=sport">
						<div class="icons"></div> Sports
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=toy">
						<div class="icons"></div> Toys
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/products?category=other">
						<div class="icons"></div> Others
				</a></li>

			</ul>
		</div>

		<div id="recent_posts">
			<h3 style="font-family: 'Catamaran';">Recent Posting</h3>
			<ul>
				<c:forEach var="product" items="${products}">
					<li class="item"><a
						href="${pageContext.request.contextPath}/products/product?id=${product.productId}">
							<div class="img">
								<img
									src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png">
							</div>
							<div class="item_name">${product.name}</div>
							<div class="item_price">
								<div>Price: $${product.price}</div>
							<%-- 	<div>Seller: ${product.price}</div> --%>
							</div>
					</a></li>

				</c:forEach>
			</ul>
		</div>

	</div>
	<%@ include file="/footer_div.jsp"%>
</body>
</html>