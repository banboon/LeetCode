package CountAndSay;

public class Solution {
	public String countAndSay(int n) {
		String result="1";
		for (int outer=1;outer<n;outer++){
			String previous=new String(result);
			result="";       
			int count=1;
			char say=previous.charAt(0);

			for (int i=1;i<previous.length();i++){
				if (previous.charAt(i)!=say){
					result=new StringBuilder(String.valueOf(result)).append(count).append(say).toString();
					count=1;
					say=previous.charAt(i);
				}
				else count++;
			}
			result=new StringBuilder(String.valueOf(result)).append(count).append(say).toString();
		}                   
		return result;

	}
}
