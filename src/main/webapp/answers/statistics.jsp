<%--
  Created by IntelliJ IDEA.
  User: samandar
  Date: 5/9/21
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../index.jsp" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<div class="container">
    <div class="row mt-5">
        <div class="col-md-12">
            <h1>Statistics</h1>
            <c:forEach var="statistic" items="${statistics}" >
                <div class="card mt-2">
                    <div class="card-body">
                        <h3 class="card-title">${statistic.getCandidate().getFullName()}</h3>
                        <p class="card-text ml-2 text-mute" >${statistic.getCandidate().getAbout()}</p>
                        <div id="accordion">
                            <c:forEach items="${statistic.getStatistics()}" var="entry">
                                <div >
                                    <div id="head-${entry.key}-${statistic.getCandidate().getId()}">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link" style="text-decoration: none" data-toggle="collapse"
                                                    data-target="#collapse-${entry.key}-${statistic.getCandidate().getId()}"
                                                    aria-expanded="true"
                                                    aria-controls="collapse-${entry.key}-${statistic.getCandidate().getId()}">
                                                    ${entry.key} - ${entry.value.getCount()}
                                            </button>
                                        </h5>
                                    </div>

                                    <div id="collapse-${entry.key}-${statistic.getCandidate().getId()}" class="collapse"
                                         style="margin-left: 30px"
                                         aria-labelledby="head-${entry.key}-${statistic.getCandidate().getId()}"
                                         data-parent="#accordion">
                                        <div>
                                            <c:forEach items="${entry.value.getQuestions()}" var="question"
                                                       varStatus="loop">
                                                <h6>${loop.index + 1}. ${question.title}</h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
