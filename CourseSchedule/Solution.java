package CourseSchedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(map.containsKey(pre)){
                map.get(pre).add(course);
            }
            else{
                map.put(pre,new ArrayList<Integer>(Arrays.asList(course)));   
            }
        }
        
        int[] degree = new int[numCourses];
        for(int i: map.keySet()){
            for(int j: map.get(i)){
                degree[j]+=1;
            }
        }
        
        int[] result = new int[numCourses];
        
        for(int i=0;i<result.length;i++){
            int j=0;
            for(j=0;j<degree.length;j++){
                if(degree[j]==0)
                    break;
            }
            if(j==degree.length) return null;
            result[i]=j;
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	int[][] a ={{0,1},{1,0}};
    	int[] res = findOrder(2,a);
    	
    	
    }
}
