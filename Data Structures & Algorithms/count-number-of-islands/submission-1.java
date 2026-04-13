class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int row=0; row<=m-1; row++) {
            for(int column=0; column<=n-1; column++) {
                if(grid[row][column] == '1') {
                    dfs(grid, m, n, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int m, int n, int row, int column) {
        if(row<0 || column<0 || row>m-1 || column>n-1 || grid[row][column] != '1') {
            return;
        }

        grid[row][column] = '0';

        //top
        dfs(grid, m, n, row-1, column);

        //left
        dfs(grid, m, n, row, column-1);

        //down
        dfs(grid, m, n, row+1, column);

        //right
        dfs(grid, m, n, row, column+1);
    }
}
