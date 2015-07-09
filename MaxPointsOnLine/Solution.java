package MaxPointsOnLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class Point{
	int x;
	int y;
	Point(){x=0;y=0;}
	Point(int a, int b) { x = a; y = b; }
	public int getX(){return x;}
	public int getY(){return y;}
}

public class Solution {
	public static int maxPoints(Point[] points) {  
	      
	    if(points.length<=2) {  
	        return points.length;  
	    }  
	    //斜率  
	    double k = 0.0;  
	    int maxPointNum      = 0;  
	    int tempMaxPointNum  = 0;  
	    //坐标完全相同点的个数  
	    int samePointNum     = 0;  
	    //与x轴平行  
	    int parallelPointNum = 0;   
	    HashMap<Double,Integer> slopeMap = new HashMap<Double,Integer>();  
	    for(int i=0;i<points.length-1;i++) {  
	        //代表起始点，会被累加上  
	        samePointNum     = 1;  
	        parallelPointNum = 0;   
	        tempMaxPointNum  = 0;  
	        slopeMap.clear();  
	        for(int j=i+1;j<points.length;j++) {  
	            //坐标完全相同  
	            if((points[i].x == points[j].x)&&((points[i].y == points[j].y))) {  
	                samePointNum++;  
	                continue;  
	            }  
	            //与y轴平行  
	            if(points[i].x == points[j].x) {  
	                parallelPointNum++;  
	            } else {  
	                if(points[i].y == points[j].y) {  
	                    k = 0;  
	                } else {  
	                    k = ((double)(points[i].y - points[j].y))/(points[i].x - points[j].x);  
	                }  
	                //斜率不存在  
	                if(slopeMap.get(k)==null) {  
	                    slopeMap.put(k, new Integer(1));  
	                    if(1>tempMaxPointNum) {  
	                        tempMaxPointNum = 1;  
	                    }  
	                }else {  
	                    //斜率已存在  
	                    int number = slopeMap.get(k);  
	                    number++;  
	                    slopeMap.put(k, new Integer(number));  
	                    if(number>tempMaxPointNum) {  
	                        tempMaxPointNum = number;  
	                    }  
	                }  
	            }  
	        } //end of for  
	          
	        if(parallelPointNum>1) {  
	            if(parallelPointNum>tempMaxPointNum) {  
	                tempMaxPointNum = parallelPointNum;  
	            }  
	        }  
	        //加上起始点和具有相同坐标的点  
	        tempMaxPointNum += samePointNum;  
	        if(tempMaxPointNum>maxPointNum) {  
	            maxPointNum = tempMaxPointNum;  
	        }  
	    }  
	    return maxPointNum;
	}
	
}
