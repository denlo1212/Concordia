// Deze javascript file is puur een 'voorbeeld-frontend' en -hoeft- niet aangepast te worden. In principe hoef je alleen
// de ...-service.js files in te vullen met de juiste promise-logica en dan zou de UI moeten werken.
// Uiteraard -mag- je deze files wel aanpassen, want heel fraai is deze UI nou ook weer niet:)
import LoginService from "../service/loginService.js";

let service = new LoginService();

document.forms.login.addEventListener('submit', event => {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    service.login(email, password)
        .then((data) => {
            const token = data.jwt;
            localStorage.setItem('token', token);
            // window.location.reload();
            console.log(token)

            alert("U bent ingelogd");
        })

        .catch(error => {
            console.log(error);
            alert("Geen correcte gegevens")
        });
})






