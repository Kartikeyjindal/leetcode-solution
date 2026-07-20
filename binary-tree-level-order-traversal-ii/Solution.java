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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> result=new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer>list=new ArrayList<>();
            int length=queue.size();
            TreeNode currentelement;
            for(int i=0;i<length;i++)
            {
                currentelement=queue.poll();
                list.add(currentelement.val);
                if(currentelement.left != null)
                {
                    queue.add(currentelement.left);
                }
                if(currentelement.right != null)
                {
                    queue.add(currentelement.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}