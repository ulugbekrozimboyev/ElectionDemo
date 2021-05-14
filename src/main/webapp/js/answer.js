let questions = [];
fetch("/quiz", {method: "GET"})
    .then(res => res.json())
    .then(res => {
        let html = res.questions.map((question, loop) => {
            questions.push(question.id);
            return ` <div style="margin-top: 30px">
                <h4><b>${loop + 1}. ${question.title}</b></h4>
                ${res.answer.map((ans, index) => {
                return `<div class="form-check" style="margin-left: 30px">
                   <input class="form-check-input" type="radio" value="${ans}"
                          id="id-${question.id}-${ans}"
                          name="name-${question.id}">
                       <label class="form-check-label" for="id-${question.id}-${ans}">
                           ${ans}
                       </label>
               </div>`
            }).join("")}
            </div>`
        })
        document.getElementById("quizBody").innerHTML = html.join("");
    })
    .catch(err => {
        console.log(err)
        document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>`

    })

function getRadioVal(form, name) {
    let val;
    let radios = form.elements[name];

    for (let i = 0, len = radios.length; i < len; i++) {
        if (radios[i].checked) {
            val = radios[i].value;
            break;
        }
    }
    return val;
}

document.getElementById('form').onsubmit = function (e) {
    e.preventDefault();
    let data = []
    questions.forEach(questionId => {
        data.push({
            questionId: questionId,
            answer: getRadioVal(this, 'name-' + questionId)
        });
    })
    console.log(
        "hey"
    )
    fetch("/quiz", {method: "POST", body: JSON.stringify(data)})
        .then(res => window.location.href = "/")
        .catch(err => {
            console.log(err);
            document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>`
        })
}
