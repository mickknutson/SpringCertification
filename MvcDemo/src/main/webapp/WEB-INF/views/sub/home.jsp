<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sub Home Page</title>
</head>
<body>
<h1>
	${msg} (new)
</h1>

<P>Hello page!  the current time is ${serverTime}</P>

<P>enter <a href="<c:url value="/echo/mickknutson"/>">/SpringMvc/echo/mickknutson</a></P>





<P>enter <a href="<c:url value="/open"/>">un-secured area</a></P>







<P>enter <a href="<c:url value="/secured"/>">secured area</a></P>

<P>enter <a href="<c:url value="/secured/admin"/>">secured admin area</a></P>

<P>enter <a href="<c:url value="/echo/hello_there"/>">/SpringMvc/echo/hello_there</a></P>

</body>
</html>
