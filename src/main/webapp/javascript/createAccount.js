var count = 0;

$(document).ready(function() {

    $("#addChild").on("click", function() {
        count += 1;

        var childLabel = document.createElement("p");
        childLabel.appendChild(document.createTextNode("Child " + count));

        var inputDivClass = "input-field col s12";
        var firstNameDiv = document.createElement("div");
        firstNameDiv.setAttribute("class", inputDivClass);
        var emailDiv = document.createElement("div");
        emailDiv.setAttribute("class", inputDivClass);
        var birthDateDiv = document.createElement("div");
        birthDateDiv.setAttribute("class", inputDivClass);
        var passwordDiv = document.createElement("div");
        passwordDiv.setAttribute("class", inputDivClass);

        var inputClass = "col s6 offset-s3";
        var labelClass = "col offset-s3";
        var firstNameInput = document.createElement("input");
        firstNameInput.setAttribute("type", "text");
        firstNameInput.setAttribute("id", "firstNameChild" + count);
        firstNameInput.setAttribute("name", "firstNameChild" + count);
        firstNameInput.setAttribute("class", inputClass);
        firstNameInput.setAttribute("required", "");
        var firstNameLabel = document.createElement("label");
        firstNameLabel.setAttribute("for", "firstNameChild" + count);
        firstNameLabel.setAttribute("class", labelClass);
        firstNameLabel.appendChild(document.createTextNode("First Name"));
        firstNameDiv.appendChild(firstNameLabel);
        firstNameDiv.appendChild(firstNameInput);

        var emailInput = document.createElement("input");
        emailInput.setAttribute("type", "email");
        emailInput.setAttribute("id", "emailChild" + count);
        emailInput.setAttribute("name", "emailChild" + count);
        emailInput.setAttribute("class", inputClass);
        emailInput.setAttribute("required", "");
        var emailLabel = document.createElement("label");
        emailLabel.setAttribute("for", "emailChild" + count);
        emailLabel.setAttribute("class", labelClass);
        emailLabel.appendChild(document.createTextNode("Email"));
        emailDiv.appendChild(emailLabel);
        emailDiv.appendChild(emailInput);

        var birthDateInput = document.createElement("input");
        birthDateInput.setAttribute("type", "date");
        birthDateInput.setAttribute("id", "birthDateChild" + count);
        birthDateInput.setAttribute("name", "birthDateChild" + count);
        birthDateInput.setAttribute("class", inputClass);
        birthDateInput.setAttribute("placeholder", "");
        birthDateInput.setAttribute("required", "");
        var birthDateLabel = document.createElement("label");
        birthDateLabel.setAttribute("for", "birthDateChild" + count);
        birthDateLabel.setAttribute("class", labelClass);
        birthDateLabel.appendChild(document.createTextNode("Date of Birth"));
        birthDateDiv.appendChild(birthDateLabel);
        birthDateDiv.appendChild(birthDateInput);

        var passwordInput = document.createElement("input");
        passwordInput.setAttribute("type", "password");
        passwordInput.setAttribute("id", "passwordChild" + count);
        passwordInput.setAttribute("name", "passwordChild" + count);
        passwordInput.setAttribute("class", inputClass);
        passwordInput.setAttribute("required", "");
        var passwordLabel = document.createElement("label");
        passwordLabel.setAttribute("for", "passwordChild" + count);
        passwordLabel.setAttribute("class", labelClass);
        passwordLabel.appendChild(document.createTextNode("Password"));
        passwordDiv.appendChild(passwordLabel);
        passwordDiv.appendChild(passwordInput);

        var roleInput = document.createElement("input");
        roleInput.setAttribute("type", "hidden");
        roleInput.setAttribute("name", "roleChild" + count);
        roleInput.setAttribute("value", "child");
        passwordDiv.appendChild(roleInput);

        var childrenDiv = document.getElementById("children");
        childrenDiv.appendChild(childLabel);
        childrenDiv.appendChild(firstNameDiv);
        childrenDiv.appendChild(emailDiv);
        childrenDiv.appendChild(birthDateDiv);
        childrenDiv.appendChild(passwordDiv);
    });
});
