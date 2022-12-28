<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary E-V</title>
</head>
<body>
<h1>Simple E-V Dictionary
</h1>
<br/>
<form action="${pageContext.request.contextPath}/lookup" method="get">
    <label>
        <input type="text" placeholder="input your word" name="input">
    </label>
    <span><input type="submit" value="Lookup"></span>
</form>
<c:if test="${result != null}">
    <h3>Từ cần tìm là "${result}"</h3>
</c:if>
</body>
</html>