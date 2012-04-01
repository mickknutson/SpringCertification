<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Secured Location</title>
</head>
<body>

<h1>
	Secured Location
</h1>

<P>This is secured area.</P>
<P>Your authority type is ${authority}</P>
<P>Go <a href="<c:url value="/"/>">Home</a></P>



<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

</body>
</html>
