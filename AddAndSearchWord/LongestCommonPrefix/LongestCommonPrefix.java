package LongestCommonPrefix;
class Solution {
	boolean isEqual(String[] strs, int j){
		for(int i=0;i<strs.length-1;i++){
			if(j>strs[i].length()||j>strs[i+1].length())
				return false;
			if(strs[i].substring(0,j).equals(strs[i+1].substring(0,j)))
				;
			else
				return false;
		}
		return true;
	}
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0)
    		return "";
    	if(strs.length==1)
    		return strs[0];
    	int j=1;
    	while(isEqual(strs,j))
    		j++;
    	if(j==1)
    		return "";
    	else
    		return strs[0].substring(0,j-1);
    }
}
public class LongestCommonPrefix {
	public static void main(String[] args){
		Solution s= new Solution();
		String str[]={"ab","abcsdds","abcwqeq","abcasdawq"};
		System.out.println(s.longestCommonPrefix(str));
	}
}
