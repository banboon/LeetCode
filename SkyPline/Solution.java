package SkyPline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    
    class Point{
        int x;
        int h;
        public Point(int x, int h){
            this.x=x;
            this.h=h;
        }
    }
//    
//    public List<int[]> getSkyline(int[][] buildings) {
//        
//        List<int[]> res = new ArrayList<int[]>();
//        if(buildings.length<1) return res;
//        Queue<Point> stack = new PriorityQueue<Point>(buildings.length, new Comparator<Point>(){
//            public int compare(Point p1, Point p2){
//                return p1.r - p2.r;
//            }
//        });
//        
//        res.add(new int[]{buildings[0][0],buildings[0][2]});
//        stack.offer(new Point(buildings[0][1],buildings[0][2]));
////        Queue<Point> high = new PriorityQueue<Point>(buildings.length, new Comparator<Point>(){
////            public int compare(Point p1, Point p2){
////                return p2.h - p1.h;
////            }
////        });
////        high.offer(new Point(buildings[0][1],buildings[0][2]));
//        
//        int max=buildings[0][2];
//        
//        for(int i=1;i<buildings.length;i++){
//            int[] b = buildings[i];
//            Point p=null;
//
//            while(!stack.isEmpty()&&stack.peek().r<b[0]){
//                p=stack.poll();
//               // high.remove(p);
//                max = findMax(stack);
//                if(!stack.isEmpty()&&p.h<=max)
//                    continue;
//            if(p.r==res.get(res.size()-1)[0]){
//            	if(stack.isEmpty())
//            		res.get(res.size()-1)[1]=0;
//            	else if(p.h<res.get(res.size()-1)[1])
//                    res.get(res.size()-1)[1]=p.h;
//            }
//            else
//                res.add(new int[]{p.r,stack.isEmpty()?0:max});
//            }
//            
//            if(stack.isEmpty()||b[2]>max){
//                res.add(new int[]{b[0],b[2]});
//            }
//            
//           // high.offer(new Point(b[1],b[2]));
//            stack.offer(new Point(b[1],b[2]));
//            max=Math.max(max, b[2]);
//            
//        }
//        
//        while(!stack.isEmpty()){
//            Point p=stack.poll();
//            max = findMax(stack);
//           // high.remove(p);
//            if(!stack.isEmpty()&&p.h<=max)
//                    continue;
//            if(p.r==res.get(res.size()-1)[0]){
//            	if(stack.isEmpty())
//            		res.get(res.size()-1)[1]=0;
//            	else if(p.h<res.get(res.size()-1)[1])
//                    res.get(res.size()-1)[1]=p.h;
//            }
//            else
//                res.add(new int[]{p.r,stack.isEmpty()?0:max});
//        }
//        
//        return res;
//    }
//    
//    public int findMax(Queue<Point> q){
//    	if(q.isEmpty()) return -1;
//    	int max = q.peek().h;
//    	for(Point p: q){
//    		max=Math.max(max, p.h);
//    	}
//    	
//    	return max;
//    }
//    
////    public static void main(String[] args){
////    	int[][] buildings = {{2,4,7},{2,4,6},{2,4,5}};
////    	Solution s = new Solution();
////    	System.out.println(s.getSkyline(buildings));
////    }
//    public static void main(String args[]) {
//    	   // create priority queue
//    	   PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (); 
//    	       
//    	   // insert values in the queue
//    	   for ( int i = 3; i  <  10; i++ ){  
//    	   prq.add (i) ; 
//    	   }
//    	   prq.add(2);
//    	      
//    	   System.out.println ( "Initial priority queue values are: "+ prq);
//    	      
//    	   // remove 7 from the queue
//    	   boolean isremoved = prq.remove(7);
//    	      
//    	   System.out.println ( "Return value after remove: "+ isremoved);
//    	      
//    	   System.out.println ( "Priority queue values after remove: "+ prq.peek());
//    }
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<Point> edges = new ArrayList<Point>();
     
        for(int i=0;i<buildings.length;i++){
            edges.add(new Point(buildings[i][0],buildings[i][2]));
            edges.add(new Point(-buildings[i][1],buildings[i][2]));
        }
        
        Collections.sort(edges, new Comparator<Point>(){
            public int compare(Point o1, Point o2){
                if(Math.abs(o1.x)!=Math.abs(o2.x))
                    return Math.abs(o1.x)-Math.abs(o2.x);
                else
                    return o2.x-o1.x;
            }
        });
        

        Queue<Integer> heights = new PriorityQueue<Integer>(buildings.length,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        List<int[]> res = new ArrayList<int[]>();
        
        for(int i=0;i<edges.size();i++){
            if(edges.get(i).x>=0){
                int h = edges.get(i).h;
                heights.add(h);
                if(res.size()==0||heights.peek()>res.get(res.size()-1)[1]){
                    if(res.size()!=0&&edges.get(i).x==res.get(res.size()-1)[0])
                        res.get(res.size()-1)[1]=heights.peek();
                    else
                        res.add(new int[]{edges.get(i).x,heights.peek()});
                }
            }
            else{
                heights.remove(edges.get(i).h);
                int h = heights.isEmpty()?0:heights.peek();
                if(h<res.get(res.size()-1)[1]){
                    if(h<res.get(res.size()-1)[1]){
                        if(res.size()!=0&&-edges.get(i).x==res.get(res.size()-1)[0])
                            res.get(res.size()-1)[1]=h;
                        else
                            res.add(new int[]{-edges.get(i).x,h});
                    }
                }
            }
        }
        
        return res;
    }
    
	public static void main(String[] args){
		int[][] buildings = {{2,4,7},{2,4,5},{2,4,6}};
		Solution s = new Solution();
		System.out.println(s.getSkyline(buildings));
	}
}
