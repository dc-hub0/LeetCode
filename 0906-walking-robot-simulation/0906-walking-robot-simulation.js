function robotSim(commands, obstacles) {
    const obstacleSet = new Set(obstacles.map(([x, y]) => `${x},${y}`));
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let x = 0, y = 0, direction = 0, maxDistance = 0;

    for (const command of commands) {
        if (command === -2) {
            direction = (direction + 3) % 4;
        } else if (command === -1) {
            direction = (direction + 1) % 4;
        } else {
            for (let i = 0; i < command; i++) {
                const nextX = x + directions[direction][0];
                const nextY = y + directions[direction][1];
                if (!obstacleSet.has(`${nextX},${nextY}`)) {
                    x = nextX;
                    y = nextY;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                } else {
                    break;
                }
            }
        }
    }

    return maxDistance;
}

// Example usage:
console.log(robotSim([4, -1, 3], [])); // Output: 25
console.log(robotSim([4, -1, 4, -2, 4], [[2, 4]])); // Output: 65
console.log(robotSim([6, -1, -1, 6], [])); // Output: 36
