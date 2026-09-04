# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        slow=head
        fast=head
        # to find out the middle 
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        # to reverse the second half
        prev=None
        curr=slow
        while curr:
            next_node=curr.next
            curr.next=prev
            prev=curr
            curr=next_node
        #to compare left half and right half
        left=head
        right=prev
        while right:
            if left.val!=right.val:
                return False
            left=left.next
            right=right.next
        return True

        