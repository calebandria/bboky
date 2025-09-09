let tabTarget = document.getElementById("tab-target")

Array.from(tabTarget.children).forEach((child)=>{
    if(child.childNodes[3].innerHTML === "Oui")
        child.children[2].firstElementChild.disabled=false
    else{
        child.children[2].firstElementChild.disabled=true
    }
});

