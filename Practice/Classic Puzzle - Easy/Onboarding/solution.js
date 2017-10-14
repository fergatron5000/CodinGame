// game loop
while (true) {
    var enemy1 = readline(); // name of enemy 1
    var dist1 = parseInt(readline()); // distance to enemy 1
    var enemy2 = readline(); // name of enemy 2
    var dist2 = parseInt(readline()); // distance to enemy 2

    var target = enemy1;
    
    if (dist2 < dist1) {
        target = enemy2;
    }

    // You have to output a correct ship name to shoot ("Buzz", enemy1, enemy2, ...)
    print(target);
}
