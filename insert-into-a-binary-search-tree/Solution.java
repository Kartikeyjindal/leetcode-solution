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
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        TreeNode value=new TreeNode(val);
        if(root == null)
        {
            return value;
        }
        insert(root,value);
        return root;
    }   

    public void insert(TreeNode root ,TreeNode  value)
    {
        if(root == null)
        {
            return ;
        }
        if(root.left == null && root.val>value.val)
        {
            root.left=value;
        }
        if(root.right == null && root.val<value.val)
        {
            root.right=value;
        }
        if(root.val < value.val)
        {
            insert(root.right,value);
        }
        if(root.val > value.val)
        {
            insert(root.left,value);
        }
    }
}
