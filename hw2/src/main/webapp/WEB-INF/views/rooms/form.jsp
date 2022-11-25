<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Greeting</title>
</head>
<body>
<form:form action="/r/addRoom" modelAttribute="room">
	Category:
	<form:input path="category"/>
	<form:errors path="category"/><br/>

	Description:
	<form:input path="description"/>
	<form:errors path="description"/><br/>
	Guests:
	<form:input path="maxGuests" type="number"/>
	<form:errors path="maxGuests"/><br/>
	
	<input type="hidden" name="hotel" value="${hotel}">
	
	<input type="submit"/><form:errors/>
</form:form>
</body>
</html>