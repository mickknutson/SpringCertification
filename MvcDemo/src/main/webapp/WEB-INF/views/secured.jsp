<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Secured Location</title>
</head>
<body>
<h1>
	Secured Location
</h1>

<P>This is secured.</P>
<P>Go <a href="<c:url value="/j_spring_security_check"/>">Home</a></P>



<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

</body>
</html>
