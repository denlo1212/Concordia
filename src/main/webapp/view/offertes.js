import { OfferteService } from "../service/offerteService.js";
const service = new OfferteService();

function renderOfferte(offerte) {

    const offerteTemplate = document.querySelector('#offerte-template');
    // debugger;
    const offerteTemplateClone = offerteTemplate.content.cloneNode(true);
    const offerteContent = offerteTemplateClone.querySelector('#offerteTitle');

    offerteContent.querySelector("h2").textContent = offerte.naam;
    offerteContent.querySelector(".feesten").textContent = offerte.type_feest;
    offerteContent.querySelector(".emails").textContent = offerte.email;
    offerteContent.querySelector(".telefoonnummers").textContent = offerte.telefoonnummer
    offerteContent.querySelector(".aantal").textContent = offerte.aantal;
    offerteContent.querySelector(".overig").textContent = offerte.overig;
    offerteContent.querySelector("time").textContent = new Date(offerte.datum).toLocaleString();

    // offerteContent.addEventListener("click", event => {
    //     showDialog(event);
    // });

    return offerteContent;
}



/**
 * This function retrieves the offertes from the service and renders them in the .offertes element.
 * The function should apply the filters set by the user to reduce the list of offertes.
 * To break down the complexity of the rendering this function uses the renderTrip function to render a single Trip.
 */
function render() {
    const offertesContainer = document.querySelector('.items'); // Update the selector to match the container element
    offertesContainer.innerHTML = '';
    let offertes;

    console.log(service.getOffertes())


    service.getOffertes().then((result) => {
        offertes = result;
        
        offertes.forEach((offerte) => {
            const offerteElement = renderOfferte(offerte);
            offertesContainer.appendChild(offerteElement);
        });
    });

}

render()