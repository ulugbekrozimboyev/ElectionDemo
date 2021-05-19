let index = 0
let form = document.getElementById("form")
const params = new URLSearchParams(window.location.search)

function setMoreInfo(moreInformation, html) {
    let moreInfo = [];
    for (let k in moreInformation) {
        let inputs = `<div class="input-group-prepend my-2">
        <input type="text" required name="key-##index" value= ##keyValue class="form-control ">
          <input type="text" required name="value-##index" value= ##value class="form-control">
      </div>`.replaceAll("##keyValue", k).replaceAll("##value", moreInformation[k]).replaceAll("##index", index)
        index++;
        moreInfo.push(inputs);
        console.log(inputs)
    }
    return html.replace("##moreInfo", moreInfo.join(""));
}

function getHtml(candidate) {
    return ` <form method="post" onsubmit="onSubmit(event)">
        <input type="hidden" name="id" value="${candidate.id}">
        <div class="form-group">
          <label for="fullName">Fullname</label>
          <input type="text" class="form-control" name="fullName" id="fullName"
                 placeholder="Enter candidate's fullname" value="${candidate.fullName}">
        </div>
        <div class="form-group">
          <label for="currentJob">Current Job</label>
          <input type="text" name="currentJob" class="form-control" id="currentJob"
                 placeholder="Enter candidate's current job" value="${candidate.currentJob}">
        </div>
        <div class="form-group">
          <label for="about">About area</label>
          <textarea class="form-control" name="about" id="about" rows="3">${candidate.about}</textarea>
        </div>
        <h6>More details</h6>
        <div id="inputs">
          ##moreInfo
        </div>
        <button class="btn btn-primary btn-block">Update</button>
      </form>`
}

function onSubmit(e) {
    e.preventDefault();
    let body = {}
    const data = new FormData(e.target);
    body["id"] = data.get("id");
    body["currentJob"] = data.get("currentJob");
    body["fullName"] = data.get("fullName");
    body["about"] = data.get("about");
    body["currentJob"] = data.get("currentJob");
    body["currentJob"] = data.get("currentJob");
    let moreInfo = {}
    console.log(data.get("key-0"), data.get("value-0"))
    for (let i = 0; i < index; i++) {
        moreInfo[data.get("key-" + i)] = data.get("value-" + i)
    }
    body["moreInformation"] = moreInfo;
    console.log(body)
    fetch("/candidate?id=" + body.id, {method: "PUT", body: JSON.stringify(body)})
        .then(res => window.location.href = "/candidates")
        .catch(() => document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>  `)

}

if (params.has('id')) {
    let id = params.get("id");
    fetch("/candidate?id=" + id, {method: "GET"})
        .then(res => res.json())
        .then(res => {
            console.log(res)
            let candidate = res
            let htmlData = getHtml(candidate);
            htmlData = setMoreInfo(candidate.moreInformation, htmlData)
            form.innerHTML = htmlData;
        })
        .catch((eror) => {
            console.log(eror);
            document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>`
        })
}
