// import CreateOfferte from "../service/CreateOfferte";
import { CreateOfferte } from "../service/CreateOfferte";
const createOfferte = new CreateOfferte();



document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    form.addEventListener('submit', extractOfferteFromForm);
});

function extractOfferteFromForm(event) {
    event.preventDefault();
    const naam = document.querySelector('#name').value;
    const typeZaal = document.querySelector('#type_zaal').value;
    const phone = document.querySelector('#phone').value;
    const email = document.querySelector('#email').value;
    const date = document.querySelector('#date').value;
    const aantal = document.querySelector('#aantal').value;
    const overig = document.querySelector('#overig').value;


    createOfferte.formSubmit(naam, phone, typeZaal, email, date, aantal, overig);
    // formSubmit(naam, phone, typeZaal, email, date, aantal, overig);

    const form = document.querySelector('form');
    form.reset()
}



