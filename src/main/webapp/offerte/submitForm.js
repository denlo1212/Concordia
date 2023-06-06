// all fields for the form
const name = document.querySelector('#name').value;
const typeZaal = document.querySelector('#type_zaal').value;
const phone = document.querySelector('#phone').value;
const email = document.querySelector('#email').value;
const date = document.querySelector('#date').value;
const aantal = document.querySelector('#aantal').value;
const overig = document.querySelector('#overig').value;

function extractOfferteFromForm() {
    return nieuwForm(name, phone, typeZaal, email, date, aantal, overig);
}



function nieuwForm(name, phone, typeZaal, email, datum, aantal, overig) {
    let thisIsBob = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCb2IifQ.Llh46W2DSIvq8IC1po7GxxjaW5IEpp1CQgCjjE4zJfx6CXxW830-f4SgR8c2ZT-WVhxubdx8op0BgvuHhF2EnQ"

    fetch('http://http://localhost:8080/concordia/offerte',
        {
            method: "POST",
            body:JSON.stringify({
                name: name,
                telefoonnummer: phone,
                bruiloft : typeZaal,
                email: email,
                datum: datum,
                aantal: aantal,
                overig: overig
            }),
            header: {
                'Content-Type': 'application/json'
                // 'Authorization': 'Bearer '
                //     + thisIsBob
            }
        })
        .then(console.log(name, phone, typeZaal, email, datum, aantal, overig))


}

form.addEventListener('submit', extractOfferteFromForm);

