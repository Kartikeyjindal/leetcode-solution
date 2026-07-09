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
    ArrayList<TreeNode> ans=new ArrayList<>();
    public void recoverTree(TreeNode root) 
    {
        inorder(root);
        TreeNode p1=null,p2=null;
        for(int i=0;i<ans.size()-1;i++)
        {
            if(ans.get(i).val>ans.get(i+1).val)
            {
                if(p1==null)
                {
                    p1=ans.get(i);
                }
                p2=ans.get(i+1);
            }
        }
        int temp=p1.val;
        p1.val=p2.val;
        p2.val=temp;
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        inorder(root.left);
        ans.add(root);
        inorder(root.right);
    }
}