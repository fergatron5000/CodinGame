while (true) {
    var result = 0;
    var resultHeight = 0;
    
    for (var i = 0; i < 8; i++) {
        var mountainH = parseInt(readline()); // represents the height of one mountain.
        
        if (mountainH > resultHeight) {
            result = i;
            resultHeight = mountainH;
        }
    }

    // Write an action using print()
    // To debug: printErr('Debug messages...');

    print(result); // The index of the mountain to fire on.
}
