console.log("bla")



function extractOfferteFromForm(event) {

    const name = document.querySelector('#name').value;
    console.log(name)
    const typeZaal = document.querySelector('#type_zaal').value;
    console.log(typeZaal)
    const phone = document.querySelector('#phone').value;
    const email = document.querySelector('#email').value;
    const date = document.querySelector('#date').value;
    const aantal = document.querySelector('#aantal').value;
    const overig = document.querySelector('#overig').value;

    return formSumbit(name, phone, typeZaal, email, date, aantal, overig);
}


function formSumbit(name, phone, typeZaal, email, datum, aantal, overig) {

    console


    let thisIsBob = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCb2IifQ.Llh46W2DSIvq8IC1po7GxxjaW5IEpp1CQgCjjE4zJfx6CXxW830-f4SgR8c2ZT-WVhxubdx8op0BgvuHhF2EnQ"
    fetch('http://localhost:8080/concordia/offerte',
        {
            method: "POST",
            body:JSON.stringify({
                name: name,
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




document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('#submit_button');
    form.addEventListener('submit', extractOfferteFromForm);
});
