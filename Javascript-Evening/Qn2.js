class student {
    constructor(firstName, lastName, age, gender, rollNo, email, stream, Occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.rollNo = rollNo;
        this.stream = stream;
        this.occupation = Occupation;
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
function verifyInput(firstName, lastName, email, gender, age, rollNo, occupation) {
    console.log(firstName, lastName, email, gender, occupation);
    console.log(age, rollNo);
    // check if all fields are filled or not (essentially making all fields required)
    if (firstName === "" || lastName === "" || email === "" || age === "" || rollNo === "" || gender === undefined || occupation === "") {
        console.log(firstName, lastName, email, age, rollNo, gender, stream, occupation);
        alert("Form submission won't proceed unless all fields are filled out!");
        return false;
    }

    // testing against .com email ids only
    if (/[a-zA-Z0-9]+@[a-zA-Z]+.com/.test(email)) {
        console.log("Email id is of the correct format");
    } else {
        alert("Please re enter email id in the correct format!");
        return false;
    }

    var dict = JSON.parse(JSON.stringify('{"firstName" :' + firstName + ', "lastName" : ' + lastName + ',"age": ' + age + ' ,"emailId" : ' + email + ', "gender" : ' + gender + ', "stream" : ' + stream + ' ,"Occupation" : ' + occupation + ' }'));
    console.log(dict);
    return true;
}

function displayOutputDetails(person1) {
    console.log(person1);
    document.getElementById("firstNameOutput").innerHTML = (person1.firstName);
    document.getElementById("lastNameOutput").innerHTML = (person1.lastName);
    document.getElementById("ageOutput").innerHTML = (person1.age);
    document.getElementById("emailOutput").innerHTML = (person1.email);
    document.getElementById("genderOutput").innerHTML = (person1.gender);
    document.getElementById("rollNoOutput").innerHTML = (person1.rollNo);
    document.getElementById("streamOutput").innerHTML = (person1.stream);
    document.getElementById("occupationOutput").innerHTML = (person1.occupation);


}
function validateForm() {

    firstName = document.getElementById('firstName').value;
    lastName = document.getElementById('lastName').value;
    email = document.getElementById('email').value
    age = document.getElementById('age').value
    rollNo = document.getElementById('rollNo').value;
    gender = getGenderOption(document.getElementsByName("gender"));
    occupation = document.getElementById("Occupation").value;

    console.log(occupation);

    var dropdown = document.getElementById("streamChoices")
    stream = dropdown.options[dropdown.selectedIndex].value;
    var isCorrectDetails = verifyInput(firstName, lastName, email, gender, age, rollNo, occupation);

    if (isCorrectDetails) {
        var person1 = new student(firstName, lastName, age, gender, rollNo, email, stream, occupation);
    }
    alert("All details have been submitted successfully");
    inputForm = document.getElementById("inputForm");
    inputForm.style.display = "none";

    outputDetails = document.getElementById("outputDetails");
    outputDetails.style.display = "block";
    displayOutputDetails(person1);

}

function addOccupation() {
    var occupation = (() => {
        let occupation = document.getElementById("Occupation");
        occupation.style.display = "block";
        let submitAllButton = document.getElementById("submitAllDetails");
        submitAllButton.style.display = "block";

        console.log("occupation shown");
    })();

}