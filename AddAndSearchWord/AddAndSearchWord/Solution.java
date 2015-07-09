package AddAndSearchWord;

public class Solution {
    
    class Word{
        Word[] words;
        boolean end;
        public Word(){
            words = new Word[26];
            end = false;
        }
    } 
    
    Word root = new Word();

    // Adds a word into the data structure.
    public void addWord(String word) {
        
        Word cur = root;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.') continue;
            if(cur.words[c-'a']==null){
                cur.words[c-'a']=new Word();
            }
            cur=cur.words[c-'a'];
        }
        cur.end=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        
        if(word==null) return true;
        
        return searchHelp(word,root);
    }
    
    public boolean searchHelp(String word, Word start){
        
        if(start==null) return false;
        if(word.length()<1&&start.end) return true;
        
        Word cur = start;
        
        for(int j=0;j<word.length();j++){
            char c = word.charAt(j);
            if(c=='.'){
                for(int i=0;i<cur.words.length;i++){
                    if(searchHelp(word.substring(j+1),cur.words[i]))
                        return true;
                }
                return false;
            }
            else{
                if(cur.words[c-'a']==null)
                    return false;
                else
                    cur=cur.words[c-'a'];
            }
        }
        return cur.end?true:false;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	s.addWord("a");
    	s.addWord("a");
    	System.out.println(s.search("."));
    	System.out.println(s.search("a"));
    	System.out.println(s.search("aa"));
    	System.out.println(s.search(".a"));
    	System.out.println(s.search("a."));
    	
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
