/* 
1. Rat in a Maze problem
Given a mxn matrix, rat has to go from (0,0) to (m-1, n-1). 
Rat can only go right and down, and cannot go to blocked areas.
You have to tell if there is a path from source to destination or not?
*/
public class Backtracking {
    static boolean ratInMaze(int[][] maze, boolean[][] vis, int i, int j) {

    }
    public static void main(String[] args) {
        int[][] maze = {
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 1, 0 },
                { 1, 1, 1, 1 }
        };

        boolean vis[][] = new boolean[maze.length][maze[0].length];
        boolean isPathPossible = ratInMaze(maze, vis, 0, 0);

        if (isPathPossible) 
            System.out.println("Yes, there is a path possible from source to destination");
        else    
            System.out.println("No, there is no path possible from source to destination");
    }
}


/* 
N-Queen Problem
*/
