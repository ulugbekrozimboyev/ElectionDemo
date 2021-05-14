<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/9/21
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../index.jsp" %>
<html>
<head>
    <title>Answer to Question</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="error"></div>
            <form method="post" id="form">
                <div id="quizBody"></div>
                <input type="submit" class="btn btn-info btn-block mt-5" value="Submit">
            </form>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/answer.js">

</script>
</html>
