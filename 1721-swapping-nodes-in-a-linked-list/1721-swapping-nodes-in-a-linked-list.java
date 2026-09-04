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
    public ListNode swapNodes(ListNode head, int k) {
        int n=0;
        ListNode temp=head;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
       ListNode first=head;
       for(int i=1;i<k;i++)
       {
        first=first.next;
       }
       ListNode last=head;
       int position=n-k+1;
       for(int i=1;i<position;i++)
       {
        last=last.next;
       }
       int temp_value=first.val;
       first.val=last.val;
       last.val=temp_value;
       return head;

        
    }
}