// Deze javascript file is puur een 'voorbeeld-frontend' en -hoeft- niet aangepast te worden. In principe hoef je alleen
// de ...-service.js files in te vullen met de juiste promise-logica en dan zou de UI moeten werken.
// Uiteraard -mag- je deze files wel aanpassen, want heel fraai is deze UI nou ook weer niet:)
import LoginService from "../service/login-service.js";

let service = new LoginService();

function refresh() {
    login.style
    if (service.isLoggedIn()) {
        document.forms.login.style = "display:none";
        document.forms.logout.style = "display:block";
    } else {
        document.forms.logout.style = "display:none";
        document.forms.login.style = "display:block";
    }
}

document.forms.login.addEventListener('submit', event => {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    service.login(email, password)
        .then(() => {
            window.location.reload();
        })
        .catch(error => {
            console.log(error);
            alert("Geen correcte gegevens")
        });
});


document.forms.login.addEventListener('submit', event => {
    event.preventDefault();

    service.logout()
        .then(() => {
            window.location.reload();
            alert("je bent uitgelogt")
        })

        .catch(error => {
            console.log(error);
            alert("er ging iets fout");
        });
});

refresh();

service.getUser().then(user => {
    if (!user) {
        service.logout();
    }

    refresh();
})


