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
    public ListNode[] splitListToParts(ListNode head, int k) {

        int n=0;
        ListNode current=head;
        while(current!=null)
        {
            n++;
            current=current.next;
        }
        int base=n/k;
        int extra=n%k;
        ListNode[] result=new ListNode[k];
        current=head;
        for(int i=0;i<k;i++)
        {
            result[i]=current;
            int size=base;
            if(extra>0)
            {
                size++;
                extra--;

            }

        

        for(int j=1;j<size;j++)
        {
            current=current.next;
        }
        //to disconnect 
        if(current!=null)
        {
            ListNode nextpart=current.next;
            current.next=null;
            current=nextpart;
        }
        }
        return result;
    }
}