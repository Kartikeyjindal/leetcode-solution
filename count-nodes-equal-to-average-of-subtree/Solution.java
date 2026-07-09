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
    public int averageOfSubtree(TreeNode root) 
    {
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        int sum=sumsolve(root);
        int num=numsolve(root);
        if(sum/num==root.val)
        {
            count++;
        }
    }


    public int sumsolve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=sumsolve(root.left);
        int right=sumsolve(root.right);
        return root.val+left+right;
    } 

    public int numsolve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=numsolve(root.left);
        int right=numsolve(root.right);
        return 1+left+right;
    }

}