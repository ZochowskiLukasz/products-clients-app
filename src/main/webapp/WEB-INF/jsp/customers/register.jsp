<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Customer</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
    <h2>Register customer</h2>

    <c:if test="${not empty errorMessage}">
		<div>${errorMessage}</div>
	</c:if>

	<form:form method="POST" modelAttribute="customerModel" action="/customers/register">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" id="firstName"/></td>
				<td><form:errors path="firstName" id="firstName"/></td>
			</tr>
			<tr>
            	<td>Second Name</td>
            	<td><form:input path="secondName" id="secondName"/></td>
            	<td><form:errors path="secondName" id="secondName"/></td>
            </tr>
            <tr>
                 <td>Login</td>
                 <td><form:input path="login" id="login"/></td>
                 <td><form:errors path="login" id="login"/></td>
            </tr>
            <tr>
                 <td>Password</td>
                 <td><form:password path="password" id="password"/></td>
                 <td><form:errors path="password" id="password"/></td>
            </tr>

            <tr>
                 <td>Email</td>
                 <td><form:input path="email" id="email"/></td>
                 <td><form:errors path="email" id="email"/></td>
            </tr>
			<tr>
            	<td>Customer Type</td>
            	<td><form:select path="type" id="type" items="${customerTypes}"/>
            	</td>
            </tr>

            <tr>
                 <td></td>
                 <td>
				 <c:choose>
					 <c:when test="${edit}">
						<input type="submit" value="Edit Customer"/>
					 </c:when>
					 <c:otherwise>
						<input type="submit" value="Register Customer"/>
					 </c:otherwise>
			     </c:choose>
                 </td>
            </tr>
            <form:hidden path="id" id="id"/>
		</table>

	</form:form>

</body>
</html>