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
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        int []digit=new int[10];
        return dfs(root,digit);
    }
    public int dfs(TreeNode root,int[] digit)
    {
        if(root==null)
        {
            return 0;
        }
        digit[root.val]++;
        if(root.left==null&&root.right==null)
        {
            int cnt=count(digit);
            digit[root.val]--;
            if(cnt<=1)
            {
                return 1;
            }
            return 0;
        }
        int left=dfs(root.left,digit);
        int right=dfs(root.right,digit);
        digit[root.val]--;
        return left+right;
    }
    public int count(int []digit)
    {
        int cnt=0;
        for(int i=0;i<digit.length;i++)
        {
            if((digit[i]&1)==1)
            {
                cnt++;
            }
        }
        return cnt;
    }
}