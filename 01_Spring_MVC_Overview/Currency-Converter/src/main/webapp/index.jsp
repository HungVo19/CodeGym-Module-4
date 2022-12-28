<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>
<body>
<h1>Currency Converter
</h1>
<form action="${pageContext.request.contextPath}/converter" method="post">
    <label>
        <input type="number" placeholder="input USD" name="usd" step="0.01" required>
    </label>
    <input type="submit" value="Convert"/>
</form>
<h3><c:if test="${result != null}">
    <c:out value="${result}"/>
</c:if></h3>
</body>
</html>