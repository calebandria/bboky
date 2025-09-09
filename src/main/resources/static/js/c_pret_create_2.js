class urlInfo2 {
    constructor(idExemplaire, idAdherent) {
        this.idExemplaire = idExemplaire;
        this.idAdherent = idAdherent
    }

    getIdAdherent() {
        return this.idAdherent;
    }

    setIdAdherent(idAdherent) {
        this.idAdherent = idAdherent;
    }


    getIdExemplaire() {
        return this.idExemplaire;
    }

    setIdExemplaire(idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    getUrl() {
        if (!isNaN(parseInt(idAdherent)) && !isNaN(parseInt(idExemplaire)))
            return `/prets/${parseInt(idAdherent)}/${parseInt(idExemplaire)}/new`

        else
            return "error"
    }
}



let exemplaireInfo = document.querySelector(".exemplaire-info");


let pretAdding = document.getElementById("pretAdding")

let idAdherentIn = document.getElementById("idAdherent")
let idExemplaireIn = document.getElementById("idExemplaire")

let nextBook = document.getElementById("next-book");

var idAdherent = parseInt(window.location.href.split("/")[4])


let urlDef = new urlInfo2(idAdherent,)
/* let next = document.getElementById("next"); */



let idSelectedExemplaire = (event) => {
    if (isNaN(parseInt(event.target.innerText))) {
        return event.target.previousElementSibling.innerText
    }

    else {
        return event.target.innerText
    }
}


exemplaireInfo.addEventListener("click", (event) => {

    idExemplaire = idSelectedExemplaire(event);
    urlDef.setIdExemplaire(idExemplaire)

    console.log(urlDef.getUrl())

    // transforming the background color into another color
    Array.from(exemplaireInfo.children).forEach(element => {
        if (element.classList.contains("selected")) {
            element.classList.remove("selected")
        }
    })

    Array.from(exemplaireInfo.children).filter(element => {
        return element.firstChild.innerText === idExemplaire
    }).forEach(element => {
        element.classList.add("selected")
    })

    nextBook.classList.remove("btn-secondary")
    nextBook.classList.add("btn-primary")
    nextBook.addEventListener("click", ()=>{
       window.location.href = urlDef.getUrl()
    })
})




/* setTimeout(3000, ()=>console.log(url)) */