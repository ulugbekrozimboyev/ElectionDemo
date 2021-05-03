<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/3/2021
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../index.jsp" %>

<style type="text/css">
    .login-content {
        padding: 40px;
        background-color: #f8f9fa;
    }

    .login-content form .input-group {
        margin-bottom: 10px;
    }

    .login-content form .error {
        color: red;
        width: 100%;
        text-align: center;
        margin-top: 10px;
    }

</style>

<div class="container mt">
    <div class="row mt-3">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <h1 style="text-align: center"> LOGIN </h1>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-md-3"></div>
        <div class="col-md-6 login-content">
            <form method="post" action="login">
                <div class="input-group">
                    <input type="text" class="form-control" name="username" placeholder="Username">
                </div>
                <div class="input-group">
                    <input type="password" class="form-control" name="password" placeholder="password">
                </div>
                <br/>
                <div class="col-md-12" style="text-align: center">
                    <button class="btn btn-info add-question" type="submit">Login</button>
                </div>

                <c:if test="${not empty message}">
                    <label class="error">${message}</label>
                </c:if>
            </form>
        </div>
    </div>
</div>