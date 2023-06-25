// import OfferteService from "../service/OfferteService";
import { OfferteService } from "../service/offerteService.js";
const service = new OfferteService();



document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    form.addEventListener('submit', extractOfferteFromForm);
});

function extractOfferteFromForm(event) {
    event.preventDefault();
    const naam = document.querySelector('#name').value;
    const typeZaal = document.querySelector('#type_zaal').value;
    const phone = parseInt(document.querySelector('#phone').value);
    const email = document.querySelector('#email').value;
    const date = document.querySelector('#date').value;
    const aantal = parseInt(document.querySelector('#aantal').value);
    const overig = document.querySelector('#overig').value;


    service.formSubmit(naam, phone, typeZaal, email, date, aantal, overig);
    // formSubmit(naam, phone, typeZaal, email, date, aantal, overig);

    const form = document.querySelector('form');
    form.reset()
}



