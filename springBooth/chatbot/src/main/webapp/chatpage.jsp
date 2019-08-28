<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHATBOT</title>
</head>
<body>
	
	<form action="chat" >
	
	<h1>Welcome to chatbot:</h1>
	<b> ${username} </b> : <i> ${received}</i> <br/>
	<b>bot</b> : <i>${respond}</i><br/>
		<input type="hidden" name="username" value="${username}" />
		<input name="message" type="text" id="my-input" autofocus="autofocus" /><br />
		<script>
			if (!("autofocus" in document.createElement("input"))) {
				document.getElementById("my-input").focus();
			}
		</script> 
		<input type="submit" value="SEND" />
	</form>
</body>
</html>
