/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null)
        return head;
        ListNode current=head;
        int count=0;
    
        while(current!=null)
        {
            count=count+1;
            current=current.next;
        }
        k=k%count;
        for(int i=0;i<k;i++)
        {
            current=head;
            while  (current.next.next!=null)
            {
                current=current.next;
            }
                ListNode temp=current.next;
                current.next=null;
                temp.next=head;
                head=temp;



            
        }
        return head;
        
    }
}