<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Hotels</title>
</head>
<body>
	<c:forEach items="${rooms}" var="r">
	<p>Max guests: ${r.maxGuests}, Description:  ${r.description}, Category:  ${r.category}</p>
	</c:forEach>
	<br/>
	<a href="/r/newRoom?hotel=${hotel}">[add room]</a>
	
	<br/>
</body>
</html>