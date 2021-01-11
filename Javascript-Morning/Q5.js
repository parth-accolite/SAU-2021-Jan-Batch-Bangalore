class student {
    constructor(firstName, lastName, email, gender,) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}

function getGenderOption(element) {
    console.log(element);
    for (i = 0; i < element.length; i++) {
        if (element[i].checked) {
            return element[i].value;
        }
    }
}
function validateForm() {
    // get  all values from the form
    firstName = document.getElementById('firstName').value;
    lastName = document.getElementById('lastName').value;
    email = document.getElementById('email').value
    gender = getGenderOption(document.getElementsByName("gender"));

    var dropdown = document.getElementById("streamChoices")
    stream = dropdown.options[dropdown.selectedIndex].value;

    console.log(firstName, lastName, email, gender, stream);
    // check if all fields are filled or not (essentially making all fields required)
    if (firstName === "" || lastName === "" || email === "" || gender === undefined) {
        console.log(firstName, lastName, email, gender, stream);
        alert("Form submission won't proceed unless all fields are filled out!");
        return;
    }

    var dict = []
    dict["first name"] = firstName;
    dict["last name"] = lastName;
    dict["email"] = email;
    dict["gender"] = gender;
    dict["stream"] = stream;
    // testing against .com email ids only
    if (/[a-zA-Z0-9]*@[a-zA-Z]*.com/.test(email)) {
        console.log("Email id is of the correct format");
    } else {
        alert("Please re enter email id in the correct format!");
    }
    console.log(dict);
}