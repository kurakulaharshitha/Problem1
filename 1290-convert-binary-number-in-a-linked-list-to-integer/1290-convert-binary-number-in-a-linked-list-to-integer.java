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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        int count=0;
    

        while (temp!=null)
        {
            count=count+1;
            temp=temp.next;
           

        }
        int result=0;
        temp=head;
        while(temp!=null)
        {
            result+=temp.val*Math.pow(2,count-1);
            count=count-1;
            temp=temp.next;
        }
        return result;
        
    }
}