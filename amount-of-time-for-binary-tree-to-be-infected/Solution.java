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
class Solution 
{
    public int amountOfTime(TreeNode root, int start) 
    {
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        dfsparent(root,parent);
        Map<TreeNode,Integer> visited=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode target=dfstarget(root,start);
        visited.put(target,1);
        q.add(target);
        int dis=0;
        while(!q.isEmpty())
        {
            dis++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(parent.containsKey(node)&&!visited.containsKey(parent.get(node)))
                {
                    visited.put(parent.get(node),1);
                    q.offer(parent.get(node));
                }
                if(node.left!=null && !visited.containsKey(node.left))
                {
                    visited.put(node.left,1);
                    q.offer(node.left);
                }
                if(node.right!=null && !visited.containsKey(node.right))
                {
                    visited.put(node.right,1);
                    q.offer(node.right);
                }
            }
        }
        return dis-1;
    }
    public static void dfsparent(TreeNode root,Map<TreeNode,TreeNode> parent)
    {
        if(root==null)
        {
            return;
        }
        if(root.left!=null)
        {
            parent.put(root.left,root);
        }
        if(root.right!=null)
        {
            parent.put(root.right,root);
        }
        dfsparent(root.left,parent);
        dfsparent(root.right,parent);
    }
    public static TreeNode dfstarget(TreeNode root,int start)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==start)
        {
            return root;
        }
        TreeNode left=dfstarget(root.left,start);
        TreeNode right=dfstarget(root.right,start);
        if(left==null)
        {
            return right;
        }
        return left;
    }
}