package WordSearchII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    
    
    List<String> unmatch = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<String>();
        
        if(board.length<1) return result;
        
        HashMap<Character,List<Integer>> map = new HashMap<Character, List<Integer>>();
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(map.containsKey(board[i][j])){
                    map.get(board[i][j]).add(i*cols+j);
                }
                else{
                    map.put(board[i][j],new ArrayList<Integer>(Arrays.asList(i*cols+j)));
                }
            }
        }
        
        for(int i=0;i<words.length;i++){
            if(result.contains(words[i]))
                continue;
            boolean flag = true;
            for(int j=0;j<unmatch.size();j++){
                if(strStr(words[i],unmatch.get(j))){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                continue;
            char c = words[i].charAt(0);
            List<Integer> tmp = map.get(c);
            int pos = 0;
            boolean find = false;
            for(int j=0;tmp!=null&&j<tmp.size();j++){
                    int x = tmp.get(j)/cols;
                    int y = tmp.get(j)%cols;
                    boolean[][] matrix = new boolean[rows][cols];
                    int len = help(board,matrix,words[i],x,y,0);
                    if(len==words[i].length()){
                        result.add(words[i]);
                        find=true;
                        break;
                    }
                    pos=Math.max(pos,len);
            }
            
            
            if(!find){
                unmatch.add(words[i].substring(0,pos+1));
            }
        }
        
        return result;
        
    }
    
    public int help(char[][] board, boolean[][] matrix, String word, int x, int y, int k){
        if(k==word.length())
            return word.length();
        if(x<0||x>=board.length||y<0||y>=board[0].length||matrix[x][y])
            return k;
        
        if(word.charAt(k)==board[x][y]){
            matrix[x][y]=true;
            int len1 = help(board,matrix,word,x+1,y,k+1);
            int len2 = help(board,matrix,word,x-1,y,k+1);
            int len3 = help(board,matrix,word,x,y+1,k+1);
            int len4 = help(board,matrix,word,x,y-1,k+1);
            matrix[x][y]=false;
            return Math.max(len1,Math.max(len2,Math.max(len3,len4)));
        }
        else
            return k;
    }
    
    public boolean strStr(String haystack, String needle) {
        
        for(int i=0;;i++){
            for(int j=0;;j++){
                if(j==needle.length())  return true;
                if(i+j==haystack.length()) return false;
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
        }
    }

    
    public static void main(String[] args){
    	Solution s = new Solution();
    	char[][] board = {"oaan".toCharArray(),"etae".toCharArray(),"ihkr".toCharArray(),"iflv".toCharArray()};
    	String[] words={"oath","pea","ate","eat","rain"};
    	//System.out.println(s.findWords(board, words));
    	System.out.println(s.findWords(board,words));
    }
}
