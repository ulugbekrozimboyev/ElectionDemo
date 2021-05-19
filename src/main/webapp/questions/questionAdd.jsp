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
            <div id="error"></div>
        </div>
        <div class="col-md-12">
            <form method="post" onsubmit="onSubmit(event)">
                <div class="input-group">
                    <input type="text" class="form-control" name="title">
                </div>
                <button class="btn btn-info add-question" type="submit">Add</button>
            </form>
        </div>
    </div>
</div>
<script>
    const onSubmit = (event) => {
        event.preventDefault();
        let body = {}
        const data = new FormData(event.target);
        body["title"] = data.get("title");
        fetch("/question", {method: "POST", body: JSON.stringify(body)})
            .then(res => window.location.href = "/questions")
            .catch(err => document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/> `)
    }
</script>
