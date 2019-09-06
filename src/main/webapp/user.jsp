<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>
	<h1>Welcome to PHILIPS PAGE:</h1>

	<form action="user">
		USERNAME : <input name="username" type="text" /><br /> 
		CONTACT : <input name="contact" type="number" /><br /> 
		HOSPIAL TYPE : <select name="hospital">
			<option value="Hospital Tier 1">Hospital Tier 1</option>
			<option value="Hospital Tier 2">Hospital Tier 2</option>
			<option value="Nursing Home">Nursing Home</option>
		</select> <br>
		<br> <input id="submit" type="submit" value="ENTER CHATBOT" />
	</form>
	
</body>
</html>