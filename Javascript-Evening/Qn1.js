class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        return this.input.length;
    };
    getUpperCase() {
        return this.input.toUpperCase();
    };
    getLowerCase() {
        return this.input.toLowerCase();
    };

    seperateAlphabets() {
        var consonants = "";
        var vowels = "";
        // var number ;
        for (var letter of this.input) {
            console.log(letter)
            if (/[aeiouAEIOU]/.test(letter)) {
                vowels += letter;
            } else if(/[A-Za-z]/.test(letter)) {
                consonants += letter;
            }
            console.log(vowels, consonants);
        }
        var answer = "<p> Vowels : <h3> " + vowels + "</h3>  Consonants  : <h3>" + consonants + "</h3> </p>";
        return answer

    }
    isNumberPresent(){
        for (var letter of this.input){
            if (/[0-9]/.test(letter)){
                console.log(letter + " is a number. Throw error");
                return "<h3> YES </h3>";
            }
        }
        return "<h3> NO </h3>";   
    }
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    document.getElementById("seperateAlphabets").innerHTML = inputObject.seperateAlphabets();
    document.getElementById("isNumberPresent").innerHTML = inputObject.isNumberPresent();

}