package ReverseStringInWords;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReverseStringInWords {
	
	public ReverseStringInWords(){
		
	}
	
	public String reverse(String orig){
		StringTokenizer st = new StringTokenizer(orig, " ");
		String result="";
		while(st.hasMoreTokens()){
			String tokens = st.nextToken();
			if(result!="")
			     result=tokens+" "+result;
			else
				result=tokens;
		}
		return result;
	}
	
	public static void main(String[] args){
		String s = "This is an apple";
		ReverseStringInWords r = new ReverseStringInWords();
		System.out.println(r.reverse(s));
	}
}
