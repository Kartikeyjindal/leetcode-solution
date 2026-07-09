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
    public int pathSum(TreeNode root, int targetsum) 
    {
        if(root==null)
        {
            return 0;
        }
        int take=solve(root,(long)targetsum);
        int leave=pathSum(root.left,targetsum)+pathSum(root.right,targetsum);
        return take+leave;
    }
    public int solve(TreeNode root,long target)
    {
        int count=0;
        if(root==null)
        {
            return 0;
        }
        if(root.val==target)
        {
            count++;
        }
        count+=solve(root.left,target-root.val);
        count+=solve(root.right,target-root.val);
        return count;
    }
}