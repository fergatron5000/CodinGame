var n = parseInt(readline()); // the number of temperatures to analyse
var inputs = readline().split(' ');

var result = 0;
var resultDelta = 5527;

for (var i = 0; i < n; i++) {
    var t = parseInt(inputs[i]); // a temperature expressed as an integer ranging from -273 to 5526
    
    var delta = Math.abs(t);
    if (delta < resultDelta) {
        result = t;
        resultDelta = delta;
    } else if ((delta == resultDelta) && (t > result)) {
        result = t;
    }
}

// Write an action using print()
// To debug: printErr('Debug messages...');
print(result);
