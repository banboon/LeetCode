package AddTwoNumbers;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   	ListNode l3 = new ListNode(0);
   	ListNode result=l3;
   	int ten=0, unit=0;
   	while(l1!=null||l2!=null){
   		int temp1=0, temp2=0;
   		if(l1!=null)
   			temp1=l1.val;
   		if(l2!=null)
   			temp2=l2.val;
   		unit=(temp1+temp2)%10;
   		l3.val=(unit+ten)%10;
      		ten=(temp1+temp2+ten)/10;
       	if(l1!=null)
       	    l1=l1.next;
       	if(l2!=null)
       	    l2=l2.next;
       	if(l1!=null||l2!=null){
         	   l3.next=new ListNode(0);
         	   l3=l3.next;
       	}
   	}
   	if(ten>0)
   		l3.next=new ListNode(ten);		
		return result;
   }
}
   
public class AddTwoNumbers {
	public static void main(String args[]){
		ListNode l1=new ListNode(9);
		ListNode l12=new ListNode(9);
		ListNode l13=new ListNode(9);
		l1.next=l12;
		l12.next=l13;
		ListNode l2=new ListNode(1);
		Solution s=new Solution();
		ListNode l3=s.addTwoNumbers(l1, l2);
		while(l3!=null){
			System.out.println(l3.val);
			l3=l3.next;
		}
	}
}
