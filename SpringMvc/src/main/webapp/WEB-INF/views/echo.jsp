<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Echo</title>
</head>
<body>
<h1>
    Echo Message: ${message}
</h1>
<h2>
    Variables from JNDI
</h2>
<P>${id}</P>


<P>Go <a href="<c:url value="/"/>">Home</a></P>

</body>
</html>
