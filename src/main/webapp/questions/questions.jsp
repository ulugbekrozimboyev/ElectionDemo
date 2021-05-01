<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/1/2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${message}</title>
</head>
<body>
    <h2>Questions</h2>
    <ul>
        <c:forEach var="question" items="${questionList}">
            <li>${question.id}. ${question.title}</li>
        </c:forEach>
    </ul>
</body>
</html>
