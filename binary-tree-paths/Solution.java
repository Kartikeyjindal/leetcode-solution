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
    List<String>ans;
    public List<String> binaryTreePaths(TreeNode root) 
    {
        ans=new ArrayList<>();
        solve(root,"");
        return ans;

    }
    public void solve(TreeNode root,String s)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            ans.add(s+root.val);
            return;
        }
        solve(root.left,s+root.val+"->");
        solve(root.right,s+root.val+"->");
    }
}