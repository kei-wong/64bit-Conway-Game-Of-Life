# 64bit-Conway-Game-Of-Life

HOW TO RUN:
1. Run MainDriver.java within an IDE.
2. To provide the initial pattern of living cells, enter a list of (x, y) coordinates.
    EXAMPLE: (0, 2) (1, 0) (1, 2) (2, 1) (2, 2)
3. Press enter! 

- By default, the program will run 10 iterations of the Game of Life.
- Currently, you can change this number by calling GameofLife.iterate(n) with a different number for n.
- Each iteration will have its resulting pattern of living cells printed in stdout.

# Prompt:
Imagine a 2D grid - each cell (coordinate) can be either "alive" or "dead". Every generation of the simulation, the system ticks forward. Each cell's value changes according to the following:
If an "alive" cell had less than 2 or more than 3 alive neighbors (in any of the 8 surrounding cells), it becomes dead.
If a "dead" cell had *exactly* 3 alive neighbors, it becomes alive.
Your input is a list of alive (x, y) integer coordinates. They could be anywhere in the signed 64-bit range. This means the board could be very large!

**Sample Input:**

```
(0, 1)
(1, 2)
(2, 0)
(2, 1)
(2, 2)
(-2000000000000, -2000000000000)
(-2000000000001, -2000000000001)
```

This program should read the state of the simulation from standard input, run 10 iterations of the Game of Life, and print the result to standard output in Life 1.06 format. 
