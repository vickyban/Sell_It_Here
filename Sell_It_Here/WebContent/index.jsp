<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link href="styles/indexStyle.css" rel="stylesheet" type="text/css" />
  <link href="styles/footerStyle.css" rel="stylesheet" type="text/css" />
  <title>Sell It Here! - Home </title>
</head>
<body>
	<div id="header" class="">
	
		<%@ include file="/login_out_div.jsp" %>
		
		
		<img src=" Images/index_img_1.png" alt="cute_img" />
		<h2 id="logo">Sell It Here!</h2>
	</div>

	<div id="main" class="center">
		<div id="categories">
			<ul>
				<li><a href="${pageContext.request.contextPath}/products?category=car">
						<div class="icons"></div> Cars
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=electonic">
						<div class="icons"></div> Electronics
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=fashion">
						<div class="icons"></div> Fashion
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=home">
						<div class="icons"></div> Home
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=garden">
						<div class="icons"></div> Garden
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=accessory">
						<div class="icons"></div> Accessories
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=motor">
						<div class="icons"></div> Motors
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=sport">
						<div class="icons"></div> Sports
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=toy">
						<div class="icons"></div> Toys
				</a></li>
				<li><a href="${pageContext.request.contextPath}/products?category=other">
						<div class="icons"></div> Others
				</a></li>

			</ul>
		</div>

		<div id="recent_posts">
			<h3>Recent Posting</h3>
			<ul>
				<c:forEach var="product" items="${products}">
					<li class="item"><a href="${pageContext.request.contextPath}/products/product?id=${product.productId}">
							<div class="img">
								<img
									src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png">
							</div>
							<p class="item_price">${product.price}</p>
							<div class="item_name">${product.name}</div>
					</a></li>

				</c:forEach>
			</ul>
			<!-- <a href="Product?id=${item.id}" class="card">
        <div>
          <img src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png" />
        </div>
        <div>
          <h3>${item.name}</h3>
          <p>${item.price}</p>
        </div>
      </a> -->
			<%-- <ul>
				<li class="item"><a href="#">
						<div class="img">
							<img
								src="https://res.cloudinary.com/goodsearch/image/upload/v1508942413/hi_resolution_merchant_logos/square_coupons.png">
						</div>
						<p class="item_price">${item.price}</p>
						<div class="item_name">${item.name}</div>
				</a></li>

			</ul> --%>

		</div>

	</div>

	<%@ include file="/footer_div.jsp" %>

	<script>
    let isOn = false;
    let user_div = document.getElementById("user_div");
    document.getElementById("toggle_btn").addEventListener("click", function(e){
      if (isOn) {
        user_div.style.display = 'none';
        isOn = false;
      } else {
        user_div.style.display = 'block';
        isOn = true;
        e.stopPropagation();
      }
    })
    document.addEventListener('click', function(e){
      if (isOn) {
        user_div.style.display = 'none';
        isOn = false;
      }
    })
  </script>
</body>
</html>