"use strict";

(function(){
console.log("hello");
const baseURL ="http://localhost:8080";
const selector = document.querySelector(`[id="optionSelect"]`);

selector.addEventListener(`change`, (e) => {
    console.log (`e.target`, e.target);
    const select = e.target;
    const value = select.value;
    const desc = select.selectedOptions[0].text;
    console.log("value =" , desc);
    let show = document.getElementById("ifUpdate");
    if (desc === "update"){
        console.log("done");
        show.style.display= "block";
        document.querySelector("section#postSection > form").addEventListener('submit', (e) =>{
            console.log("update")
        });
    }else if(desc === "create"){
        show.style.display= "none";
        document.querySelector("section#postSection > form").addEventListener('submit', (e) =>{
            console.log("create")
        });
    }else{
        console.log("default");
    }
});
const suspectKitten = (suspect, outputDiv) => {   
    const suspectColumn = document.createElement('div');
    suspectColumn.classList.add("col");

    const suspectCard = document.createElement('div');
    suspectCard.classList.add("card");
    suspectColumn.appendChild(suspectCard);

    const newSuspect = document.createElement('div');
    newSuspect.classList.add("card-body");
    
    const suspectName = document.createElement("h3");
    suspectName.innerText = suspect.name;
    suspectName.classList.add("card-title");
    newSuspect.appendChild(suspectName);


    const suspectWepon = document.createElement("p");
    suspectWepon.innerText = `Age: ${suspect.wepon}`;
    suspectWepon.classList.add("card-text");
    newKitten.appendChild(suspectWepon);

    const suspectLocation = document.createElement("p");
    suspectLocation.innerText = `Breed: ${suspect.location}`; 
    suspectLocation.classList.add("card-text");
    newKitten.appendChild(suspectLocation);

    const suspectJob = document.createElement("p");
    suspectJob.innerText = `Cuteness: ${suspect.job}`; 
    suspectJob.classList.add("card-text");
    newKitten.appendChild(suspectJob);

    const suspectpercentage = document.createElement("p");
    suspectpercentage.innerText = `Cuteness: ${suspect.percentageSus}`; 
    suspectpercentage.classList.add("card-text");
    newKitten.appendChild(suspectpercentage);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = "DELETE";
    deleteButton.classList.add("btn", "btn-primary");
    deleteButton.addEventListener('click', () => deleteKitten(suspect.id));

    newKitten.appendChild(deleteButton);

    kittenCard.appendChild(newSuspect);

    outputDiv.appendChild(suspectColumn);
}

}
)();