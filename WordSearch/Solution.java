package WordSearch;

public class Solution {
    public String convert(String s, int nRows) {
        
        if(nRows<=1)
            return s;
        
        int count = (int)Math.ceil((double)s.length()/(nRows+nRows-2));
        
        
        char[][] board = new char[nRows][(nRows-1)*count];
        
        int x=0, y=0;
        
        int i=0;
        while(i<s.length()){
            if(x==0){
                int j=0;
                for(j=0;j<nRows;j++){
                    if(i+j>=s.length()){
                        break;
                    }
                    board[x+j][y]=s.charAt(i+j);
                }
                i=i+j;
                x=nRows-1;
            }
            else{
                board[--x][++y]=s.charAt(i);
                i++;
            }
        }
        
        String res ="";
        for(int p=0;p<board.length;p++){
            for(int j=0;j<board[0].length;j++){
                    res=res+board[p][j];
            }
        }
        
        return res;
    }


    
    public static void main(String[] args){
    	
    	Solution s = new Solution();
    	System.out.print(s.convert("zmxwneikz", 5));
    	
    }
}