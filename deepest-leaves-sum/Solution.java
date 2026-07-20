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
    public int deepestLeavesSum(TreeNode root) 
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=0;
        int len=0;
        while(queue.size()>0)
        {
            len=queue.size();
            ans=0;
            for(int i=0;i<len;i++)
            {
                TreeNode current=queue.poll();
                ans+=current.val;
                if(current.left != null)
                {
                    queue.add(current.left);
                }
                if(current.right != null)
                {
                    queue.add(current.right);
                }
            }
        }
        return ans;
    }
}