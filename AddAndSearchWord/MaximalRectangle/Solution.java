package MaximalRectangle;

import java.util.Stack;

public class Solution {

	public int largestRectangleArea(int[] height) {

		if(height.length==1)
			return height[0];

		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexs = new Stack<Integer>();

		int area = 0;

		for(int i =0; i<height.length;i++){
			if(heights.empty()||heights.peek()<=height[i]){
				heights.push(height[i]);
				indexs.push(i);
			}
			else{
				int pos=0;
				while(!heights.empty()&&heights.peek()>height[i]){
					int h = heights.pop();
					pos = indexs.pop();
					int cur = (i-pos)*h;
					if(cur>area)
						area=cur;
				}
				heights.push(height[i]);
				indexs.push(pos);
			}
		}
		while(!heights.empty()){
			int h = heights.pop();
			int pos = indexs.pop();
			int cur = (height.length-pos)*h;
			if(cur>area)
				area=cur;
		}

		return area;
	}

	public int maximalRectangle(char[][] matrix) {

		if(matrix==null||matrix.length<1)
			return 0;

		int[][] hist = new int[matrix.length][matrix[0].length];

		for(int j=0;j<hist[0].length;j++){
			if(matrix[0][j]=='0')
				hist[0][j]=0;
			else
				hist[0][j]=1;
		}    

		for(int i = 1;i<hist.length;i++){
			for(int j = 0;j<hist[0].length;j++){
				if(matrix[i][j]=='0'){
					hist[i][j]=0;
				}
				else{
					hist[i][j]=hist[i-1][j]+1;
				}
			}
		}

		int result = 0;
		for(int i=0;i<hist.length;i++){
			int cur = largestRectangleArea(hist[i]);
			if(cur>result)
				result = cur;
		}
		return result;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		char[][] matrix ={{'0','1'},{'0','1'}};
		System.out.print(s.maximalRectangle(matrix));
	}
}
