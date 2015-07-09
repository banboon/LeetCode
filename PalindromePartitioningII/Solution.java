package PalindromePartitioningII;

public class Solution {
	int minCut(String s) {  
		int len = s.length();  
		int D[] = new int[len+1];  
		boolean[][] P = new boolean[len][len];              
		//the worst case is cutting by each char  
		for(int i = 0; i <= len; i++)   
			D[i] = len-1-i;            
		for(int i = len-1; i >= 0; i--){  
			for(int j = i; j < len; j++){  
				if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
					P[i][j] = true;  
					D[i] = Math.min(D[i],D[j+1]+1);  //old, new
				}  
			}
		}  
		return D[0];  
	}  

	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.minCut("aabc"));
	}
}