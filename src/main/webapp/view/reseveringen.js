import { ReservationService } from "../service/reservationService.js";
const service = new ReservationService();




const today = new Date().toISOString().split('T')[0];
document.getElementById('datum').value = today;

function renderResevering(resevering) {

    const reseveringTemplate = document.querySelector('#resevering-template');
    // debugger;
    const reseveringTemplateClone = reseveringTemplate.content.cloneNode(true);
    const reseveringContent = reseveringTemplateClone.querySelector('#reseveringTitle');

    reseveringContent.querySelector(".aantal").textContent = resevering.aantal;
    reseveringContent.querySelector(".tijden").textContent = resevering.tijd;

    // reseveringContent.addEventListener("click", event => {
    //     showDialog(event);
    // });

    return reseveringContent;
}

const button = document.getElementById("reseveringButton");

button.addEventListener("click", render);



function render() {
    const date= document.getElementById("datum").value;
    const reseveringsContainer = document.querySelector('.items'); // Update the selector to match the container element
    reseveringsContainer.innerHTML = '';
    let reseverings;

    console.log(date)

    service.getReseverings().then((result) => {
        reseverings = result;

        reseverings.forEach((resevering) => {
            console.log(resevering.datum)
            if(resevering.datum === date){
                const reseveringElement = renderResevering(resevering);
                reseveringsContainer.appendChild(reseveringElement);
            }
        });
    });

}

