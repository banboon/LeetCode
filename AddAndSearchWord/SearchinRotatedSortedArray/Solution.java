package SearchinRotatedSortedArray;

public class Solution {
    public boolean search(int[] A, int target) {
    	
        int i=0;
        int j=A.length-1;
        
        if(A.length<1)
        	return false;
        if(j==0)
        	return A[0]==target?true:false;
        
        if(A[i]>A[j]){
        
            int last = findMin(A)-1;
            
                if(target==A[0])
                    return true;
                else if(target>A[0])
                    j = last;
                else
                    i=last+1;
        }
        
        while(i<j){
            int mid = (i+j)/2;
            if(mid==i||mid==j){
            	if(A[i]==target||A[j]==target)
            		return true;
            	else
            		return false;
            }
            if(A[mid]==target)
                return true;
            else if(A[mid]<target)
                i=mid;
            else
                j=mid;
        }
        
        return false;
    }
    
    public int findMin(int[] num) {
        if(num.length<1)
            return num[0];
        
        int i=0;
        int j=num.length-1;
        
        while(i<j){
            int mid=(i+j)/2;
            if(mid==i||mid==j){
                return num[i]<num[j]?i:j;
            }
            if(num[mid]>num[i]&&num[mid]>num[j]){
                i=mid;  
            }
            else{
                j=mid;
            }
        }
       return i; 
    }
    
    public static void main(String[] args){
    	Solution s  = new Solution();
    	int[] A ={1};
    	int target =1;
    	System.out.println(s.search(A, target));
    }
}