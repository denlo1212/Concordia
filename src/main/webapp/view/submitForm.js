// import CreateOfferte from "../service/CreateOfferte";
// const createOfferte = new CreateOfferte();



document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form'); // Selecteer het juiste formulierelement met een id
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


    // formSubmit(name, phone, typeZaal, email, date, aantal, overig);
    formSubmit(naam, phone, typeZaal, email, date, aantal, overig);

    const form = document.querySelector('form');
    form.reset()
}

function formSubmit(name, phone, typeZaal, email, datum, aantal, overig) {
    return fetch('http://localhost:8080/concordia/offerte', {
        method: "POST",
        body: JSON.stringify({
            naam: name,
            telefoonnummer: phone,
            type_feest: typeZaal,
            email: email,
            datum: datum,
            aantal: aantal,
            overig: overig
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    })
        .then((response) => {
            if (!response.ok) {
                return response.status;
            }
            return response.json();
        });
}


