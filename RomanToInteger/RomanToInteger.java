package RomanToInteger;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int i=0;
        int thousand=0,hundred=0,ten=0,unit=0;
        StringBuffer tempHundred=new StringBuffer();
        StringBuffer tempTen=new StringBuffer();
        StringBuffer tempUnit=new StringBuffer();
        Map<String,Integer> hundredMap = new HashMap<String,Integer>();
        hundredMap.put("", 0);
        hundredMap.put("C", 1);
        hundredMap.put("CC", 2);
        hundredMap.put("CCC", 3);
        hundredMap.put("CD", 4);
        hundredMap.put("D", 5);
        hundredMap.put("DC", 6);
        hundredMap.put("DCC", 7);
        hundredMap.put("DCCC", 8);
        hundredMap.put("CM", 9);
        Map<String,Integer> tenMap = new HashMap<String,Integer>();
        tenMap.put("", 0);
        tenMap.put("X", 1);
        tenMap.put("XX", 2);
        tenMap.put("XXX", 3);
        tenMap.put("XL", 4);
        tenMap.put("L", 5);
        tenMap.put("LX", 6);
        tenMap.put("LXX", 7);
        tenMap.put("LXXX", 8);
        tenMap.put("XC", 9);
        Map<String,Integer> unitMap = new HashMap<String,Integer>();
        unitMap.put("", 0);
        unitMap.put("I", 1);
        unitMap.put("II", 2);
        unitMap.put("III", 3);
        unitMap.put("IV", 4);
        unitMap.put("V", 5);
        unitMap.put("VI", 6);
        unitMap.put("VII", 7);
        unitMap.put("VIII", 8);
        unitMap.put("IX", 9);
        while(i<s.length()&&s.charAt(i)=='M'){
        	thousand++;
        	i++;
        }
        while(i<s.length()&&(s.charAt(i)=='C'||s.charAt(i)=='D'||s.charAt(i)=='M')){
        	tempHundred.append(s.charAt(i));
        	i++;
        }
        hundred=hundredMap.get(tempHundred.toString());
        while(i<s.length()&&(s.charAt(i)=='X'||s.charAt(i)=='L'||s.charAt(i)=='C')){
        	tempTen.append(s.charAt(i));
        	i++;
        }
        ten=tenMap.get(tempTen.toString());
        while(i<s.length()&&(s.charAt(i)=='I'||s.charAt(i)=='V'||s.charAt(i)=='X')){
        	tempUnit.append(s.charAt(i));
        	i++;
        }
        unit=unitMap.get(tempUnit.toString());
    	return 1000*thousand+100*hundred+10*ten+unit;
    }
}
public class RomanToInteger {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.romanToInt("MDLXX"));
	}
}
/*
 public class Solution {  
      
    public int romanToInt(String s) {  
        if(s.length() < 1) return 0;  
        int result = 0;  
        int sub = getRomanValue(s.charAt(0));  
        int lastv = sub;  
        for(int i = 1 ; i < s.length(); ++i) {  
            char curc = s.charAt(i);  
            int curv = getRomanValue(curc);  
            if(curv == lastv)   
                sub += curv;  
            else if( curv < lastv) {  
                result += sub;  
                sub = curv;  
            } else {  
                sub = curv - sub;  
            }  
            lastv = curv;  
        }  
        result += sub;  
        return result;  
    }  
    public int getRomanValue(char c) {  
        switch(c) {  
            case 'I': return 1;   
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;  
        }  
    }  
} 
 */
