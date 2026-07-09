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
    public boolean isCompleteTree(TreeNode root) 
    {
        int i=1;
        int num=count(root);
        return completetree(root,num,i);
    }
    public int count(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    public boolean completetree(TreeNode root,int num,int i)
    {
        if(root==null)
        {
            return true;
        }
        if(i>num)
        {
            return false;
        }
        return completetree(root.left,num,2*i)&&completetree(root.right,num,2*i+1);
    }
}