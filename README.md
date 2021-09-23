  This program is a Pac-Man like game. The game board is tiled. The movement of Pac-Man is controlled by the game player and the movement of the ghost(s) is controlled by the program.  Both Pac-Man and the ghost(s) can only move up, down, left, or right one tile position at a time.  No diagonal movement is allowed. An A* path finding algorithm is used to help the ghost(s) to catch Pac-Man.  

  The heuristic for the ghost pathfinding algorithm is simply the absolute value of the node’s x value minus the pacman’s x value PLUS the absolute value of the node’s y value minus the pacman’s y value. This is added to the current cost to get to the node from the root, therefore, nodes closest to pacman with a low cost to arrive at have this lowest  value and thus the highest priority.
