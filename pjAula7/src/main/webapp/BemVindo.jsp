<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro Exemplo de Java Server Pages - JSP</title>
</head>
<body>
	Time: <%= new java.util.Date() %>
	Looping: <%for(int i=0; i<10; i++){
				out.println(i);
			}%>
</body>
</html>