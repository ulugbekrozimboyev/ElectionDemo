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
  <title>Add Candidate</title>
</head>
<body>
<div class="container">
  <div class="row mt-4">
    <div id="error"></div>
    <div class="col-12"><h1>Add Candidate</h1></div>
    <div class="col-12">
      <form method="post" onsubmit="onSubmit(event)">
        <div class="form-group">
          <label for="fullName">Fullname</label>
          <input type="text" class="form-control" name="fullName" id="fullName"
                 placeholder="Enter candidate's fullname">
        </div>
        <div class="form-group">
          <label for="currentJob">Current Job</label>
          <input type="text" name="currentJob" class="form-control" id="currentJob"
                 placeholder="Enter candidate's current job">
        </div>
        <div class="form-group">
          <label for="about">About area</label>
          <textarea class="form-control" name="about" id="about" rows="3"></textarea>
        </div>
        <h6>More details</h6>
        <div id="inputs">
        </div>
        <button type="button" class="btn btn-success btn-block my-2" onclick="addInput()">Add</button>
        <button type="submit" class="btn btn-primary btn-block">Submit</button>
      </form>
    </div>
  </div>
</div>
</body>
<script>
  let index = 0

  function addInput() {
    let parser = new DOMParser();
    document.getElementById("inputs").append(parser.parseFromString(
            `
     <div class="input-group-prepend my-2">
         <input type="text" required name="key-#Id" class="form-control ">
        <input type="text" required name="value-#Id" class="form-control">
    </div>`.replace("#Id", index).replace("#Id", index++)
            , "text/html").body);
  }

  function onSubmit(e) {
    e.preventDefault();
    let body = {}
    const data = new FormData(e.target);
    body["currentJob"] = data.get("currentJob");
    body["fullName"] = data.get("fullName");
    body["about"] = data.get("about");
    body["currentJob"] = data.get("currentJob");
    body["currentJob"] = data.get("currentJob");
    let moreInfo = {}
    for (let i = 0; i < index; i++) {
      moreInfo[data.get("key-" + i)] = data.get("value-" + i)
    }
    body["moreInformation"] = moreInfo;
    console.log(body)
    fetch("/candidate", {method: "POST", body: JSON.stringify(body)})
            .then(res => window.location.href = "/candidates")
            .catch(() => document.getElementById("error").innerText = `<div class="bg-danger"> <p>Something is wrong</p><div/>  `)

  }


</script>
</html>
