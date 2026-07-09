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
    public int sumOfLeftLeaves(TreeNode root) 
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=0;
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
                if(node.left!=null && node.left.left==null && node.left.right==null)
                {
                    ans+=node.left.val;
                }
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
        }
        return ans;
    }
}