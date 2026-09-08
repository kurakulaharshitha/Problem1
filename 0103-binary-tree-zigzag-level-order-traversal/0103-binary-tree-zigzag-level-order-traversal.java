/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        //bfs -queued
        Queue<TreeNode> q= new ArrayDeque<>();
        //add the root into queue
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty())
        {
            //find the size of the queue
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                level.add(temp.val);
                //to add left child
                if(temp.left!=null)
                {
                    q.offer(temp.left);

                }
                //to add right child
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
            }
            if(!flag)
            {
                Collections.reverse(level);
            }
            res.add(level);
            flag=!flag;
            
        }
        return res;
        
    }
}