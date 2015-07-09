package MiniumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        
      
    	int row=grid.length;
        int col=grid[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0&&j==0)
                    continue;
                if(i==row-1&&j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                    continue;
                }
                if(i==0||i==row-1){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }
                else if(j==0||j==col-1){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }
                else{
                    if(grid[i-1][j]<grid[i][j-1]){
                        grid[i][j]=grid[i-1][j]+grid[i][j];
                    }
                    else{
                        grid[i][j]=grid[i][j-1]+grid[i][j];
                    }
                }
            }
        }
        
        return grid[row-1][col-1];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int [][] grid = {{1,3,1},{1,5,1},{1,2,1}};
    	s.minPathSum(grid);
    }
}
