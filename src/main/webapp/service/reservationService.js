export class ReservationService {

    constructor() {
    }

    link = "/concordia"

    reservationSubmit(date, time, aantal){
        return fetch(`${this.link}/reservation`,{
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

    getReseverings(){
        return fetch(`${this.link}/reservation`,{
            method: "get",
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




