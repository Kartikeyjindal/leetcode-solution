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
    int count=0;
    public int countDominantNodes(TreeNode root) 
    {
        dfs(root);
        return count;
    }

    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);

        int maxchild=Math.max(left,right);
        int maxval=Math.max(maxchild,root.val);

        if(root.val==maxval)
        {
            count++;
        }

        return maxval;
    }
}