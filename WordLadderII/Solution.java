package WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    
    List<List<String>> result = new ArrayList<List<String>>();
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
        int level = bfs(start,end,dict);
        dfs(end,start, new ArrayList<String>(),level);
        
        return result;
    }
    
    public int bfs(String start, String end, Set<String> dict){
        
        int level = 0;
        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        q1.offer(start);
        map.put(start,0);
        
        boolean find = false;
        
        while(!q1.isEmpty()){
            level++;
            while(!q1.isEmpty()){
                String s = q1.poll();
                char[] sarray = s.toCharArray();
                for(int i=0;i<sarray.length;i++){
                    char temp = sarray[i];
                    for(char c ='a';c<='z';c++){
                        if(temp==c) continue;
                        sarray[i] = c;
                        String newString = new String(sarray);
                        if(set.contains(newString))
                            continue;
                        if(newString.equals(end))
                            find=true;
                        if(dict.contains(newString)){
                            q2.offer(newString);
                            set.add(newString);
                            map.put(newString,level);
                        }
                    }
                    sarray[i]=temp;
                }
            }
            if(find)
                return level;
            while(!q2.isEmpty())
                q1.offer(q2.poll());
        }
        
        return 0;
    }
    
    public void dfs(String end, String start, List<String> list, int level){
        if(end.equals(start)){
            list.add(start);
            Collections.reverse(list);
            result.add(list);
            return;
        }
        
        List<String> tempList = new ArrayList<String>(list);
        tempList.add(end);
        
        char[] sarray = end.toCharArray();
        
        for(int i=0;i<sarray.length;i++){
            char temp = sarray[i];
            for(char c = 'a';c<='z';c++){
                if(c==temp) continue;
                sarray[i]=c;
                String newString = new String(sarray);
                if(map.containsKey(newString)&&map.get(newString)==level-1)
                    dfs(newString,start,tempList,level-1);
            }
            sarray[i]=temp;
        }
        
    }
    
    public static void main(String[] args){
    	Set<String> set = new HashSet<String>();
    	set.add("hot");set.add("dot");set.add("dog");
    	Solution s = new Solution();
    	System.out.println(s.findLadders("hot","dog",set));
    }
}
