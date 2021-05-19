function deleteQuestion(id) {
    fetch("/question?id=" + id, {method: "DELETE"})
        .then(res => {
            window.location.href = "/questions"
            console.log(res)
        })
        .catch(err => document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/> `)

}

fetch("/question", {method: "GET"})
    .then(res => res.json())
    .then(question => {
        let questionList = document.getElementById("questionList");
        const list = question.map(question =>
            `<li class="list-group-item">${question.id}. ${question.title}${localStorage.getItem("username") === 'admin' ?
                (`<div>
                    <a onClick="deleteQuestion(${question.id})" class="btn btn-danger edit-btn">Delete</a>
                    <a href="questionUpdate?id=${question.id}"
                       class="btn btn-info edit-btn">Edit</a>
                </div>`) : ""}
                </li>`
        ).join("");
        questionList.innerHTML = list;

    })
    .catch(err => document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/> `)

