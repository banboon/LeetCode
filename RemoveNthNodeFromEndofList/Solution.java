package RemoveNthNodeFromEndofList;

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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null||head.next==null)
			return null;
		HashMap<Integer,ListNode> map = new HashMap<Integer,ListNode>();
		ListNode cur=head;
		int key=0;
		while(cur!=null){
			map.put(key, cur);
			key++;
			cur=cur.next;
		}
		if(key<n)
			return null;
		else{
			ListNode dest = map.get(key-n);		
			if(n==1){
				ListNode before = map.get(key-n-1);
				before.next=null;
			}
			else if(key-n==0){
				head=head.next;
			}
			else{
				ListNode before = map.get(key-n-1);
			    before.next=dest.next;
			    dest.next=null;
			}
		}
		return head;
	}
}
