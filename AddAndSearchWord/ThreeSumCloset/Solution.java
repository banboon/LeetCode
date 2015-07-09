package ThreeSumCloset;

import java.util.Arrays;


public class Solution {
	public int threeSumClosest(int[] num, int target) {
		if(num.length<3)
			return 0;
		Arrays.sort(num);

		int result = num[0]+num[1]+num[2];
		for(int i=0;i<num.length-2;i++){
			if(i>0&&num[i]==num[i-1])
				continue;
			int x = getSum(num,target,num[i],i);
			if(x==target)
				return x;
			if(Math.abs(x-target)<Math.abs(result-target))
				result=x;
		}
		return result;
	}

	public int getSum(int[] num, int target, int first, int firstPosition) {
		int i=firstPosition+1;
		int j = num.length-1;
		int sum = first+num[i]+num[j];
		int closest=sum;
		while(i<j){
			sum = first+num[i]+num[j];
			if(Math.abs(sum-target)<Math.abs(closest-target))
				closest=sum;
			if(sum<target){
				i++;
				while (i < j && num[i] == num[i - 1]) {  
					i++;  
				}  
			}
			else if(num[i]+num[j]>target){
				j--;
				while (i < j && num[j] == num[j + 1]) {  
					j--;  
				} 
			}
			else
				break;
		}
		return closest;

	}

//	public static void main(String[] args){
//		Solution s = new Solution();
//		int[] a ={87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
//		int target = -275;
//		System.out.println(s.threeSumClosest(a, target));
//	}
}
