<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Greeting</title>
</head>
<body>
<form:form action="/h/addHotel" modelAttribute="hotel">
	Name:
	<form:input path="name"/>
	<form:errors path="name"/><br/>
	
	Description:
	<form:input path="description"/>
	<form:errors path="description"/><br/>

	<input type="submit"/><form:errors/>
</form:form>
</body>
</html>