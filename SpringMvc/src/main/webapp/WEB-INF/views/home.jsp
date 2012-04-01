<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<h2>Images:</h2>
<P><img src="<c:url value="/images/duke"/>" alt="BASE Logic, Inc logo" height="100px" width="100px" />&nbsp;
<img src="<c:url value="/images/java"/>" alt="BASE Logic, Inc logo" height="100px" width="100px" />&nbsp;
<img src="<c:url value="/images/starbucks"/>" alt="BASE Logic, Inc logo" height="100px" width="100px" />&nbsp;
<img src="<c:url value="/images/blinc"/>" alt="BASE Logic, Inc logo" height="100px" width="100px" /></P>

<P>  The time on the server is ${serverTime}. </P>

<P>enter <a href="<c:url value="/echo/command/mickknutson"/>">/echo/command/mickknutson</a></P>

<P>enter <a href="<c:url value="/json"/>">Json</a></P>
<P>enter <a href="<c:url value="/json/MvcDemo"/>">Json/MvcDemo</a></P>
<P>enter <a href="<c:url value="/json/SpringCore/Demos"/>">Json/SpringCore/Demos</a></P>



<P>enter <a href="<c:url value="/open"/>">un-secured area</a></P>

<P>enter <a href="<c:url value="/secured"/>">secured area</a></P>

<P>enter <a href="<c:url value="/secured/customer/home"/>">secured customer area</a></P>

<P>enter <a href="<c:url value="/secured/user/home"/>">secured user area</a></P>

<P>enter <a href="<c:url value="/secured/admin/home"/>">secured admin area</a></P>


</body>
</html>
