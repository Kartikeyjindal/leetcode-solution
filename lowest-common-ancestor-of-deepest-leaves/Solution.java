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
    public TreeNode lcaDeepestLeaves(TreeNode root)
    {
        int hl=height(root.left);
        int hr=height(root.right);
        if(hl==1 && hr==1)
        {
            return root ;
        }
        if(hl>hr)
        {
            return lcaDeepestLeaves(root.left);
        }
        else if(hr>hl)
        {
            return lcaDeepestLeaves(root.right);
        }
        return root;

    }

    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int lefth=height(root.left);
        int righth=height(root.right);

        int h=1+Math.max(lefth,righth);
        
        return h;
    }
}
