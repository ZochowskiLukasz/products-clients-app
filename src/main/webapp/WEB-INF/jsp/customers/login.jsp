<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
    <head>
        <title>Spring Security Example </title>
    </head>
    <body>
        <form action="/customers/login" method="post">
            <div><label> Login : <input type="text" name="login"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>

            <div><input type="submit" value="Sign In"/></div>
        </form>
    </body>
</html>