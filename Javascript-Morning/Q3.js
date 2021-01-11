function areAllDigitsSame(inp) {
    var digit = inp % 10;
    while (inp) {
        if (inp % 10 !== digit) {
            return false;
        }
        inp = Math.floor(inp / 10);
    }
    return true
}

console.log(areAllDigitsSame(2017130027));
console.log(areAllDigitsSame(33333));
console.log(areAllDigitsSame(1234567));