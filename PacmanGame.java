/*
project: Pacman Game
date: Apr. 29, 2021
author: Josiah Luikham
purpose: Creating a pacman game with the a* algorithm as a pathfinding algorithm for ghosts
 */
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
class Board {
    String[][] board;
    
    Board() { 
        board = new String[21][19]; //creating a board of the correct dimensions for the game
        
    }
    
    public void printBoard(Ghost g1, Ghost g2, Ghost g3, Ghost g4, Pacman p) { //pring the board with the players on it
        board = getBoard();
        board[g1.getX()][g1.getY()] = "g1";
        board[g2.getX()][g2.getY()] = "g2";
        board[g3.getX()][g3.getY()] = "g3";
        board[g4.getX()][g4.getY()] = "g4";
        board[p.getX()][p.getY()] = "p";
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.printf("%2s", board[i][j]);
            }
            System.out.println();
        }
    }
    
    public String[][] getBoard() { //get a board with the right obstacles
        for (int i = 0; i < 21; i++)
              for (int j = 0; j < 19; j++) 
                  board[i][j] = ".";
        
        for (int i = 0; i < 19; i++) {
            board[0][i] = "W";
            board[20][i] = "W";
            
        }
        for (int i = 0; i < 21; i++) {
            board[i][0] = "W";
            board[i][18] = "W";
        }
        board[1][9] = "W";
        board[2][2] = "W";
        board[2][3] = "W";
        board[2][5] = "W";
        board[2][6] = "W";
        board[2][7] = "W";
        board[2][9] = "W";
        board[2][11] = "W";
        board[2][12] = "W";
        board[2][13] = "W";
        board[2][15] = "W";
        board[2][16] = "W";
        board[4][2] = "W";
        board[4][3] = "W";
        board[4][5] = "W";
        board[4][7] = "W";
        board[4][8] = "W";
        board[4][9] = "W";
        board[4][10] = "W";
        board[4][11] = "W";
        board[4][13] = "W";
        board[4][15] = "W";
        board[4][16] = "W";
        board[5][5] = "W";
        board[5][9] = "W";
        board[5][13] = "W";
        board[6][1] = "W";
        board[6][2] = "W";
        board[6][3] = "W";
        board[6][5] = "W";
        board[6][6] = "W";
        board[6][7] = "W";
        board[6][9] = "W";
        board[6][11] = "W";
        board[6][12] = "W";
        board[6][13] = "W";
        board[6][15] = "W";
        board[6][16] = "W";
        board[6][17] = "W";
        board[7][1] = "W";
        board[7][2] = "W";
        board[7][3] = "W";
        board[7][5] = "W";
        board[7][13] = "W";
        board[7][15] = "W";
        board[7][16] = "W";
        board[7][17] = "W";
        board[8][1] = "W";
        board[8][2] = "W";
        board[8][3] = "W";
        board[8][5] = "W";
        board[8][7] = "W";
        board[8][8] = "W";
        board[8][9] = "W";
        board[8][10] = "W";
        board[8][11] = "W";
        board[8][13] = "W";
        board[8][15] = "W";
        board[8][16] = "W";
        board[8][17] = "W";
        board[9][7] = "W";
        board[9][11] = "W";
        board[9][11] = "W";
        board[10][1] = "W";
        board[10][2] = "W";
        board[10][3] = "W";
        board[10][5] = "W";
        board[10][7] = "W";
        board[10][8] = "W";
        board[10][9] = "W";
        board[10][10] = "W";
        board[10][11] = "W";
        board[10][13] = "W";
        board[10][15] = "W";
        board[10][16] = "W";
        board[10][17] = "W";
        board[11][1] = "W";
        board[11][2] = "W";
        board[11][3] = "W";
        board[11][5] = "W";
        board[11][13] = "W";
        board[11][15] = "W";
        board[11][16] = "W";
        board[11][17] = "W";
        board[12][1] = "W";
        board[12][2] = "W";
        board[12][3] = "W";
        board[12][5] = "W";
        board[12][7] = "W";
        board[12][8] = "W";
        board[12][9] = "W";
        board[12][10] = "W";
        board[12][11] = "W";
        board[12][13] = "W";
        board[12][15] = "W";
        board[12][16] = "W";
        board[12][17] = "W";
        board[13][9] = "W";
        board[14][2] = "W";
        board[14][3] = "W";
        board[14][5] = "W";
        board[14][6] = "W";
        board[14][7] = "W";
        board[14][9] = "W";
        board[14][11] = "W";
        board[14][12] = "W";
        board[14][13] = "W";
        board[14][15] = "W";
        board[14][16] = "W";
        board[15][3] = "W";
        board[15][15] = "W";
        board[16][1] = "W";
        board[16][3] = "W";
        board[16][5] = "W";
        board[16][7] = "W";
        board[16][8] = "W";
        board[16][9] = "W";
        board[16][10] = "W";
        board[16][11] = "W";
        board[16][13] = "W";
        board[16][15] = "W";
        board[16][17] = "W";
        board[17][5] = "W";
        board[17][9] = "W";
        board[17][13] = "W";
        board[18][2] = "W";
        board[18][3] = "W";
        board[18][4] = "W";
        board[18][5] = "W";
        board[18][6] = "W";
        board[18][7] = "W";
        board[18][9] = "W";
        board[18][11] = "W";
        board[18][12] = "W";
        board[18][13] = "W";
        board[18][14] = "W";
        board[18][15] = "W";
        board[18][16] = "W";
        return board;
    }
       
    


          
}
class Pacman { //pacman object, holds the coordinates
    int x, y;
    Pacman (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void updateCoor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class Ghost { //ghost object
    int x, y;
    
    Comparator<Node> customComparator = new Comparator<Node>() { //comparitor for the priority queue. it compares the priority 
            @Override                                             //values of the nodes and puts the one with the smaller value at the front
            public int compare(Node n1, Node n2) {
                return (n1.priority - n2.priority);
            }
    };
        // Create a Priority Queue with a custom Comparator
    
    Ghost (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ArrayList pathFind(int pacX, int pacY, String[][] board) {
        int[][] costSoFar = new int[21][19]; //these arrays store the cost to get to a cell in the array from the starting position
        int[][] cameFromX = new int[21][19]; //and the coordinated of what cell came before a particular cell in the path, so that
        int[][] cameFromY = new int[21][19]; //we can trace backwards once we've located pacman
        for (int i = 0; i < 21; i ++)
            for (int j = 0; j < 19; j++) {
                costSoFar[i][j] = -1; //initialize them to -1
                cameFromX[i][j] = -1;
                cameFromY[i][j] = -1;
            }
        
        int curX = 0, curY = 0, curCost, priority;
              
        
        PriorityQueue<Node> Frontier = new PriorityQueue<>(customComparator);
        Frontier.add(new Node(x, y, 1000, 0)); //add the starting node in the array to the queue, its priority is set to a high(low priority) value and its cost is zero
        costSoFar[x][y] = 0; //the cost to start is zero
        
        
        while(Frontier.size() > 0) {
            Node n = Frontier.remove(); //remove the queue with the best priority 
            curX = n.getX(); //get its coordinated
            curY = n.getY();
            curCost = n.getCost(); //get its cost
            
            if (curX == pacX && curY == pacY) //if the node is where pacman is we're finished
                break;
            
            //explore each of the four nodes around the current node. if it is not a wall, it hasnt been
            //visited yet, or visiting it this time leads to a shorter path than previously, add it to the queue
            if ((!(board[curX-1][curY].equals("W"))) && ((costSoFar[curX-1][curY] == -1) || ((curCost+1) < costSoFar[curX-1][curY]))) {
                costSoFar[curX-1][curY] = (curCost+1);
                priority = curCost+1+heuristic(curX-1, curY, pacX, pacY); //the priority is calculated by adding the cost to get to a node
                Frontier.add(new Node(curX-1, curY, priority, curCost+1));//with the heuristic, which is just the distance from pacman regardless of obstacles
                cameFromX[curX-1][curY] = curX;                          //so ideally, nodes that are low cost and close to pacman have the highest priority
                cameFromY[curX-1][curY] = curY; 
            }
            if ((!(board[curX+1][curY].equals("W"))) && ((costSoFar[curX+1][curY] == -1) || ((curCost+1) < costSoFar[curX+1][curY]))) {
                costSoFar[curX+1][curY] = (curCost+1);
                priority = curCost+1+heuristic(curX+1, curY, pacX, pacY);
                Frontier.add(new Node(curX+1, curY, priority, curCost+1));
                cameFromX[curX+1][curY] = curX;
                cameFromY[curX+1][curY] = curY;
            }
            if ((!(board[curX][curY-1].equals("W"))) && ((costSoFar[curX][curY-1] == -1) || ((curCost+1) < costSoFar[curX][curY-1]))) {
                costSoFar[curX][curY-1] = (curCost+1);
                priority = curCost+1+heuristic(curX, curY-1, pacX, pacY);
                Frontier.add(new Node(curX, curY-1, priority, curCost+1));
                cameFromX[curX][curY-1] = curX;
                cameFromY[curX][curY-1] = curY;
            }
            if ((!(board[curX][curY+1].equals("W"))) && ((costSoFar[curX][curY+1] == -1) || ((curCost+1) < costSoFar[curX][curY+1]))) {
                costSoFar[curX][curY+1] = (curCost+1);
                priority = curCost+1+heuristic(curX, curY+1, pacX, pacY);
                Frontier.add(new Node(curX, curY+1, priority, curCost+1));
                cameFromX[curX][curY+1] = curX;
                cameFromY[curX][curY+1] = curY;
            }
            
            
        }
        printCostBoard(costSoFar); //if one wishes to see the trace of the algorithm finding the path one can uncomment this call
        ArrayList pathNodes = new ArrayList(); //this will store the node path for a ghost
        while(true) {
            if (cameFromX[curX][curY] == x && cameFromY[curX][curY] == y) { //if the next node in the path is the location of the ghost
                updateCoor(curX, curY);                                      //we can stop
                return pathNodes;
            }
            else {
                int tempX = curX;  
                int tempY = curY;
                curX = cameFromX[tempX][tempY]; //change the current value of x and y to the previous values on the path
                curY = cameFromY[tempX][tempY];
                pathNodes.add((new Node(curX, curY, -1, -1))); //store this node in the arraylist
            }
        }
        
    }
    void printCostBoard(int[][] a) { //this function will print a board of the cost explored to each node from the ghost,
        for (int i = 0; i < 21; i++) { // it is used to see the trace of the pathfinding algorithm
            for (int j = 0; j < 19; j++) {
                System.out.printf("%2s", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
    }
    
    int heuristic(int curX, int curY, int pacX, int pacY) { //the heuristic used for determining the priority of a node
    
        return Math.abs(curX-pacX)+Math.abs(curY-pacY); //the absolute distance of one node from another
    
    }
    
    
    void updateCoor(int x, int y) { //change the ghosts position
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    

}
class Node { //node class
    int x, y, priority, cost;
    
    Node(int x, int y, int priority, int cost) {
        this.x = x;
        this.y = y;
        this.priority = priority;
        this.cost = cost;
    }
    public int getPriority() {
        return priority;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getCost() {
        return cost;
    }
        
}
class Game {
    Ghost g1, g2, g3, g4;
    Pacman p;
    Board board;
    String[][] boardArray;
    ArrayList pathNodes;
    
    
    Game(Ghost g1, Ghost g2, Ghost g3, Ghost g4, Pacman p, Board b) {
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
        this.p = p;
        this.board = b;
    }
    
    
    public boolean movePac(int x, int y) {
        boardArray = board.getBoard();
        p.updateCoor(x, y); //first, move pacman
        
        if (g1.x == x && g1.y == y) //if pacman moves into a ghost, he dies
            return printBoard();
        if (g2.x == x && g2.y == y)
            return printBoard();
        if (g3.x == x && g3.y == y)
            return printBoard();
        if (g4.x == x && g4.y == y)
            return printBoard();
        
        pathNodes = g1.pathFind(x, y, boardArray); //perform pathfinding for each ghost and store it in pathnodes
        for (int i = 0; i < pathNodes.size(); i++) {
            boardArray[((Node)pathNodes.get(i)).getX()][((Node)pathNodes.get(i)).getY()] = "+"; //change the characters in the path to pluses
        }
        pathNodes = g2.pathFind(x, y, boardArray);
        for (int i = 0; i < pathNodes.size(); i++) {
            boardArray[((Node)pathNodes.get(i)).getX()][((Node)pathNodes.get(i)).getY()] = "+";
        }
        pathNodes = g3.pathFind(x, y, boardArray);
        for (int i = 0; i < pathNodes.size(); i++) {
            boardArray[((Node)pathNodes.get(i)).getX()][((Node)pathNodes.get(i)).getY()] = "+";
        }
        pathNodes = g4.pathFind(x, y, boardArray);
        for (int i = 0; i < pathNodes.size(); i++) {
            boardArray[((Node)pathNodes.get(i)).getX()][((Node)pathNodes.get(i)).getY()] = "+";
        }
        return printBoard(); //print the board or tell if pacman was caught
        
    }
    
    
    public boolean printBoard() {
        if (g1.getX() == p.getX()) { //if a ghost and pacman share a coordinate he is caught
            if (g1.getY() == p.getY()) {
                System.out.println("Pacman has been caught!");
                return false;
            }
        }
        if (g2.getX() == p.getX()) {
            if (g2.getY() == p.getY()) {
                System.out.println("Pacman has been caught!");
                return false;
            }
        }
        if (g3.getX() == p.getX()) {
            if (g3.getY() == p.getY()) {
                System.out.println("Pacman has been caught!");
                return false;
            }
        }
        if (g4.getX() == p.getX()) {
            if (g4.getY() == p.getY()) {
                System.out.println("Pacman has been caught!");
                return false;
            }
        }
        //if not caught put the characters in their places and print it out
        boardArray[g1.getX()][g1.getY()] = "g1";
        boardArray[g2.getX()][g2.getY()] = "g2"; 
        boardArray[g3.getX()][g3.getY()] = "g3";
        boardArray[g4.getX()][g4.getY()] = "g4";
        boardArray[p.getX()][p.getY()] = "p";
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.printf("%2s", boardArray[i][j]);
            }
            System.out.println();
        }
        return true; //return true so the game continues
          
    }
    
}

public class PacmanGame {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Board b = new Board();
        Ghost g1 = new Ghost(1, 1);
        Ghost g2 = new Ghost(19, 1);
        Ghost g3 = new Ghost(1, 17);
        Ghost g4 = new Ghost(19, 17);
        Pacman p = new Pacman(15, 9);
        
        int pacX = p.getX();
        int pacY = p.getY();
        
        Game g = new Game(g1, g2, g3, g4, p, b);
        String[][] boardArray = b.getBoard();
        
        String res;
        String test = "udlrq"; //string containing the only acceptable inputs
        boolean notCaught = true;
        b.printBoard(g1, g2, g3, g4, p); //print the initial board
        
        do {
            System.out.print("Would you like to move pacman up(u), down(d), left(l) or right(r)? press q to quit: ");
            res = in.next();
            in.nextLine();
            if (!test.contains(res)) {
                System.out.println("Error, invalid input");
            }
            else if (res.charAt(0) == 'u') {
                if (!boardArray[pacX-1][pacY].equals("W")) { //if movement is not into a wall, move pacman
                    pacX -= 1;
                }
                notCaught = g.movePac(pacX, pacY);
                
            }   
            else if (res.charAt(0) == 'd') {
                if (!boardArray[pacX+1][pacY].equals("W")) {
                    pacX += 1;
                }
                notCaught = g.movePac(pacX, pacY);
            }  
            else if (res.charAt(0) == 'l') {
                if (!boardArray[pacX][pacY-1].equals("W")) {
                    pacY -= 1;
                }
                notCaught = g.movePac(pacX, pacY);
                
            }   
            else if (res.charAt(0) == 'r') {
                if (!boardArray[pacX][pacY+1].equals("W")) {
                    pacY += 1;
                }
                notCaught = g.movePac(pacX, pacY);
            }   
            
        } while(res.charAt(0) != 'q' && notCaught);
        
        
        
        // TODO code application logic here
        
    }
    
}
