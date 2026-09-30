# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode | None) -> int:
        def dfs(node,num):
            if node is None:
                return 0
            num=num*10+node.val
            if node.left is None and node.right is None:
                return num
            return dfs(node.left,num)+dfs(node.right,num)
        return dfs(root,0)
        