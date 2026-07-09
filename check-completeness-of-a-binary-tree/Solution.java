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
import java.util.*;

class Solution 
{
    public boolean isCompleteTree(TreeNode root) 
    {
        int num=count(root);
        int i=1;
        return dfs(root,num,i);
    }
    public int count(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    public boolean dfs(TreeNode root,int num,int i)
    {
        if(root == null)
        {
            return true;
        }
        if(i>num)
        {
            return false;
        }
        return dfs(root.left,num,2*i)&&dfs(root.right,num,2*i+1);
    }
}
