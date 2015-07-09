package ZigzagConversion;

public class ZigzagConvert {

	public String convert(String s, int nRows) {
		char[][] str=new char[nRows][1024];
		int[] row= new int[1024];
		int direct=1;
		if(nRows==1)
			return s;
		else{
			for(int i=0,j=0;i<s.length();i++){
				str[j][row[j]]=s.charAt(i);
				row[j]=row[j]+1;
				j+=direct;
				if(j>=nRows){
					j--;
					j--;
					direct=-1;
				}
				if(j==0)
					direct=1;
			}
			StringBuffer temp=new StringBuffer();
			for(int i=0;i<nRows;i++){
				for(int j=0;j<row[i];j++){
					temp.append(str[i][j]);
				}
			}
			String result=temp.toString();
			return result;
		}
	}

	public static void main(String args[]){
		ZigzagConvert s = new ZigzagConvert();
		System.out.println(s.convert("ABCDEFGHIJKLMN", 4));
	}
}
