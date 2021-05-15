<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/2/21
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../index.jsp" %>
<html>
<body>
<div class="container mt">
  <div class="row mt-3">
    <div class="col-12"><h1 class="title">Candidates</h1></div>
    <div class="col-12"><a href="candidateAdd" class="btn btn-info">Add Candidate</a></div>
    <div class="col-12">
      <c:forEach var="candidate" items="${candidates}">
        <div class="card mt-3">
          <div class="card-body">
            <h5 class="card-title">${candidate.getFullName().toUpperCase()} ID(#${candidate.getId()})</h5>
            <p class="card-text">${candidate.getAbout()}</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item"><b>Job:</b> ${candidate.getCurrentJob()}</li>
            <c:forEach items="${candidate.getParams()}" var="entry">
              <li class="list-group-item"><b style="text-transform: capitalize">${entry.getKey()}:</b> ${entry.getValue()}</li>
            </c:forEach>
          </ul>
          <div class="card-body">
            <a href="updateCandidate?id=${candidate.getId()}" class="btn btn-info">Update</a>
            <button onClick="deleteCandidate(${candidate.getId()})" class="btn btn-danger">Delete</button>

          </div>
        </div>
      </c:forEach>

    </div>
  </div>
</div>
</body>
<script>
  function deleteCandidate(idCandidate) {
    fetch("/candidateDelete?id=" + idCandidate, {method: "DELETE"})
            .then(res => {
              //this is not necessary, we will redirect it from servlet
              // window.location.href="/candidates"
              console.log(res)
            })
            .catch(err => console.log(err))
  }
</script>
</html>
