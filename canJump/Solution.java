package canJump;

public class Solution {
    public boolean canJump(int[] A) {
        
        if(A==null||A.length<2)
            return true;
        
        boolean[] can = new boolean[A.length];
        
        can[0] = true;
        int max = 0;
        
        for(int i=0;i<A.length;i++){
            if(can[i]){
                if(i+A[i]>max){
                    max=i+A[i];
                    for(int j=i+1;j<=i+A[i];j++){
                        if(j>=can.length)
                            return true;
                        can[j]=true;
                    }
                }
            }
            else
                break;
        }
        return can[A.length-1];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] A = {1,1,1,0};
    	System.out.println(s.canJump(A));
    }
}
