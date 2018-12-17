<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.*,dao.*" %>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/styles/reply.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

<div id="header">
		<div id="logo_div">
			<img src="${pageContext.request.contextPath}/Images/logo.png" alt="logo icon" />
		</div>
		<div id="search_div">
			<form action="${pageContext.request.contextPath}/products">
				<input type="hidden" name="city"  value='<c:out value="${user.city}" default="%"/>' />
				<div id="box1">
					<input type="text" name="search" placeholder="search..." value="${param.search}"/> <input
						type="submit" value="Search" />
				</div>
				<div id="box2">
					<div id="category">
						<div>Category:</div>
						<select name="category">
							<option value="%"  selected="selected">all</option>
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
	</div>
	
<div class="wrapper content">
	<div>
		<form method="post" action= "${pageContext.request.contextPath}/SendMessage">
		<table id="editTable">
			<tr>
				<td class="param">  To: </td>
				<td class="value"> ${message.recipientUser}</td>
			</tr>
			
			<tr>
				<td class="param">  From: </td>
				<td class="value"> ${message.senderUser}</td>
			</tr>
			<tr>
				<td class="param">  Date: </td>
				<td class="value"> <fmt:formatDate type = "both" dateStyle = "long" timeStyle = "short" value="${message.dateCreated}" /> </td>
			</tr>
			<tr>
				<td class="param"> Message: </td>
				<td class="value"> ${message.message}</td>
			</tr>
		</table>
		
		<br><br>
		<div id="centerMe">
		<table id="sendMe">
			<tr>
				<td> <textarea rows="8" cols="100" name="message" ></textarea></td>
			</tr>
			<tr>
				<td > 
					<button type="submit" formaction="${pageContext.request.contextPath}/buyingMessage.jsp" id="left">
						 Back to messages
					</button>
					<button type="submit" formaction="${pageContext.request.contextPath}/SendMessage" id="right" value="${message.recipientID}" name="sendTo">
						 Submit 
					</button>
				
				</td>
			</tr>
		</table>
		</div>
		</form>
	</div>
</div>
	
	  	<div id="footer">
	</br></br>
		<div class="floatRight">
			<table>
			<tr>
				<td> <label class="labelWidth"> Follow Us</label> </td>
				<td style="width:700px;text-align:right;"> <label class="labelWidth"> © Sell It Here 2018</label> </td> </td>
			</table>
		</div>
		</br></br>
		<div class="floatRight2">
			<table>
				<tr>
					<td><img src="${pageContext.request.contextPath}/Images/fb.svg" class="footLogo"></td>
					<td><img src="${pageContext.request.contextPath}/Images/gmail.svg" class="footLogo"></td>
					<td><img src="${pageContext.request.contextPath}/Images/instag.svg" class="footLogo"></td>
					<td><img src="${pageContext.request.contextPath}/Images/twitter.svg" class="footLogo"></td>
					<td><img src="${pageContext.request.contextPath}/Images/yt.svg" class="footLogo"></td>
					<td><img src="${pageContext.request.contextPath}/Images/pin.svg" class="footLogo"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>