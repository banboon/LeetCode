package SearchInsertPosition;

import java.util.Arrays;

public class Solution {
    public int searchInsert(int[] A, int target) {
        int position = Arrays.binarySearch(A, target);
        if(position>=0)
        	return position;
        position=-(position+1);
        return position;
    }
}
