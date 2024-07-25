
/* 
1. Grid Unique Paths


import java.util.Arrays;

public class Grids {
    static int gridUniquePaths_Tabulation(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for (int j = 0; j<n; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 1;
                else {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }   
            }
        }

        return dp[m-1][n-1];
    }
    
    static int gridUniquePaths_Memoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if(dp[m][n] != -1)
            return dp[m][n];

        int up = gridUniquePaths_Memoization(m - 1, n, dp);
        int left = gridUniquePaths_Memoization(m, n - 1, dp);
        return dp[m][n] = up + left;
    }

    static int gridUniquePaths_Recursion(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        int up = gridUniquePaths_Recursion(m - 1, n);
        int left = gridUniquePaths_Recursion(m, n - 1);
        return up + left;
    }

    public static void main(String[] args) {
        int rows = 4;
        int cols = 3;
        // int count = gridUniquePaths_Recursion(rows-1,  cols-1);

        // int[][] dp = new int[rows][cols];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int count = gridUniquePaths_Memoization(rows - 1, cols - 1, dp);
        
        int count = gridUniquePaths_Tabulation(rows,  cols);
        System.out.println(count);
    }
}
*/

/* 
2. Minimum Path Sum
We are given an “N*M” matrix of integers. We need to find a path from the top-left corner to the bottom-right corner of the matrix, such that there is a minimum cost past that we select.

At every cell, we can move in only two directions: right and bottom. The cost of a path is given as the sum of values of cells of the given matrix.

eg.
N=2, M=3
{{5, 9, 6},
{11, 5, 2}};

ans: minimum path sum = 5+9+5+2 = 21


import java.util.Arrays;

public class Grids {

    static int minPathSum_Tabulation(int n, int m, int[][] cost) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 && j==0)
                    dp[i][j] = cost[0][0];
                else {
                    int up = (int) 1e9, left = (int) 1e9;
                    if(i>0)
                        up = cost[i][j] + dp[i - 1][j];
                    if(j>0)
                        left = cost[i][j] + dp[i][j - 1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        
        return dp[n][m];
    }

    static int minPathSum_Memoization(int n, int m, int[][] cost, int[][] dp) {
        if (n == 0 & m == 0) {
            return cost[0][0];
        }
        if (n < 0 || m < 0) {
            return (int)1e9;
        }
        if (dp[n][m] != -1)
            return dp[n][m];
        int up = cost[n][m] + minPathSum_Memoization(n - 1, m, cost, dp);
        int left = cost[n][m] + minPathSum_Memoization(n, m - 1, cost, dp);
        return dp[n][m] = Math.min(up, left);
    }

    static int minPathSum_Recursion(int n, int m, int[][] cost) {
        if (n == 0 & m == 0) {
            return cost[0][0];
        }
        if (n < 0 || m < 0) {
            return (int)1e9;
        }
        int up = cost[n][m] + minPathSum_Recursion(n - 1, m, cost);
        int left = cost[n][m] + minPathSum_Recursion(n, m - 1, cost);
        return Math.min(up, left);
    }
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int cost[][] = { { 5, 9, 6 },
                { 11, 5, 2 } };
        
        int minCost = minPathSum_Recursion(n-1, m-1, cost);

        // int[][] dp = new int[n][m];
        // for (var i : dp) {
        //     Arrays.fill(i, -1);
        // }
        // int minCost = minPathSum_Memoization(n-1, m-1, cost, dp);

        // int minCost = minPathSum_Tabulation(n-1, m-1, cost);
        System.out.println(minCost);
    }
}

*/

/* 
3. Maze with obstacles
We are given an “N*M” Maze. The maze contains some obstacles. A cell is ‘blockage’ in the maze if its value is -1. 0 represents non-blockage. There is no path possible through a blocked cell.

We need to count the total number of unique paths from the top-left corner of the maze to the bottom-right corner. At every cell, we can move either down or towards the right.
eg.
N=3, M=3
{{0, 0, 0},
{0, -1, 0},
{0, 0, 0}};

ans = 2


public class Grids {
    static int mazeObstacles_Recursion(int n, int m, int[][] paths) {
        if(n==0 && m==0)
            return 1;
        if(n<0 || m<0 || paths[n][m] == -1)
            return 0;
        int up = mazeObstacles_Recursion(n - 1, m, paths);
        int left = mazeObstacles_Recursion(n, m - 1, paths);
        return up + left;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] paths = { { 0, 0, 0 },
                { 0, 0, -1 },
                { 0, 0, 0 } };
        int count = mazeObstacles_Recursion(n-1, m-1, paths);
        System.out.println(count);
    }
}
*/

/* 
4. Minimum path sum in Triangular Grid
We are given a Triangular matrix. We need to find the minimum path sum from the first row to the last row.

At every cell we can move in only two directions: either to the bottom cell (↓) or to the bottom-right cell(↘)

eg.
1
2, 3
3, 6, 7
9, 8, 6, 10

Minimum path sum = 1+2+3+8 = 14


public class Grids {
    static int triangularGrid_Tabulation(int[][] grid, int n) {
        int[][] dp = new int[n][n];
        // filling dp from n-1 to 0 (as we memoized from 0 to n-1)
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = grid[n - 1][j];
        }
        for (int i = n-2; i >=0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = grid[i][j] + dp[i + 1][j]; 
                int diagDown = grid[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagDown);
            }
        }

        return dp[0][0];
    }

    static int triangularGrid_Memoization(int[][] grid, int n, int i, int j, int[][] dp) {
        if (i == n - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != 0)
            return dp[i][j];
        int down = grid[i][j] + triangularGrid_Memoization(grid, n, i + 1, j, dp);
        int diagDown = grid[i][j] + triangularGrid_Memoization(grid, n, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(down, diagDown);
    }
    
    static int triangularGrid_Recursion(int[][] grid, int n, int i, int j ) {
        if (i == n - 1) {
            return grid[i][j];
        }
        int down = grid[i][j] + triangularGrid_Recursion(grid, n, i + 1, j);
        int diagDown = grid[i][j] + triangularGrid_Recursion(grid, n, i + 1, j + 1);
        return Math.min(down, diagDown);
    }
    // static int triangleGridUtil(int[][] grid, int n, int m) { // min path from 0,0 to n,m
    //     if(n==0 && m==0)
    //         return grid[0][0];
    //     if(n<0 || m<0 || m>n)
    //         return (int)1e9;
        
        
    //     int up = grid[n][m] + triangleGridUtil(grid, n-1, m);
    //     int up_left = grid[n][m] + triangleGridUtil(grid, n-1, m-1);
    //     return Math.min(up, up_left);

    // }
    // static int triangularGrid_Recursion(int[][] grid) {
    //     int n = grid.length;
    //     int min = Integer.MAX_VALUE;
    //     int m = grid[grid.length-1].length;
    //     for (int i = 0; i < m; i++) {
    //         min = Math.min(min, triangleGridUtil(grid, n-1, i));
    //     }
    //     return min;
    // }

    public static void main(String[] args) {
        int[][] grid = {{1},
                        {2, 3},
                        {3, 6, 7},
                        {9, 8, 6, 10 } };
        // int minPathSum = triangularGrid_Recursion(grid, grid.length, 0, 0);

        int[][] dp = new int[grid.length][grid[grid.length - 1].length];
        
        int minPathSum = triangularGrid_Tabulation(grid, grid.length);
        System.out.println(minPathSum);
    }
}
*/

/* 
5. Minimum/Maximum Falling Path Sum
We are given an ‘N*M’ matrix. We need to find the maximum path sum from any cell of the first row to any cell of the last row.

At every cell we can move in three directions: to the bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

eg.
N=4, M=4
{{1, 2, 10, 4},
{100, 3, 2, 1},
{1, 1, 200, 2},
{1, 2, 2, 1}};

Maximum Path Sum: 2 + 100 + 1 + 2 = 105


import java.util.Arrays;

public class Grids {

    static int maxFallingPath_Tabulation(int[][] paths, int n, int m) { // max path from any startign to end at i,j
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0)
                    dp[i][j] = paths[i][j];
                else {
                    int up = paths[i][j] + dp[i - 1][j];
                    int up_left = (int) -1e9;
                    int up_right = (int) -1e9;
                    if (j > 0)
                        up_left = paths[i][j] + dp[i - 1][j - 1];
                    if (j < m - 1)
                        up_right = paths[i][j] + dp[i - 1][j + 1];
                    dp[i][j] = Math.max(up, Math.max(up_left, up_right));
                }
            }
        }
        int max = dp[n - 1][m - 1];
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }
        return max;
    }

    static int maxFallingPathUtilM(int[][] paths, int i, int j, int[][] dp) { // max path from any startign to end at i,j
        if (j < 0 || j >= paths[i].length)
            return (int) -1e9;

        if (i == 0)
            return paths[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];
            
        int up = paths[i][j] + maxFallingPathUtilM(paths, i - 1, j, dp);
        int up_left = paths[i][j] + maxFallingPathUtilM(paths, i - 1, j - 1, dp);
        int up_right = paths[i][j] + maxFallingPathUtilM(paths, i - 1, j + 1, dp);
        return dp[i][j] = Math.max(up, Math.max(up_left, up_right));
    }

    static int maxFallingPath_Memoization(int[][] paths, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(var i:dp)
            Arrays.fill(i, -1);

        int max = Integer.MIN_VALUE;
        for (int j = 0; j <= m; j++) {
            max = Math.max(max, maxFallingPathUtilM(paths, n, j, dp));
        }
        return max;
    }

    static int maxFallingPathUtil(int[][] paths, int i, int j) { // max path from any startign to end at i,j
        if (j < 0 || j >= paths[i].length)
            return (int) -1e9;

        if (i == 0)
            return paths[0][j];

        int up = paths[i][j] + maxFallingPathUtil(paths, i - 1, j);
        int up_left = paths[i][j] + maxFallingPathUtil(paths, i - 1, j - 1);
        int up_right = paths[i][j] + maxFallingPathUtil(paths, i - 1, j + 1);
        return Math.max(up, Math.max(up_left, up_right));
    }

    static int maxFallingPath_Recursion(int[][] paths, int n, int m) {
        int max = Integer.MIN_VALUE;
        for (int j = 0; j <= m; j++) {
            max = Math.max(max, maxFallingPathUtil(paths, n, j));
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] paths = { { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 2, 2 },
                { 1, 2, 2, 1 } };
        // int maxPath = maxFallingPath_Recursion(paths, n - 1, m - 1);

        int maxPath = maxFallingPath_Memoization(paths, n - 1, m - 1);

        // int maxPath = maxFallingPath_Tabulation(paths, n, m);
        System.out.println(maxPath);
    }
}
*/

/* 
6. Chocolate Pickup
We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it, mat[i][j] gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1). Both of them can move only to the cells below them in these three directions: to the bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

When Alica and Bob visit a cell, they take all the chocolates from that cell with them. It can happen that they visit the same cell, in that case, the chocolates need to be considered only once.

They cannot go out of the boundary of the given matrix, we need to return the maximum number of chocolates that Bob and Alice can together collect.

eg.
N=3, M=4
{{2, 3, 1, 2},
{3, 4, 2, 2},
{5, 6, 3, 5}};

maximum chocolates collected: 2+4+6 + 2+2+5 = 21


public class Grids {
    static int chocolatePickup_Memoization(int[][] matrix, int n, int m, int i, int j1, int j2, int[][][] dp) { 
        if (j1 < 0 || j1 > m - 1 || j2 < 0 || j2 > m - 1) {
            return (int) -1e9;
        }

        if (i == n - 1) {
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        // explore all 9 possible paths simultaneously now.
        int max = (int) -1e9;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2)
                    value = matrix[i][j1];
                else
                    value = matrix[i][j1] + matrix[i][j2];
                value += chocolatePickup_Memoization(matrix, n, m, i + 1, j1 + dj1, j2 + dj2, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }

    static int chocolatePickup_Recursion(int[][] matrix, int n, int m, int i, int j1, int j2) {
        // returns max chocolates that can be picked from Alice(i,j1) and Bob(i,j2) till the end row of matrix.
        if (j1 < 0 || j1 > m - 1 || j2 < 0 || j2 > m - 1) {
            return (int) -1e9;
        }

        if (i == n - 1) {
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];
        }

        

        // explore all 9 possible paths simultaneously now.
        int max = (int) -1e9;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2)
                    value = matrix[i][j1];
                else
                    value = matrix[i][j1] + matrix[i][j2];
                value += chocolatePickup_Recursion(matrix, n, m, i + 1, j1 + dj1, j2 + dj2);
                max = Math.max(max, value);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int matrix[][] = { { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } };

        // int maxChocolates = chocolatePickup_Recursion(matrix, n, m, 0, 0, m - 1);

        int[][][] dp = new int[n][m][m]; // to store vaues of i, j1, j2
        for (int[][] i : dp) {
            for(int[] j: i)
                Arrays.fill(j, -1);
        }
        int maxChocolates = chocolatePickup_Memoization(matrix, n, m, 0, 0, m - 1, dp);
        System.out.println(maxChocolates);
    }
}
*/