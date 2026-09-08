/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
         //bfs method level by level =>queue
         Deque<Node> q=new ArrayDeque<>();
         //procees teh queue
         if (root == null)
         return res;

        q.add(root);
         while(!q.isEmpty())
         {
            int size=q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                Node node=q.poll();
                level.add(node.val);
               
                if(node.children!=null)
                {
                   for(Node child:node.children)
                   {
                    q.add(child);
                   }
                }
            }
            res.add(level);
         }
         return res;
        
    }
}