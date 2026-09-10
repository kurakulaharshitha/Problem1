# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter=0
        def height(root):
            nonlocal diameter
            if root is None:
                return 0
            ld=height(root.left)
            rd=height(root.right)
            diameter=max(diameter,ld+rd)
            return 1+max(ld,rd)
        height(root)
        return diameter
        