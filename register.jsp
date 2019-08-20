<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

body{
	text-align: center;
}


.registerContainer{
	background-color: teal;
	width: 200px;
	height: 350px;
	margin-right: 10px;
	float: left;
	
}

.checkingwithid{
	background: aqua;
	width: 200px;
	height: 100px;
	margin-right: 10px;
	float: left;
}

.checkwithusername{
	background-color: lime;
	width: 200px;
	height: 100px;
	margin-right: 10px;
	float: left;
}

.checkWWithLoginAndPassword{
	background: gray;
	width: 200px;
	height: 150px;
	margin-right: 10px;
	float: left;
}

</style>
</head>
<body>
	<div>
	<div class="registerContainer">
		<form action="/adduser">
		<p>Saving User</p>
			<p> User Id </p>
			<input type="number" name="userId">
			<p> User Name </p>
			<input type="text" name="userName">
			<p> Email </p>
			<input type="text" name="email">
			<p> Password </p>
			<input type="password" name="password"><br>
			<input type="submit" name="Register">
		</form>
	</div>
	
	
	<div class="checkingwithid">
		<form action="/checkWithId">
		<p> Check with User Id</p>
			<input type="number" name="userId"><br>
			<input type="submit" name="check with Id">
		</form>
	</div>
	
	<div class="checkwithusername">
		<form action="/checkWithUserName">
		<p>Check With User Name</p>
			<input type="text" name="userName"><br>
			<input type="submit" name="check with user name">
		</form>
	</div>
	
	<div class="checkWWithLoginAndPassword">
		<form action="/checkWithUserNameAndPassword">
		<p>Check With User Name And Password</p>
			<input type="text" name="userName"><br>
			<input type="text" name="password"><br>
			<input type="submit" name="check with user name and password">
		</form>
	</div>
	<div>
		<form action="/weather">
			<input type="text" name="city">
			<input type="submit" name="Submit">
		</form>
	</div>
</div>
</body>
</html>