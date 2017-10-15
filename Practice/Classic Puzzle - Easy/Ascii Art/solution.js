/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

var L = parseInt(readline());
var H = parseInt(readline());
var T = readline().toUpperCase();

var letterIndices = [];

for (var charIndex = 0; charIndex < T.length; charIndex++) {
    var value = T.charCodeAt(charIndex);
    value = value - 65;
    
    if ((value < 0) || (value > 25)) {
        value = 26;
    }
    
    letterIndices.push(value);
}

for (var i = 0; i < H; i++) {
    var ROW = readline();
 
    var asciiLine = ""
 
    for (var letter = 0; letter < letterIndices.length; letter++) {
        var start = letterIndices[letter] * L;
        var end = start + L;
        asciiLine += ROW.substring(start, end);
    }
 
    print(asciiLine);
}
