package ContainerWithMostWater;
 class Solution {
      int maxArea(int[] height) {
          int i = 0;
          int j = height.length - 1;
          
          int ret = 0;
         while(i < j)
         {
             int area = (j - i) * Math.min(height[i], height[j]);
             ret = Math.max(ret, area);
             
             if (height[i] <= height[j])
                 i++;
             else
                 j--;
         }
         
         return ret;
     }
 }
public class Container {
	public static void main(String[] args){
		Solution s = new Solution();
		int a[]={1,2,3,4};
		System.out.println(s.maxArea(a));
	}
}
