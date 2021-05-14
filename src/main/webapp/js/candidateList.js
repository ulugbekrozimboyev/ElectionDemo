function setMoreInfoToCard(moreInformation, html) {
    let list = []
    for (let i in moreInformation) {
        list.push(`<li class="list-group-item"><b style="text-transform: capitalize">key:</b> value</li>`.replace("key", i).replace("value", moreInformation[i]));
    }
    console.log("hey")
    return html.replace("##map", list.join(""))

}

function getCard(candidates) {
    let htmls = []


    for (let candidate of candidates) {
        console.log(candidate)
        let data =
            localStorage.getItem("username") === 'admin' ? (
                ` <div class="card-body"><a href=${"updateCandidate?id=" + candidate.id}
                                          class="btn btn-info">Update</a>
                <button class="btn btn-danger" onclick= "deleteCandidate(${candidate.id})" >Delete</button>
            </div>`) : ""
        let html = `<div class="card mt-3">
          <div class="card-body">
            <h5 class="card-title">${candidate.fullName} ID(#${candidate.id})</h5>
            <p class="card-text">${candidate.about}</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item"><b>Job:</b> ${candidate.currentJob}</li>
           ##map
          </ul>
          ${data}
             
          
        </div>`;
        html = setMoreInfoToCard(candidate.moreInformation, html);
        htmls.push(html);
    }
    return htmls.join("");

}


fetch("/candidate", {method: "GET"})
    .then(res => res.json())
    .then(candidate => {
        let candidates = document.getElementById("list")
        let html = getCard(candidate);
        candidates.innerHTML = html;
    })
    .catch((err) => {
        console.log(err);
        document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>`
    })

function deleteCandidate(idCandidate) {
    fetch("/candidate?id=" + idCandidate, {method: "DELETE"})
        .then(res => {
            window.location.href = "/candidates"
            console.log(res)
        })
        .catch(err => console.log(err))

}
