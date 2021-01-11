function sumOfDigits(str) {
    var sum = 0;
    for (var letter of str){
        if (/[0-9]/.test(letter)){
            sum+= parseInt(letter);
        }
    }
    return sum;
}

console.log(sumOfDigits("Parth 347"));
console.log(sumOfDigits("33333"));
console.log(sumOfDigits("b-302, shiv ganga 2."));