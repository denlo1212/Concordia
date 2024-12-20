export class OfferteService {

    constructor() {
    }

    link = "/concordia"

    formSubmit(name, phone, typeZaal, email, datum, aantal, overig) {
        return fetch(`${this.link}/offerte`, {
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

    getOffertes() {
        return fetch(`${this.link}/offerte`, {
            method: "GET",
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