function changeCase(inp) {
    var ans = "";
    for (var i = 0; i < inp.length; i++) {
        if (/[A-Z]/.test(inp[i])) {
            ans += inp[i].toLowerCase();
        }
        else {
            ans += inp[i].toUpperCase();
        }
    }
    return ans;
}

console.log(changeCase("Parth Jardosh"));
console.log(changeCase("aCColite DigiTal"));