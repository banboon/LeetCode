package EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        
        if(word1==null||word1.length()==0)
            return word2.length();
        if(word2==null||word2.length()==0)
            return word1.length();
            
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] matrix = new int[len1+1][len2+1];
        
        for(int i=0;i<len2+1;i++){
            matrix[0][i]=i;
        }
        for(int i=0;i<len1+1;i++){
            matrix[i][0]=i;
        }
        
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                char a = word1.charAt(i-1);
                char b = word2.charAt(j-1);
                int o1 = a==b?matrix[i-1][j]-1:matrix[i-1][j];
                int o2 = a==b?matrix[i][j-1]:matrix[i][j-1]+1;
                int o3 =a==b?matrix[i-1][j-1]:matrix[i-1][j-1]+1;
                matrix[i][j]=Math.min(o1,Math.min(o2,o3));
            }
        }
        return matrix[len1][len2];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	s.minDistance("ab", "a");
    }
}
