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
    public boolean isEvenOddTree(TreeNode root) 
    {
        int level=0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                //for even index
                if(level%2==0)
                {
                    if(node.val%2==0||prev>=node.val)
                    {
                        return false;
                    }
                }
                else
                {
                    if(node.val%2!=0||prev<=node.val)
                    {
                        return false;
                    }
                }
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                prev=node.val;
            }
            level++;
        }
        return true;
    }
}