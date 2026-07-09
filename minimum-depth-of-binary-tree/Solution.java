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
        if(root.left==null&& root.right==null)
        {
            return 1;
        }
        int left=root.left!=null?solve(root.left):Integer.MAX_VALUE;
        int right=root.right!=null?solve(root.right):Integer.MAX_VALUE;
        return 1+Math.min(left,right);
    }
}