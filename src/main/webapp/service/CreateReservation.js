export class CreateReservation{

    constructor() {
    }

    reservationSubmit(date, time, aantal){
        return fetch('http://localhost:8080/concordia/reservation',{
           method: "post",
           body: JSON.stringify({
               datum: date,
               tijd: time,
               aantal: aantal
        }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }

        }).then((response) => {
            if (!response.ok) {
                return response.status;
            }
            return response.json();
        });
    }
}




