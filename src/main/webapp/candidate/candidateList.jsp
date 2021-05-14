<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/2/21
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ include file="../index.jsp" %>
<head>
    <title>Candidates</title>
</head>
<html>
<body>
<div class="container mt-3">
    <div class="row mt-3">
        <div class="col-12"><h1 class="title">Candidates</h1>
            <div id="error"></div>
        </div>
        <c:if test="${not empty username and username =='admin'}">
            <div class="col-12"><a href="/candidateAdd" class="btn btn-info">Add Candidate</a></div>
        </c:if>
        <div class="col-12" id="list">

        </div>
    </div>
</div>
</body>
<script>
    localStorage.setItem("username", '${username}')
</script>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/js/candidateList.js"></script>
</html>
