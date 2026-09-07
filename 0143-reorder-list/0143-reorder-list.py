# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if head is None or head.next is None:
            return
        #find the middle 
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        #reverse the second half
        second=slow.next
        slow.next=None
        prev=None
        while second:
            temp=second.next
            second.next=prev
            prev=second
            second=temp
        second=prev
        #merge them alternatively
        first=head
        while second:
            temp1=first.next
            temp2=second.next
            first.next=second
            second.next=temp1
            first=temp1
            second=temp2

       
        