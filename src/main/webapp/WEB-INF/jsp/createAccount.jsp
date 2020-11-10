<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error{
color:red;
font-size: 15px;
}
</style>
<title>Create an Account</title>
</head>
<body>

<h1>Enter Account details</h1>
<form:form commandName="aNewAccount" method="post" action="doCreate">
<table>
<tr><td>First Name:<form:input path="firstName" type="text" name="firstname"/></td></tr>
<form:errors path="firstName" cssClass="error"/>
<tr><td>Last Name:<form:input path="lastName" type="text" name="lastname"/></td></tr>
<form:errors path="lastName" cssClass="error"/>
<tr><td><input type="submit" value="create"/></td></tr>
</table>
</form:form>
</body>
</html>