<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/9/21
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../index.jsp" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-md-12">
            <h1>Statistics</h1>
            <div id="error"></div>
            <div id="statistics-body"></div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/statistics.js"></script>
</html>
