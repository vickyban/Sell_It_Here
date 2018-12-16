<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.UserBean" %>
<%@ page import="java.util.*, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title> Profile </title>
  <link href="${pageContext.request.contextPath}/styles/MyProfile.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<%
	UserBean user = (UserBean) session.getAttribute("user");
%>
  <div id="header">
    <div id="logo_div">
      <img src="${pageContext.request.contextPath}/Images/logo.png" alt="logo icon" id="logoLeft" />
      <a href="Login" id="logoRight">Sign in/Sign up</a>
    </div>
  </div>

  <div id="navBar">
		<div id="center">
			<ol>
				<li class="horizontal"><a href="${pageContext.request.contextPath}/user/profile" style="border:.5px solid black;
	border-radius:5px;">  My Account </a></li> 
				<li class="horizontal"><a href="${pageContext.request.contextPath}/products/product/new"> Sell Item </a></li>
				<li class="horizontal"><a href="#"> Transactions </a></li>
				<li class="horizontal"><a href="#"> Messages </a></li>
			</ol>
		</div>
	</div>

  <div id="content">
  	<div class="divCenter"> 
  	
  	<h3> Profile </h3> 
  	
    <form action="${pageContext.request.contextPath}/user/profile" method="Post">
  		
    	<table id="editTable">
    		<tr>
    			<td> <label class="labelWidth" > First Name </label> </td>
				<td> <input type="text" name="fname" class="textWidth" value="${user.fname}"></td>
    		</tr>
    		
    		<tr>
    			<td> <label class="labelWidth"> Last Name </label> </td>
				<td> <input type="text" name="lname" class="textWidth" value="${user.lname}"> </td>
    		</tr>
    			
    		<tr>
    			<td> <label class="labelWidth">  Street Address  </label></td>
    			<td> <input type="text" name="street" class="textWidth" value="${user.street}"> </td>
    		</tr>
    		
    		<tr>
    			<td> <label class="labelWidth"> City  </label> </td>
    			<td> <input type="text" name="city" class="textWidth" value="${user.city}"> </td>
    		</tr>
    		
    		<tr>
    			<td><label class="labelWidth"> Province/Territory   </label></td>
    			<td>
						 <select id="locationPicker" name="province" >
			              <option value="${user.street}" disabled selected hidden> Select province/territory </option>
			              <option value="Alberta"> Alberta </option>
			              <option value="British Columbia"> British Columbia </option>
			              <option value="Manitoba"> Manitoba </option>
			              <option value="New Brunswick"> New Brunswick </option>
			              <option value="Newfoundland"> Newfoundland </option>
			              <option value="Northwest Territories"> Northwest Territories </option>
			              <option value="Nova Scotia"> Nova Scotia </option>
			              <option value="Ontario"> Ontario </option>
			              <option value="Prince Edward Island"> Prince Edward Island </option>
			              <option value="Quebec"> Quebec </option>
			              <option value="Saskatchewan"> Saskatchewan </option>
			              <option value="Yukon"> Yukon </option>
			            </select>
			     </td>
    		</tr>
    	</table>
    
    
    <h3> Account </h3>
 
    	<table id="editTable2">
    		<tr>
    			<td> <label class="labelWidth"> Email  </label> </td>
				<td> <input type="email" name="email" class="textWidth" ${user.email}"> </td>
    		</tr>
    		
    		<tr>
    			<td> <label class="labelWidth"> New Password </label> </td>
				<td> <input type="password" name="password1" class="textWidth"> </td>
				
    		</tr>
    		<tr>
    			<td> <label class="labelWidth"> Re-enter </label> </td>
				<td> <input type="password" name="password2" class="textWidth"> </td>
    		</tr>
    		<tr>
    			<td> <label class="labelWidth"> Credit Card </label> </td>
				<td> <input type="text" name="creditcard" class="textWidth"> </td>
    		</tr>
    	</table>
    </div>
		<br>
		<input type="submit" value="Save Changes" id="saveChanges">
    </form> 

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
					<td><img src="../Images/fb.svg" class="footLogo"></td>
					<td><img src="../Images/gmail.svg" class="footLogo"></td>
					<td><img src="../Images/instag.svg" class="footLogo"></td>
					<td><img src="../Images/twitter.svg" class="footLogo"></td>
					<td><img src="../Images/yt.svg" class="footLogo"></td>
					<td><img src="../Images/pin.svg" class="footLogo"></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>