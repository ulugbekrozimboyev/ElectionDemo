<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/2/21
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../index.jsp" %>
<html>
<head>
  <title>${title}</title>
</head>
<body>
<div class="container">
  <div class="row mt-4">
    <div class="col-12"><h1>${title}</h1></div>
    <div class="col-12">
      <form method="post" action="updateCandidate">
        <input type="hidden" name="id" value="${candidate.getId()}">
        <div class="form-group">
          <label for="fullName">Fullname</label>
          <input type="text" class="form-control" name="fullName" id="fullName"
                 placeholder="Enter candidate's fullname" value="${candidate.getFullName()}">
        </div>
        <div class="form-group">
          <label for="currentJob">Current Job</label>
          <input type="text" name="currentJob" class="form-control" id="currentJob"
                 placeholder="Enter candidate's current job" value="${candidate.getCurrentJob()}">
        </div>
        <div class="form-group">
          <label for="about">About area</label>
          <textarea class="form-control" name="about" id="about" rows="3">${candidate.getAbout()}</textarea>
        </div>
        <h6>More details</h6>
        <div id="inputs">
          <c:forEach items="${candidate.getMoreInformation()}" var="entry" varStatus="loop">
            <div class="input-group-prepend my-2">
              <input type="text" required name="key-${loop.index}" value="${entry.key}" class="form-control ">
              <input type="text" required name="value-${loop.index  }" value="${entry.value}" class="form-control">
            </div>
          </c:forEach>
        </div>
        <button class="btn btn-primary btn-block">Update</button>
      </form>
    </div>
  </div>
</div>
</body>
<script>
  let index = 0
</script>
</html>
