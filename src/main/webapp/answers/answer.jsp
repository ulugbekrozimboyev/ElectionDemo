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
    <title>Answer to Qestion</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="/answer" method="post">
                <c:forEach var="question" items="${questions}" varStatus="loop">
                    <div style="margin-top: 30px">
                        <h4><b>${loop.index + 1}. ${question.getTitle()}</b></h4>
                        <c:forEach var="option" items="${answerOptions}">
                            <div class="form-check" style="margin-left: 30px">

                                <input class="form-check-input" type="radio" value="${option}" id="id-${loop.index + 1}-${option}"
                                       name="${question.getId()}">
                                <label class="form-check-label" for="id-${loop.index + 1}-${option}">
                                        ${option}
                                </label>

                            </div>
                        </c:forEach>
                    </div>
                </c:forEach>
                <input type="submit" class="btn btn-info btn-block mt-5" value="Submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
