<%--
  Created by IntelliJ IDEA.
  User: ulugbek
  Date: 5/3/21
  Time: 05:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../index.jsp" %>

<style type="text/css">
    .add-question {
        margin-top: 10px;
    }
</style>

<div class="container mt">
    <div class="row mt-3">
        <div class="col-md-12">
            <h1>Update Question</h1>
            <div id="error"></div>
        </div>
        <div class="col-md-12">
            <form onsubmit="onSubmit(event)">
                <div class="input-group" id="questionInputs">
                </div>
                <button class="btn btn-info add-question" type="submit">Update</button>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/questionUpdate.js"></script>
