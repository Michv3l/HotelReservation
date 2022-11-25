<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Hotels</title>
</head>
<body>
	<c:forEach items="${hotels}" var="hotel">
	<p>Name: ${hotel.name}, Description:  ${hotel.description} <a href="/r/rooms?hotel=${hotel.name}">[see rooms]</a></p>
	</c:forEach><br/>
	<a href="/h/newHotel">new hotel</a>
	
</body>
</html>