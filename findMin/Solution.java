package findMin;

public class Solution {
    
    public int findMin(int[] num) {
        if(num.length==1)
            return num[0];
        
        int i=0;
        int j=num.length-1;
        
        while(i<j){
            int mid=(i+j)/2;
            if(mid==i||mid==j){
                return num[i]<num[j]?num[i]:num[j];
            }
            if(num[mid]==num[i]){
            	while(i<mid&&num[i]==num[mid])
            		i++;
            	if(num[i]<num[mid])
            		return num[i];            	
            }
            else if(num[mid]==num[j]){
            	while(j>mid&&num[j]==num[mid])
            		j--;
            }
            else if(num[mid]>num[i]&&num[mid]>num[j]){
                i=mid;  
            }
            else{
                j=mid;
            }
        }
       return num[i]; 
    }
    

    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] a = {4,4,4,4,4,4,5,1,2,2,2,2,2,2,2,2,3};
    	System.out.println(s.findMin(a));
    }
}
