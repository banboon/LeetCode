package LongestPalimdromicSubstring;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Substring {
	public String longestPalindrome(String str) {
		 
		 int len = str.length();
		 
		 boolean[][] matrix = new boolean[len][len];
		 
		 for(int i=0;i<len;i++){
			 matrix[i][i]=true;
		 }
		 
		 int start=0;
		 int maxlen=0;
		 
		 //step
		 for(int step=1;step<len;step++){
			 
			 // start point
			 for(int i=0;i<len-step;i++){
				 if(step==1){
					 matrix[i][i+step]=(str.charAt(i)==str.charAt(i+step));
				 }
				 else{
					 matrix[i][i+step]=(str.charAt(i)==str.charAt(i+step)&&matrix[i+1][i+step-1]);
				 }
				 
				 if(matrix[i][i+step]&&step>maxlen){
					 start =i;
					 maxlen=step;
				 }
			 }
		 }
		 
		 return str.substring(start, start+maxlen+1);
		 
	 }
	
	public static void main(String[] args){
		Substring s  = new Substring();
		System.out.println(s.longestPalindrome("caba"));
		StringBuffer b = new StringBuffer();
		b.append("101");
		b.insert(0, "0");
		System.out.println(b);
		
		char a ='1';
		char a2 ='1';
		System.out.println(a+a2);
	}



}
