const params = new URLSearchParams(window.location.search)
const onSubmit = (event) => {
    event.preventDefault();
    let body = {}
    const data = new FormData(event.target);
    body["title"] = data.get("title");
    body["id"] = data.get("id");
    fetch("/question", {method: "PUT", body: JSON.stringify(body)})
        .then(res => window.location.href = "/questions")
        .catch(err => document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/> `)
}
if (params.has('id')) {
    let id = params.get("id");
    console.log(id)
    fetch("/question?id=" + id, {method: "GET"})
        .then(res => res.json())
        .then(question => {
            document.getElementById("questionInputs").innerHTML =
                `    <input type="hidden" name="id" value="${question["id"]}">
                    <input type="text" class="form-control" name="title" value="${question["title"]}">`
        })
        .catch(err => document.getElementById("error").innerText = `<div class="bg-danger"> <p>Something is wrong</p><div/> `)
}
