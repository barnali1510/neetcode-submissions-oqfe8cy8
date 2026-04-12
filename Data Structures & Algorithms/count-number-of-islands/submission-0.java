class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int row=0; row<m; row++) {
            for(int column=0; column<n; column++) {
                if(grid[row][column] == '1') {
                    dsf(grid, m, n, row, column);
                    count++;
                }
            }
        }
        return count;
    }

    private void dsf(char[][] grid, int m, int n, int row, int column) {
        if(row<0 || row>=m || column<0 || column>=n || grid[row][column] != '1') {
            return;
        }

        grid[row][column] = 0;

        //top
        dsf(grid, m, n, row-1, column);

        //left
        dsf(grid, m, n, row, column-1);

        //down
        dsf(grid, m, n, row+1, column);

        //right
        dsf(grid, m, n, row, column+1);
    }
}
