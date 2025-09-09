class urlInfo1 {

    constructor(idAdherent) {
        this.idAdherent = idAdherent;

    }

    getIdAdherent() {
        return this.idAdherent;
    }

    setIdAdherent(idAdherent) {
        this.idAdherent = idAdherent;
    }

    getUrl() {
        if (!isNaN(parseInt(idAdherent)) /* && !isNaN(parseInt(idExemplaire)) */)
            return `/prets/${parseInt(idAdherent)}/new`

        else
            return "error"
    }
}

let adherentInfo = document.querySelector(".adherent-info");
let url = new urlInfo1(idAdherent)
let next = document.getElementById("next");

var idAdherent

let idSelectedAdherent = (event) => {
    if (isNaN(parseInt(event.target.innerText))) {
        if (isNaN(parseInt(event.target.previousElementSibling.innerText))) {
            console.log(event.target.previousElementSibling.previousElementSibling.innerText)
            return event.target.previousElementSibling.previousElementSibling.innerText
        }
        else {
            console.log(event.target.previousElementSibling.innerText)
            return event.target.previousElementSibling.innerText
        }
    }
    else {
        console.log(event.target.innerText)
        return event.target.innerText
    }
}

adherentInfo.addEventListener("click", (event) => {

    idAdherent = idSelectedAdherent(event);
    url.setIdAdherent(idAdherent)

    console.log(url.getUrl())

    Array.from(adherentInfo.children).forEach(element => {
        if (element.classList.contains("selected")) {
            element.classList.remove("selected")
        }
    })

    Array.from(adherentInfo.children).filter(element =>{
        return element.firstChild.innerText === idAdherent
    }).forEach(element => {
        element.classList.add("selected")
    })

    next.classList.remove("btn-secondary")
    next.classList.add("btn-primary")
    next.addEventListener("click", ()=>{
       window.location.href = url.getUrl()
    })
})