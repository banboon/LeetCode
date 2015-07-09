package SortList;

import java.util.ArrayList;
import java.util.Arrays;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {


	    
	    public ListNode sortList(ListNode head) {
	        
	        if(head==null||head.next == null)
	            return head;
	        
	        int len = 0;
	        ListNode cur = head;
	        while(cur!=null){
	            len++;
	            cur=cur.next;
	        }
	        
	        return merge(head,len);
	    }
	    
	    public ListNode merge(ListNode head, int len){
	        
	        if(len==1) {
	            // important
	            ListNode temp = head;
	            head=head.next;
	            temp.next = null;
	            return temp;
	        }
	        
	        ListNode left = merge(head, len/2);
	        
	        ListNode right = merge(head, len-len/2);

	        
	        
	        return mergeTwo(left,right);
	    }
	    
	    public ListNode mergeTwo(ListNode A, ListNode B){
	        
	        ListNode dummy = new ListNode(0);
	        ListNode cur  = dummy;
	        while(A!=null&&B!=null){
	            if(A.val<B.val){
	                cur.next = A;
	                A=A.next;
	            }
	            else{
	                cur.next = B;
	                B=B.next;
	            }
	            cur = cur.next;
	        }
	        
	        if(A!=null)
	            cur.next = A;
	        if(B!=null)
	            cur.next = B;
	        return dummy.next;  
	    }
	
	public void test(ArrayList<Integer> list){
		
		System.out.println(list);
		add(list);
		System.out.println(list);
		
	}
	
	public void add(ArrayList<Integer> list){
		list.add(100);
	}
	
	public void move(ListNode node){
		node = node.next;
	}
	
	public void test(ListNode a){
		System.out.println(a.val);
		move(a);
		System.out.println(a.val);
	}
	
	public static void main(String[] args){
		
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		Solution s = new Solution();
		s.test(a);
		s.test(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)));
	}
}
