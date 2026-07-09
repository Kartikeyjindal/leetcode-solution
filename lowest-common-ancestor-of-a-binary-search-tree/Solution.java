/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null)
        {
            return null;
        }
        if(root==p||root==q)
        {
            return root;
        }
        TreeNode leftn=lowestCommonAncestor(root.left,p,q);
        TreeNode rightn=lowestCommonAncestor(root.right,p,q);

        if(leftn!=null && rightn!=null)
        {
            return root;
        }
        if(leftn!=null)
        {
            return leftn;
        }
        return rightn;
    }
}