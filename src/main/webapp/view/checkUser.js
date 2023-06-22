// Deze javascript file is puur een 'voorbeeld-frontend' en -hoeft- niet aangepast te worden. In principe hoef je alleen
// de ...-service.js files in te vullen met de juiste promise-logica en dan zou de UI moeten werken.
// Uiteraard -mag- je deze files wel aanpassen, want heel fraai is deze UI nou ook weer niet:)
import LoginService from "../service/login-service.js";

let service = new LoginService();

function refresh() {
    // login.style
    if (service.isLoggedIn()) {
        window.addEventListener('load', updateLoginButton);

        updateNavigation()
    }

    else{
        console.log("not loggin in")
        const loginButton = document.getElementById("loginButton")
        loginButton.addEventListener("click", () => {
            window.location.href = "../pages/login_pagina.html"
        })
    }
}

function updateLoginButton() {
    const loginButtonContainer = document.getElementById('loginButtonContainer');
        while (loginButtonContainer.firstChild) {
            loginButtonContainer.firstChild.remove();
        }

        const newButton = document.createElement('button');
        newButton.textContent = 'Loguit';
        newButton.addEventListener('click', () => {
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
        loginButtonContainer.appendChild(newButton);
}


function updateNavigation(){
    const navLinks = document.getElementsByClassName("nav_links")[0];

    const newLink1 = document.createElement("a");
    newLink1.href = "new_link1.html";
    newLink1.textContent = "New Link 1";

    const newLink2 = document.createElement("a");
    newLink2.href = "new_link2.html";
    newLink2.textContent = "New Link 2";

    const newItem1 = document.createElement("li");
    newItem1.appendChild(newLink1);

    const newItem2 = document.createElement("li");
    newItem2.appendChild(newLink2);

    navLinks.appendChild(newItem1);
    navLinks.appendChild(newItem2);
}

refresh();


service.getUser().then(user => {
    if (!user) {
        service.logout();
    }
})


