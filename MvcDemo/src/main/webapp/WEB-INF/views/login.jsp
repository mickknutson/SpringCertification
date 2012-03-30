<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html><head><title>Login Page</title></head><body onload='document.f.j_username.focus();'>
<h3>Custome Login with Username and Password</h3><form name='f' action='<c:url value="/j_spring_security_check"/>' method='POST'>
 <table>
    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit"/></td></tr>
    <tr><td colspan='2'><input name="reset" type="reset"/></td></tr>
  </table>
</form></body></html>
