<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

Image:
<img src="<c:url value="/images/BLiNCLogo_5x5_300dpi.jpg"/>" alt="BASE Logic, Inc logo" height="100px" width="100px" />

<P>  The time on the server is ${serverTime}. </P>

<P>enter <a href="<c:url value="/echo/mickknutson"/>">/echo/mickknutson</a></P>

<P>enter <a href="<c:url value="/open"/>">un-secured area</a></P>

<P>enter <a href="<c:url value="/fooJson"/>">Foo Json</a></P>

<P>enter <a href="<c:url value="/secured"/>">secured area</a></P>

<P>enter <a href="<c:url value="/secured/admin"/>">secured admin area</a></P>


</body>
</html>
