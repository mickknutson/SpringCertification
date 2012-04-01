<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>un-Secured Location</title>
</head>
<body>
<h1>
	this is an un-Secured Page!
</h1>

<P>This is NOT secured.</P>
<P>Go <a href="<c:url value="/"/>">Home</a></P>
</body>
</html>
