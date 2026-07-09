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
    int []arr=new int[101];
    int []prefix=new int[101];
    boolean has100=false;
    public TreeNode bstToGst(TreeNode root) 
    {
        dfs(root);
        if(has100)
        {
            prefix[100]=100;
        }
        for(int i=99;i>=0;i--)
        {
            prefix[i]=prefix[i+1]+arr[i];
        }
        return inorder(root);
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        if(root.val==100)
        {
            has100=true;
        }
        arr[root.val]=root.val;
        dfs(root.left);
        dfs(root.right);
    }
    public TreeNode inorder(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        inorder(root.left);
        root.val=prefix[root.val];
        inorder(root.right);
        return root;
    }
}