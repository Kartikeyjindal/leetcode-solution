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
    public TreeNode pruneTree(TreeNode root) 
    {
        if(root==null)
        {
            return root;
        }
        if(!one(root.left))
        {
            root.left=null;
        }
        if(!one(root.right))
        {
            root.right=null;
        }
        pruneTree(root.left);
        pruneTree(root.right);

        if(root.left==null && root.right==null && root.val==0)
        {
            root=null;
        }
        return root;
    }

    public boolean one(TreeNode root)
    {
        if(root==null)
        {
            return false;
        }
        if(root.val==1)
        {
            return true;
        }
        return one(root.left)||one(root.right);
    }
}