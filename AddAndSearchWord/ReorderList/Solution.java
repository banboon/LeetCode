package ReorderList;

import java.util.HashMap;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {

	private HashMap<Integer,ListNode> map = new HashMap<Integer,ListNode>();

	public void reorderList(ListNode head) {
		if(head==null)
			return;
		int n=0;
		ListNode cur = head;
		while(cur!=null){
			map.put(n,cur);
			n++;
			cur=cur.next;
		}
		cur=head;
		for(int i=1,j=1,k=1;i<n;i++){
			if(i%2==0){
				cur.next=map.get(j);
				j++;
			} 
			else{
				cur.next=map.get(n-k);
				k++;
			}
			cur=cur.next;
		}
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		
		Solution s = new Solution();
		s.reorderList(l1);
		ListNode cur=l1;
		
		for(int i=0;i<3;i++){
			
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
}
