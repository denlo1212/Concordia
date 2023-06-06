export default class CreateOfferte {
    constructor() {
        this.base_url = "http://localhost:8080"
    }



    formSubmit(name, phone, typeZaal, email, datum, aantal, overig) {
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
}