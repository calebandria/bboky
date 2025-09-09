let datePret = document.getElementById("datePret")
let dateRemise = document.getElementById("dateRemise")

let attribute = document.getElementById("attribute")

datePret.addEventListener("input", () => {
    const dateOfRent = datePret.value;

    if (dateOfRent) {
        // Set the min attribute of the endDateTimeInput
        dateRemise.min = dateOfRent;
        // Enable the endDateTimeInput
        dateRemise.disabled = false;
    } else {
        // If no valid value is set, keep the endDateTimeInput disabled
        dateRemise.disabled = true;
    }

})

dateRemise.addEventListener("input", ()=> {
    const dateOfReturn = dateRemise.value;
    if(dateOfReturn) {
        attribute.disabled = false;
        attribute.classList.remove("btn-secondary")
        attribute.classList.add("btn-primary")
    }

    else {
        attribute.disabled = true
        attribute.classList.remove("btn-primary")
        attribute.classList.add("btn-secondary")
    }
})
