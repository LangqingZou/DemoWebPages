<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript">
	function validate(){
		//var email = document.getElementById("email");
		//var password = document.getElementById("password"); 
		var info = '<%=session.getAttribute("InfoAlert")%>';
		//check email
		if(info=='false'){
			alert("Email or password uncorrect. Please check again.");
			return false;
		}
		return true;
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
		padding:50px 110px;
		padding-bottom: 100px;
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
</head>

<!--show the login page  -->

<body>
<div class="container">
	<p class="text-center" style="left:10%; right:10%;text-align: center;font-size:300%">LOGIN</p>
	<form method="post" action="login" onSubmit="validate();">
	<br><input type="email" id="email" name="email" placeholder = "Email" required=""><br>
	<br><input type="password" id="password" name="password" placeholder = "Password" required=""><br><br>
	<input type="checkbox" onclick="myFunction()">Show Password<br><br>
	<div align="left" style="float:left">
		<button class="btn loginBtn" type="submit" value="login">Login</button>
	</div>
	</form>
	<div align="right">
		<button class="btn regBtn" type="button" value="register" onclick="window.location.href='Register.jsp'">Register</button>
	</div>
</div>
</body>
</html>