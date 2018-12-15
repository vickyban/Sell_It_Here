<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link href="styles/signupStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div id="header">
		<div id="logo_div">
			<img src="Images/logo.png" alt="logo icon" id="logoLeft" /> <a
				href="Login" id="logoRight">Sign in/Sign up</a>
		</div>
	</div>

	<div id="navBar">
		<div id="center">
			<ol>
				<li class="horizontal"><a href="#"> Profile </a></li>
				<li class="horizontal"><a> Sell </a></li>
				<li class="horizontal"><a> Transactions </a></li>
				<li class="horizontal"><a> Messages </a></li>
			</ol>
		</div>
	</div>

	<div id="content">
		<c:if test="${messages != null}">
			<ul>
				<c:forEach var="msg" items="${messages}">
					<li><c:out value="${msg}" /></li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="${pageContext.request.contextPath}/signup" method="post">
			<table id="editTable">
				<tr>
					<td><label class="labelWidth"> First Name <input
							type="text" name="fname" class="textWidth" value="${param.fname}"
							required />
					</label></td>

					<td><label class="labelWidth"> Province/Territory <select
							id="locationPicker" name="province">
								<option value="" disabled selected hidden>Select
									province/territory</option>
								<option value="Alberta">Alberta</option>
								<option value="British Columbia">British Columbia</option>
								<option value="Manitoba">Manitoba</option>
								<option value="New Brunswick">New Brunswick</option>
								<option value="Newfoundland">Newfoundland</option>
								<option value="Northwest Territories">Northwest Territories</option>
								<option value="Nova Scotia">Nova Scotia</option>
								<option value="Ontario" selected="selected">Ontario</option>
								<option value="Prince Edward Island">Prince Edward Island</option>
								<option value="Quebec">Quebec</option>
								<option value="Saskatchewan">Saskatchewan</option>
								<option value="Yukon">Yukon</option>
						</select>
					</label></td>

				</tr>

				<tr>
					<td><label class="labelWidth"> Last Name <input
							type="text" name="lname" class="textWidth" value="${param.lname}"
							required>
					</label></td>
					<td><label class="labelWidth"> Postal Code <input
							type="text" name="postal" value="${param.postal}"
							class="textWidth">
					</label></td>
				</tr>

				<tr>
					<td><label class="labelWidth"> Username <input
							type="text" name="user" class="textWidth" required>
					</label></td>
					<td><label class="labelWidth"> Phone <input
							type="text" name="phone" class="textWidth">
					</label></td>
				</tr>

				<tr>
					<td><label class="labelWidth"> Password: <input
							type="password" name="password" class="textWidth" required>
					</label></td>
				</tr>

				<tr>
					<td><label class="labelWidth"> Email: <input
							type="email" name="email" class="textWidth" required>
					</label></td>
				</tr>

				<tr>
					<td><label class="labelWidth"> Date of Birth: <select
							name="month" class="textWidth2">
								<option value="" disabled selected hidden>Month</option>
								<option value="01">January</option>
								<option value="02">February</option>
								<option value="03">March</option>
								<option value="04">April</option>
								<option value="05">May</option>
								<option value="06">June</option>
								<option value="07">July</option>
								<option value="08">August</option>
								<option value="09">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
						</select> <select name="day" class="textWidth3">
								<option value="" disabled selected hidden>Day</option>
								<%
									for (int x = 1; x <= 31; x++) {
								%>
								<option value="<%=x%>" />
								<%=x%>
								</option>
								<%
									}
								%>
						</select> <select name="year" class="textWidth3">
								<option value="" disabled selected hidden>Year</option>
								<%
									for (int x = Calendar.getInstance().get(Calendar.YEAR) - 110; x <= Calendar.getInstance()
											.get(Calendar.YEAR); x++) {
								%>
								<option value="<%=x%>" />
								<%=x%>
								</option>
								<%
									}
								%>
						</select>

					</label></td>

				</tr>
				<tr>
					<td><label class="labelWidth"> Street Address: <input
							type="text" name="street" class="textWidth"></label></td>
					<td><label class="labelWidth"> <input type="submit"
							name="Create Account">
					</label></td>

				</tr>
				<tr>
					<td><label class="labelWidth"> City: <input
							type="text" name="city" class="textWidth" required>
					</label></td>
				</tr>

			</table>
		</form>
		</br> </br>
	</div>

	<div id="footer">
		</br> </br>
		<div class="floatRight">
			<table>
				<tr>
					<td><label class="labelWidth"> Follow Us</label></td>
					<td style="width: 700px; text-align: right;"><label
						class="labelWidth"> © Sell It Here 2018</label></td>
					</td>
			</table>
		</div>
		</br> </br>
		<div class="floatRight2">
			<table>
				<tr>
					<td><img src="Images/fb.svg" class="footLogo"></td>
					<td><img src="Images/gmail.svg" class="footLogo"></td>
					<td><img src="Images/instag.svg" class="footLogo"></td>
					<td><img src="Images/twitter.svg" class="footLogo"></td>
					<td><img src="Images/yt.svg" class="footLogo"></td>
					<td><img src="Images/pin.svg" class="footLogo"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>