<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Hotels</title>
</head>
<body>
	<c:forEach items="${bookings}" var="b">
	<p>Hotel: ${b.hotel.name}, Dates:  ${b.start} to ${b.end}  for ${b.guests} <a href="/b/deleteBooking?id=${b.id}">[delete]</a></p>
	</c:forEach><br/>
	<a href="/b/newBooking">new booking</a>
		
</body>
</html>