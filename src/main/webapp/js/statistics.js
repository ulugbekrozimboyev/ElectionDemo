function getAccardion(statistics, candidate) {
    let statisticHtml =
        Object.keys(statistics).map(k => {
            return `<div >
                                    <div id="head-${k}-${candidate.id}">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link" style="text-decoration: none" data-toggle="collapse"
                                                    data-target="#collapse-${k}-${candidate.id}"
                                                    aria-expanded="true"
                                                    aria-controls="collapse-${k}-${candidate.id}">
                                                    ${k} - ${statistics[k].count}
                                            </button>
                                        </h5>
                                    </div>

                                    <div id="collapse-${k}-${candidate.id}" class="collapse"
                                         style="margin-left: 30px"
                                         aria-labelledby="head-${k}-${candidate.id}"
                                         data-parent="#accordion">
                                        <div>
                                        
                                              ${statistics[k].questions.map((question, loop) => {
                return `<h6>${loop + 1}.
                    ${question.title}</h6>`
            }).join("")}
                                            
                                        </div>
                                    </div>
                                </div>`
        })
    return statisticHtml.join("");
}

fetch("/quiz/statistics", {method: "GET"})
    .then(res => res.json())
    .then(statistics => {
        let html = statistics.map((statistic, loop) => {
            return `
           <div class="card mt-2">
                    <div class="card-body">
                        <h3 class="card-title">${statistic.candidate.fullName}</h3>
                        <p class="card-text ml-2 text-mute" >${statistic.candidate.about}</p>
                        <div id="accordion">
                         ${getAccardion(statistic.statistics, statistic.candidate)}
                        </div>
                    </div>
                </div>`
        }).join("")
        document.getElementById("statistics-body").innerHTML = html;
    })
    .catch(err => {
        console.log(err)
        document.getElementById("error").innerHTML = `<div class="bg-danger"> <p>Something is wrong</p><div/>`

    })
