<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Register</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
	function validate(){
		/* var firstname = document.getElementById("firstname");
		var lastname  = document.getElementById("lastname");
		var address = document.getElementById("address");
		var email = document.getElementById("email");
		var phone = document.getElementById("phone");
		var password = document.getElementById("password");
		var position = document.getElementById("position");
		var location = document.getElementById("location");
		var role = document.getElementById("role"); */
		var email = '<%=session.getAttribute("emailAlert")%>';
		//var re1 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
		
	    if (email=="false"){
			alert("Email already exist!");
			return false;
		}else {
			//console.log("Registeration succeed.");
			return true;
		}
	}
	
	function myFunction() {
	  var x = document.getElementById("password");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	} 
	</script>
	</head>
	
	<!--show the register page  -->
	<style>
	body {
		background-color: #857470;
		color:#fff;
	}
	.text-center{
		color:#fff;	
		text-transform:uppercase;
	    margin: 0px 0 10px 0;
	    display: block;
	    text-align: center;
	}
	.container{
		position:absolute;
		left:35%;
		right:35%;
		top:20%;
	    background-color:  #dcb2a9 ;
		border-radius: 5px;
		padding:55px 50px;
		padding-bottom: 20px;
		text-align:center
	}
	.btn{
		color:#fff;
		background-color:#efbdb2;
		outline: none;
		border: 0;
		color: #fff;
		padding:10px 20px;
		text-transform:uppercase;
		cursor:pointer;
		position:static;
	}
	</style>
	<body>
	<div class="container">
	<p class="text-center" style="left:10%; right:10%;text-align: center;font-size:150%">Register</p>
	<form method="post" action="register" onSubmit="return validate()">
	 	<b>Register as a/an:    </b>
	 	<select id="role" name="role">
				<option value="guest">Guest</option>
				<option value="emp">Employee</option>
		</select><br><br>
		<div align="left" style="float:left">
		<br><input type="text" id="firstname" name="firstname" placeholder = "First Name" required="" size="15"><br>
		</div>
		<div align="right">
		<br><input type="text" id="lastname" name="lastname" placeholder = "Last Name" required=""><br>
		</div>
		<div align="left" style="float:left">
		<br><input type="text" id="address" name="address" placeholder = "Address" required=""><br>
		</div>
		<div align="right">
		<br><input type="email" id="email" name="email" placeholder = "Email" required=""><br>
		</div>
		<div align="left" style="float:left">
		<br><input type="text" id="phone" name="phone" placeholder = "Phone Number" required=""><br>
		</div>
		<div align="right">
		<br><input type="password" id="password" name="password" placeholder = "Password" required=""><br><br>
		</div>
		<input type="checkbox" onclick="myFunction()">Show Password<br><br>
		<b>Choose the following if you register as an employee:</b> <br><br>
		<label for="cars">Position:</label>
		<select id="position" name="position">
				<option value="IT">IT</option>
				<option value="Marketing">Marketing</option>
				<option value="Accounting">Accounting</option>
				<option value="Sale">Sale</option>
				<option value="Security">Security</option>
		</select><br><br>
		<label for="cars">Location:</label>
		<select id="location" name="location">
				<option value="China">China</option>
				<option value="Canada">Canada</option>
				<option value="America">America</option>
				<option value="France">France</option>
				<option value="Japan">Japan</option>
				<option value="Singapore">Singapore</option>
		</select><br><br>
		<input class="btn regBtn" type="submit" value="register">
	</form>
	</div>
	</body>
</html>
