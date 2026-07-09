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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
      List<Integer> result=new ArrayList<>();

      traversalinorder(root,result);
      return result;  
    }

    public void traversalinorder(TreeNode node, List<Integer>result)
    {
        if(node == null)
        {
            return;
        }
        traversalinorder(node.left,result);
        result.add(node.val);
        traversalinorder(node.right,result);
    }
}