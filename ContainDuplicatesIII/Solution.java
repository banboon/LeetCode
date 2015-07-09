package ContainDuplicatesIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	class Node{
		public int val;
		public Node prev, next;
		public Node(int val){
			this.val=val;
			prev=null;
			next=null;
		}
	}

	class DLink{
		Node head,tail;
		int size;

		public DLink(){
			head=null;
			tail=null;
			size=0;
		}

		public DLink(Node head){
			this.head=head;
			this.tail=head;
			size=1;
		}

		public void addFirst(Node node){
			if(size==0){
				head=tail=node;
				return;
			}
			node.next = head;
			head.prev=node;
			head = node;
			size++;
		}

		public void addLast(Node node){
			if(size==0){
				head=tail=node;
				return;
			}
			tail.next = node;
			node.prev = tail;
			tail=node;
			size++;
		}

		public int getFirst(){
			return head.val;
		}

		public int getLast(){
			return tail.val;
		}

		public int popFirst(){
			int val = head.val;
			head=head.next;
			size--;
			return val;
		}

		public int popLast(){
			int val= tail.val;
			tail=tail.prev;
			size--;
			return val;
		}

		public boolean isEmpty(){
			return size==0;
		}
	}

	public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {

		int len = nums.length;
		if(len<2||k<1) return false;
		if(k>=len-1) return getEasy(nums,t);

		List<Integer> min =  new ArrayList<Integer>();
		List<Integer> max = new ArrayList<Integer>();

		DLink l = new DLink();
		DLink l2 = new DLink();

		for(int i=0;i<=k;i++){
			while(!l.isEmpty()&&nums[i]<=nums[l.getLast()]){
				l.popLast();
			}
			l.addLast(new Node(i));
			while(!l2.isEmpty()&&nums[i]>=nums[l2.getLast()]){
				l2.popLast();
			}
			l2.addLast(new Node(i));
		}

		for(int i=k+1;i<len;i++){

			min.add(nums[l.getFirst()]);
			max.add(nums[l2.getFirst()]);

			while(!l.isEmpty()&&i-l.getFirst()>=k){
				l.popFirst();
			}
			while(!l.isEmpty()&&nums[i]<=nums[l.getLast()]){
				l.popLast();
			}
			l.addLast(new Node(i));

			while(!l2.isEmpty()&&i-l2.getFirst()>=k){
				l2.popFirst();
			}
			while(!l2.isEmpty()&&nums[i]>=nums[l2.getLast()]){
				l2.popLast();
			}
			l2.addLast(new Node(i));

		}

		for(int i=0;i<min.size();i++){
			if(max.get(i)-min.get(i)<=t)
				return true;
		}

		return false;
	}

	public boolean getEasy(int[] nums, int t){

		int min = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
			min=Math.min(min,nums[i]);
			max=Math.max(max,nums[i]);
		}

		return max-min<=t;
	}


	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Double  , Double> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			double remappedNum = (double) nums[i];
			double bucket = (double)((int)remappedNum / ( t + 1));
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				double lastBucket = ((double) nums[i - k] / ((double) t + 1));
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}


	public static void main(String[] args){
		int[] nums ={1,3,1};
		Solution s = new Solution();
		System.out.println(s.containsNearbyAlmostDuplicate(nums, 1, 1));
		System.out.println(Math.ceil(-0.6));
	}
}
