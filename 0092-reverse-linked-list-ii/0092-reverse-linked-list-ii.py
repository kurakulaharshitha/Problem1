# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseBetween(self, head, left, right):
        dummy = ListNode(0)
        dummy.next = head

        prev = dummy

        for i in range(left - 1):
            prev = prev.next

        curr = prev.next

        for i in range(right - left):

            next_node = curr.next

            curr.next = next_node.next

            next_node.next = prev.next

            prev.next = next_node

        return dummy.next

       
        