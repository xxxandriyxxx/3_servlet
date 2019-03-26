<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
index
<%--<h2>${msg} ${name}</h2>--%>

<%--<form action="/home" method="get">--%>
<form action="/home" method="post">
    <%--<input type="text" name="msg" placeholder="msg">--%>
    <input type="text" name="name" placeholder="name">
    <input type="submit" name="" placeholder="">
</form>
<%--<div>${users}</div>--%>
<c:forEach items="${users}" var="u">
    <div>
            ${u.id}
            ${u.name}
    </div>
</c:forEach>
</body>
</html>
