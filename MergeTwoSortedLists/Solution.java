package MergeTwoSortedLists;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null)
			return null;
		else if(l1==null&&l2!=null)
			return l2;
		else if(l1!=null&l2==null)
			return l1;
		ListNode root;
		ListNode cur;
		if(l1.val<l2.val){
			cur=l1;
			l1=l1.next;
		}
		else{
			cur=l2;
			l2=l2.next;
		}
		root=cur;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				cur.next=l1;
				l1=l1.next;
			}
			else{
				cur.next=l2;
				l2=l2.next;
			}
			cur=cur.next;
		}
		if(l1!=null)
			cur.next=l1;
		if(l2!=null)
			cur.next=l2;
		return root;
	}
	public static void main(String[] args){
		Solution s= new Solution();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		System.out.println(s.mergeTwoLists(a, b));
	}
}