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
            </div>
<c:if test="${not empty username and username eq 'admin'}">
    <div class="col-12"><a href="questionAdd" class="btn btn-info">Add Question</a></div>
</c:if>
            <div class="col-md-12" style="margin-top: 20px;">
                <ul class="list-group">
                    <c:forEach var="question" items="${questionList}">
                        <li class="list-group-item">
                                ${question.id}. ${question.title}
                            <c:if test="${not empty username and username eq 'admin'}">
                                <a onclick="deleteQuestion(${question.id})" class="btn btn-danger edit-btn">Delete</a>
                                <a href="questionUpdate?id=${question.id}"
                                   class="btn btn-info edit-btn">Edit</a>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
<script>
    function deleteQuestion(id) {
        fetch("/question?id=" + id, {method: "DELETE"})
            .then(res => {
                window.location.href = "/questions"
                console.log(res)
            })
            .catch(err => console.log(err))

    }

</script>
</html>

