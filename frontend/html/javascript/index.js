"use strict";

(function () {
    console.log("hello");
    const baseURL = "http://localhost:8080";
    const selector = document.querySelector(`[id="optionSelect"]`);

    const updateName = document.querySelector("#nameInput");
    const updateWepon = document.querySelector("#weponSelect");
    const updateLocation = document.querySelector("#locationSelect");
    const updateJob = document.querySelector("#jobInput");
    const updateId = document.querySelector("#idInput");

    const data1 = {
        id: updateId.value,
        name: updateName.value,
        wepon: updateWepon.value,
        location: updateLocation.value,
        job: updateJob.value
    }

    const getId = document.querySelector("#idGet");
    const getName = document.querySelector("#nameget");


    selector.addEventListener(`change`, (e) => {
        console.log(`e.target`, e.target);
        const select = e.target;
        const value = select.value;
        const desc = select.selectedOptions[0].text;
        console.log("value =", desc);
        let show = document.getElementById("ifUpdate");
        if (desc === "update") {
            console.log("done");
            show.style.display = "block";
            document.querySelector("section#postSection > form").addEventListener('submit', (e) => {

                console.log("update")
                e.preventDefault();
                const data = {
                    id: updateId.value,
                    name: updateName.value,
                    wepon: updateWepon.value,
                    location: updateLocation.value,
                    job: updateJob.value

                }
                axios.put(`${baseURL}/updateSuspect/${data1.id}`, data)
                    .then(res => {
                        console.log(updateName);
                        const book = res.data;
                        getAllSuspects();
                        document.location.reload();
                    }).catch(err => console.log(err));
            });
        } else if (desc === "create") {
            show.style.display = "none";
            document.querySelector("section#postSection > form").addEventListener('submit', (e) => {
                e.preventDefault(); // stops the form submitting in the default way

                const form = e.target;

                const data = {
                    name: form.inputName.value,
                    wepon: form.weponSelect.value,
                    location: form.locationSelect.value,
                    job: form.inputJob.value,

                }

                console.log("DATA: ", data);

                axios.post(`${baseURL}/createSuspect`, data)
                    .then((res) => {
                        console.log(res);

                        getAllSuspects();
                        form.reset(); //resets form
                        form.inputName.focus(); // selects the name input
                    }).catch(err => console.log(err));
            });

        } else {
            console.log("default");
        }
    });



    const getAllOutput = document.querySelector("#getAllOutput");
    const getByIdOutput = document.querySelector("#getByIdOutput");
    const getByNameOutput = document.querySelector("#getByNameOutput");
    const showNo = document.querySelector("#toggalAll");

    const renderSuspect = (suspect, outputDiv) => {
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
        suspectWepon.innerText = `Wepon: ${suspect.wepon}`;
        suspectWepon.classList.add("card-text");
        newSuspect.appendChild(suspectWepon);

        const suspectLocation = document.createElement("p");
        suspectLocation.innerText = `Current Location: ${suspect.location}`;
        suspectLocation.classList.add("card-text");
        newSuspect.appendChild(suspectLocation);

        const suspectJob = document.createElement("p");
        suspectJob.innerText = `Profession: ${suspect.job}`;
        suspectJob.classList.add("card-text");
        newSuspect.appendChild(suspectJob);

        const suspectpercentage = document.createElement("p");
        suspectpercentage.innerText = `Suspect Percentage: ${suspect.percentageSus}`;
        suspectpercentage.classList.add("card-text");
        newSuspect.appendChild(suspectpercentage);

        const deleteButton = document.createElement('button');
        deleteButton.innerText = "DELETE";
        deleteButton.classList.add("btn", "btn-secondary", "space");
        deleteButton.addEventListener('click', () => deleteSuspect(suspect.id));

        const updateButton = document.createElement('button');
        updateButton.innerText = "UPDATE";
        updateButton.classList.add("btn", "btn-secondary");
        updateButton.addEventListener('click', () => {
            data1.id = suspect.id,
                updateName.value = suspect.name,
                updateWepon.value = suspect.wepon,
                updateLocation.value = suspect.location,
                updateJob.value = suspect.job,
                updateId.value = data1.id
        });

        newSuspect.appendChild(deleteButton);

        newSuspect.appendChild(updateButton);

        suspectCard.appendChild(newSuspect);

        outputDiv.appendChild(suspectColumn);
    }

    const getAllSuspects = () => {
        axios.get(`${baseURL}/getAllSuspects`)
            .then(res => {
                const suspects = res.data;

                getAllOutput.innerHTML = ""; // blanks an element

                suspects.forEach(suspect => renderSuspect(suspect, getAllOutput));
            }).catch(err => console.log(err));
    }

    const deleteSuspect = id => {
        axios.delete(`${baseURL}/deleteSuspect/${id}`)
            .then(res => {
                console.log(res);
                getAllSuspects();
            }).catch(err => console.log(err));
    }

    const getSuspectById = () => {
        console.log("ahhhh");
        console.log(getId.value);
        axios.get(`${baseURL}/getSuspect/${getId.value}`)
            .then(res => {
                const suspect = res.data;
                getByIdOutput.innerHTML = "";
                console.log(res.data);
                renderSuspect(suspect, getByIdOutput);
            }).catch(err => console.log(err));
    }
    const getByName = () => {
        axios.get(`${baseURL}/getByName/${getName.value}`)
            .then(res => {
                console.log(getName.value);
                const suspects = res.data;

                getByNameOutput.innerHTML = ""; // blanks an element

                console.log("me two");
                suspects.forEach(suspect => renderSuspect(suspect, getByNameOutput));
            }).catch(err => console.log(err));
    }
    getAllSuspects();

    const changeSub = () => {
        console.log("helloefgnerjgberbg")
        if (getAllOutput.style.display === "none") {
            console.log("Dfwd")
            document.location.reload();
        } else {
            console.log("ahhhhh")
            getAllOutput.style.display = "none";
        }
    }

    document.querySelector("button#getidsub").addEventListener('click', getSuspectById);
    document.querySelector("button#getnamesub").addEventListener('click', getByName);
    document.querySelector("button#getsub").addEventListener('click', changeSub);



}
)();