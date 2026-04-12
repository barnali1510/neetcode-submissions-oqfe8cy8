class Solution {
    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int row=0; row<m; row++) {
            for(int column=0; column<n; column++) {
                if(grid[row][column] == 1) {

                    //up
                    if(row>0 && grid[row-1][column]==0 || row==0) {
                        count = count + 1;
                    }

                    //left
                    if(column>0 && grid[row][column-1]==0 || column==0) {
                        count = count + 1;
                    }

                    //down
                    if(row<m-1 && grid[row+1][column]==0 || row==m-1) {
                        count = count + 1;
                    }

                    //right
                    if(column<n-1 && grid[row][column+1]==0 || column==n-1) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }
}