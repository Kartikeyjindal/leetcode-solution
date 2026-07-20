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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> result=new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            double sum=0;
            int length=queue.size();
            for(int i=0;i<length;i++)
            {
                TreeNode currentelement=queue.poll();
                sum=sum+currentelement.val;
                if(currentelement.left != null)
                {
                    queue.offer(currentelement.left);
                }
                if(currentelement.right != null)
                {
                    queue.offer(currentelement.right);
                }
            }
            double ans=sum/length;
            result.add(ans);
        }
        return result;
    }
}