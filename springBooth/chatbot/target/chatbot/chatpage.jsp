<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="chat" >
	
	<h1>Welcome to chatbot:</h1>
	<b> ${username} </b> : <i> ${received}</i> <br/>
	<b>bot</b> : <i>${respond}</i><br/>
		<input type="hidden" name="username" value="${username}" />
		<input name="message" type="text" /><br /> 
		<input type="submit" value="SEND" />
	</form>
</body>
</html>