package InsertionSortList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	ListNode result = new ListNode(head.val);
    	head=head.next;
    	while(head!=null){
    		ListNode cur = result;
    		ListNode before = result;
    		ListNode temp = new ListNode(head.val);
    		if(temp.val<=result.val){
    			temp.next=result;
    			result=temp;
    		}
    		else{
    			while(cur!=null){
    				if(temp.val<cur.val)
    					break;
    				before=cur;
    				cur=cur.next;
    			}
    			if(cur==null){
    				before.next=temp;
    			}
    			else{
    				before.next=temp;
    				temp.next=cur;
    			}
    		}
    		head=head.next;
    	}
        return result;
    }
    
    public static void main(String[] args){
    	ListNode ln = new ListNode(1);
    	ListNode ln1 = new ListNode(1);
    	ln.next=ln1;
    	Solution s = new Solution();
    	System.out.println(s.insertionSortList(ln));
    }
}
