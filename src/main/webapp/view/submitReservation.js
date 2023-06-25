import { ReservationService} from "../service/reservationService.js";
const createReservation = new ReservationService();

// script.js
document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    form.addEventListener('submit', getReservationValues);
});

function getReservationValues(event){
    //prevent default
    event.preventDefault()

    // Retrieve form values
    const date = document.querySelector('#resevering').value;
    const time = document.querySelector('#time').value;
    const aantal = document.querySelector('#aantal').value;

    console.log(time)

    createReservation.reservationSubmit(date, time, aantal);

    // Reset the form
    const form = document.querySelector('form');
    form.reset();
}

