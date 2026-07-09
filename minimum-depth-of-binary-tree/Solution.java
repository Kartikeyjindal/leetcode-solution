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
    public int minDepth(TreeNode root) 
    {
        return solve(root);
    }
    public int solve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size>0)
            {
                TreeNode node=queue.poll();
                if(node.left==null&&node.right==null)
                {
                    return ans;
                }
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}