<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/1/2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../index.jsp" %>

<html>
<head>
    <title>${message}</title>

    <style type="text/css">
        .list-group-item {
            margin-top: 10px;
            font-size: 18px;
            font-weight: 600;
        }

        .list-group-item .btn {
            float: right;
            margin-left: 10px;
        }
    </style>

</head>
<body>
<div class="container mt">
    <div class="row mt-3">
        <div class="col-md-12">
            <h1>Questions</h1>
            <div id="error"></div>
        </div>
<c:if test="${not empty username and username eq 'admin'}">
    <div class="col-12"><a href="questionAdd" class="btn btn-info">Add Question</a></div>
</c:if>
        <div class="col-md-12" style="margin-top: 20px;">
            <ul class="list-group" id="questionList">

            </ul>
        </div>
    </div>
</div>
</body>
<script>
    localStorage.setItem("username", '${username}')
</script>
<script src="${pageContext.request.contextPath}/js/questionList.js"></script>
</html>

