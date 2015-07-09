package SubSetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> overlap = new ArrayList<Integer>();
    private List<List<Integer>> previous = new ArrayList<List<Integer>>();
     private List<List<Integer>> previousNext = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        
    
            
            Arrays.sort(num);
            
    
            for(int i=0;i<num.length;i++){
                int temp = num[i];
                if(overlap.contains(temp)){
                    
                    previous = new ArrayList<List<Integer>>(previousNext);
                    previousNext = new ArrayList<List<Integer>>();
                    int size = previous.size();
                     for(int j=0;j<size;j++){
                            List<Integer> tempList = new ArrayList<Integer>(previous.get(j));
                            tempList.add(temp);
                            result.add(tempList);
                            previousNext.add(tempList);
                     }
                }
                else{
                    int size = result.size();
                    previousNext = new ArrayList<List<Integer>>();
                    for(int j=0;j<size;j++){
                        List<Integer> tempList = new ArrayList<Integer>(result.get(j));
                        tempList.add(temp);
                        result.add(tempList);
                        previousNext.add(tempList);
                    }
                }
                if(overlap.contains(temp)){
                    ;
                }
                else{
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(temp);
                    result.add(tempList);
                    overlap.add(temp);
                    previousNext.add(tempList);
                }
            }
            result.add(new ArrayList<Integer>());
            return result;
        
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] l={1,1};
    	System.out.println(s.subsetsWithDup(l));
    }
}
