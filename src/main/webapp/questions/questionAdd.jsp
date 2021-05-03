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
            <h1> Add a question</h1>
        </div>
        <div class="col-md-12">
            <form method="post" action="questionAdd">
                <div class="input-group">
                    <input type="text" class="form-control" name="title">
                </div>
                <button class="btn btn-info add-question" type="submit">Add</button>
            </form>
        </div>
    </div>
</div>