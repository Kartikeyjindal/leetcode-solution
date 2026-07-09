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
    int ans=0;
    public int longestZigZag(TreeNode root) 
    {
        solve(root,'L',0);
        solve(root,'R',0);
        return ans;
    }
    public void solve(TreeNode root,char direction,int length)
    {
        if(root==null)
        {
            return ;
        }
        ans=Math.max(ans,length);
        if(direction=='L')
        {
            solve(root.left,'L',1);
            solve(root.right,'R',length+1);
        }
        else
        {
            solve(root.left,'L',length+1);
            solve(root.right,'R',1);
        }
    }
}