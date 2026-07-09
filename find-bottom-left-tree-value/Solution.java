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
    public int findBottomLeftValue(TreeNode root) 
    {
        List<Integer> list=new ArrayList<>();
        preorder(root,1,list);
        return list.get(list.size()-1);
    }
    public void preorder(TreeNode root,int level,List<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        if(list.size()<level)
        {
            list.add(root.val);
        }
        preorder(root.left,level+1,list);
        preorder(root.right,level+1,list);
    }
}