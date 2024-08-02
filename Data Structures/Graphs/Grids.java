import java.util.*;
/* 
1. No. of connected components in a Matrix
Given a grid of size n*m(n is the no. of rows and m is the no. of columns in the grid),
consisting of 0's (Water) ans 1's (Land). 
Find the no. of Islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally, i.e. in all 8 directions.


eg.
grid[][] = {{0, 1},
            {1, 0},
            {1, 1}, 
            {1, 0}};
ans: 1

grid[][] = {{0, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 1, 0}};
ans: 2

grid[][] = {{0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 0, 1}};
ans: 3


public class Grids {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void BFS(int i, int j, boolean[][] visited, int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int a = node.first;
            int b = node.second;
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    int row = a + x;
                    int col = b + y;
                    if ((row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length)) {
                        if (!visited[row][col] && grid[row][col] == 1) {
                            q.add(new Pair(row, col));
                            visited[row][col] = true;
                        }
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{ 0, 1, 1, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 },
                { 1, 1, 0, 1 } };
        
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    BFS(i, j, visited, grid);
                }
            }
        }
        System.out.println("No. of Islands: " + count);
    }
}
*/

/* 
2. Flood Fill algorithm
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. Replace the colour of all of the aforementioned pixels with the newColor.

eg.
int[][] grid = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
sr = 1, sc = 1, newColor = 2
ans: {{2, 2, 2},
      {2, 2, 0},
      {2, 0, 1}}
                 

int[][] grid = {{1, 1, 1},
                {2, 2, 0},
                {2, 2, 2}};
sr = 2, sc = 0, newColor = 3
ans: {{1, 1, 1},
      {3, 3, 0},
      {3, 3, 3}}


public class Grids {
    static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void BFS(int[][] grid, int sr, int sc, int newColor) {
        int old = grid[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        grid[sr][sc] = newColor;
        q.add(new Pair(sr, sc));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.r;
            int col = node.c;
            
            if (row-1 >=0 && grid[row - 1][col] == old) {
                grid[row - 1][col] = newColor;
                q.add(new Pair(row - 1, col));
            }
            else if ( col-1 >=0 &&grid[row][col - 1] == old) {
                grid[row][col - 1] = newColor;
                q.add(new Pair(row, col - 1));
            }
            else if ( col+1<grid[0].length && grid[row][col + 1] == old) {
                grid[row][col + 1] = newColor;
                q.add(new Pair(row, col + 1));
            }
            else if (row+1<grid.length && grid[row + 1][col] == old) {
                grid[row + 1][col] = newColor;
                q.add(new Pair(row + 1, col));
            }

        }
    }
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        BFS(grid, sr, sc, newColor);

        for(int [] i: grid)
            System.out.println(Arrays.toString(i));
    }
}
*/

/* 
3. Rotten Oranges: Min time to rot all oranges
You will be given an m x n grid, where each cell has the following values : 

2  -  represents a rotten orange
1  -  represents a Fresh orange
0  -  represents an Empty Cell
Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-directions ( upward, downwards, right, and left ) it becomes Rotten. 

Return the minimum number of minutes required such that none of the cells has a Fresh Orange. 
If it's not possible, return -1.

Eg:
Input: grid[][] = {{2, 1, 1},
                   {0, 1, 1},
                   {1, 0, 1}};
Output: -1


Input: grid[][] = {{2, 1, 1},
                   {1, 1, 0},
                   {0, 1, 1}};
Output:  4

Logic: use BFS as we have to do in minimum time so use level-wise traversal


public class Grids {
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
  
    static int rottenOranges(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] d_row = { -1, 0, +1, 0 };
        int[] d_col = { 0, +1, 0, -1 };

        int final_time = 0;
        
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int rotten_row = node.row;
            int rotten_col = node.col;
            int rotten_time = node.time;

            final_time = Math.max(final_time, rotten_time);

            for (int i = 0; i < 4; i++) {
                int neighbor_row = rotten_row + d_row[i];
                int neighbor_col = rotten_col + d_col[i];
                if (neighbor_row >= 0 && neighbor_row < n && neighbor_col >= 0 & neighbor_col < m) {
                    if (grid[neighbor_row][neighbor_col] == 1) {
                        q.add(new Pair(neighbor_row, neighbor_col, rotten_time + 1));
                        grid[neighbor_row][neighbor_col] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return final_time;
    }



    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 } };

        int minutes = rottenOranges(grid);
        System.out.println(minutes);
    }
}
*/

/* 
4. Distance of Nearest Cell having 1
Given a binary grid of N*M. Find the distance of the nearest 1 in the grid for each cell.

The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.

eg.
int[][] grid = {{1, 0, 1},
              {1, 1, 0},
              {1, 0, 0}};

ans = {{0, 1, 0}
       {0, 0, 1}
       {0, 1, 2}}



int[][] grid = {{0, 0, 0},
              {0, 1, 0},
              {1, 0, 1}};

ans = {{2, 1, 2}
       {1, 0, 1}
       {0, 1, 0}}

Logic: Use BFS to find min distance as it is level order


public class Grids {
    static class Pair {
        int row, col, dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    static int[][] nearest1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = { -1, 0, +1, 0 };
        int[] dy = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            int dist = node.dist;
            ans[row][col] = dist;

            for(int i=0; i<4; i++){
                int neighbor_row = row + dx[i];
                int neighbor_col = col + dy[i];
                
                if (neighbor_row >= 0 && neighbor_row < n && neighbor_col >= 0 && neighbor_col < m) {
                    if (!visited[neighbor_row][neighbor_col]) {
                        q.add(new Pair(neighbor_row, neighbor_col, dist + 1));
                        visited[neighbor_row][neighbor_col] = true;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{ 0, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 0 } };

        int[][] ans = nearest1(grid);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}
*/

/* 
5. Surrounded Regions | Replace O’s with X’s
Given a matrix of size N x M where every element is either ‘O’ or ‘X’. Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, just above just left, and just right of it.

eg. 
char grid[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

ans: 
X X X X
X X X X
X X X X
X X X X
X X O O


char grid[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'X', 'X', 'X'}};

ans: 
X X X X
X X X X
X X X X
X X X X
X X X X


char grid[][] = {
        {'X', 'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'O', 'X', 'O'}, 
        {'X', 'X', 'O', 'X', 'O'}, 
        {'X', 'O', 'X', 'O', 'X'}, 
        {'O', 'O', 'X', 'X', 'X'}};

ans: 
X X X X X
X X X X O
X X X X O
X O X X X
O O X X X


Logic: If an 'O' is present at a boundary, then the set of Os connected to it, wont be converted to X, remaining set of Os will be converted.
Use DFS(BFS also could be used) to mark all connected Os in boundary


public class Grids {
    static void DFS(int i, int j, char[][] grid, boolean[][] boundaryOs, int n, int m) {
        boundaryOs[i][j] = true;

        int[] dx = { -1, 0, +1, 0 };
        int[] dy = { 0, +1, 0, -1 };
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                if (!boundaryOs[ni][nj] && grid[ni][nj] == 'O') {
                    DFS(ni, nj, grid, boundaryOs, n, m);
                }
            }
        }
    }

    static char[][] replaceO_s(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] boundaryOs = new boolean[n][m];

        for (int i = 0; i < m; i++) { // 1st row
            if (!boundaryOs[0][i] && grid[0][i] == 'O') {
                    DFS(0, i, grid, boundaryOs, n, m);
            }
        }
        
        for (int i = 0; i < n; i++) { // Left column
            if (!boundaryOs[i][0] && grid[i][0] == 'O') {
                    DFS(i, 0, grid, boundaryOs, n, m);
            }
        }
        
        for (int i = 0; i < m; i++) { // last row
            if (!boundaryOs[n-1][i] && grid[n-1][i] == 'O') {
                    DFS(n-1, i, grid, boundaryOs, n, m);
            }
        }

        for (int i = 0; i < m; i++) { // right column
            if (!boundaryOs[i][m-1] && grid[i][m-1] == 'O') {
                    DFS(i, m-1, grid, boundaryOs, n, m);
            }
        }
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!boundaryOs[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }
    public static void main(String[] args) {
        char grid[][] = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };
        
        char[][] ans = replaceO_s(grid);

        for(char[] i: ans)
            System.out.println(Arrays.toString(i));
    }
}
*/

/* 
6. Number of Enclaves
You are given an N x M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. 
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid. 
Find the number of land cells in the grid for which we cannot walk off the boundary of the grid in any number of moves.

eg.
int[][] grid = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
ans: 3

int[][] grid = {{0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}};
ans: 4

public class Grids {
    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int noOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) { // top row
                q.offer(new Pair(0, j));
                visited[0][j] = true;
            }

            if (grid[n - 1][j] == 1) { // bottom row
                q.offer(new Pair(n - 1, j));
                visited[n - 1][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) { // Left column
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }

            if (grid[i][m - 1] == 1) { // Right column
                q.offer(new Pair(i, m - 1));
                visited[i][m - 1] = true;
            }
        }

        int[] dx = { -1, 0, +1, 0 };
        int[] dy = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            for (int i = 0; i < 4; i++) {
                int n_row = row + dx[i];
                int n_col = col + dy[i];
                if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m) {
                    if (!visited[n_row][n_col] && grid[n_row][n_col] == 1) {
                        q.offer(new Pair(n_row, n_col));
                        visited[n_row][n_col] = true;
                    }
                }
            }

        }

        int all_1s = 0;
        int boundary_1s = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    all_1s++;
                if (visited[i][j] == true)
                    boundary_1s++;
            }
        }

        return all_1s - boundary_1s;
    }

    public static void main(String[] args) {
        int[][] grid = {{ 0, 0, 0, 1 },
                        { 0, 1, 1, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 1 },
                        { 0, 1, 1, 0 } };

        int ans = noOfEnclaves(grid);
        System.out.println(ans);
    }
}
*/

/* 
7. Number of Distinct Islands
Given a grid of size NxM (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). Find the number of distinct islands.

Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

eg.
int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0}};
ans: 2

int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
ans: 3

int[][] grid = {{1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0}};
ans: 4

Logic: Store islands in a set, so it will tell which are distinct.
*/
public class Grids {

    static void DFS(int row, int col, boolean[][] visited, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        visited[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = { -1, 0, +1, 0 };
        int[] dy = { 0, -1, 0, +1 };

        for (int i = 0; i < 4; i++) {
            int n_row = row + dx[i];
            int n_col = col + dy[i];
            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m) {
                if (!visited[n_row][n_col] && grid[n_row][n_col] == 1) {
                    DFS(n_row, n_col, visited, grid, vec, row0, col0);
                }
            }
        }

    }

    static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    static int noOfDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    DFS(i, j, visited, grid, vec, i, j);
                    set.add(vec);
                }
            }
        }
        System.out.println(set);
        return set.size();
    }


    public static void main(String[] args) {
        int[][] grid = {{ 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 1, 0, 1, 1 } };

        int noOfIslands = noOfDistinctIslands(grid);
        System.out.println(noOfIslands);
    }
}