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
    public TreeNode addOneRow(TreeNode root, int val, int depth) 
    {
        if(depth==1)
        {
            TreeNode newroot=new TreeNode(val);

            newroot.left=root;

            return newroot;
        }

        int curr=1;
        solve(root,val,depth,curr);
        return root;
    }

    public void solve(TreeNode root,int val,int depth,int curr)
    {
        if(root==null)
        {
            return ;
        }
        if(depth-1==curr)
        {
            TreeNode newleft=root.left;
            TreeNode newright=root.right;

            root.left=new TreeNode(val);
            root.right=new TreeNode(val);

            root.left.left=newleft;
            root.right.right=newright;
            return ;
        }
        solve(root.left,val,depth,curr+1);
        solve(root.right,val,depth,curr+1);
    }
}