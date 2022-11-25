<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create new Booking</title>
</head>
<body>
<form:form action="/b/addBooking" modelAttribute="booking">
	
	Hotel:
	<select name="hotelName">
		<c:forEach items="${hotels}" var="option">
	    	<option value="${option}">${option}</option>
		</c:forEach>
	</select><br/>

	Start:
	<form:input type="date" path="start"/>
	<form:errors path="start"/><br/>

	End:
	<form:input type="date" path="end"/>
	<form:errors path="end"/><br/>	
	
	<input type="submit"/><form:errors/>
</form:form>
</body>
</html>