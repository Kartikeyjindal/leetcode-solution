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
    public TreeNode reverseOddLevels(TreeNode root) 
    {
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<TreeNode> arr=new ArrayList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            arr.clear();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                arr.add(node);
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
            if(level%2!=0)
            {
                int start=0;
                int end=arr.size()-1;
                while(start<end)
                {
                    int value=arr.get(start).val;
                    arr.get(start).val=arr.get(end).val;
                    arr.get(end).val=value;
                    start++;
                    end--;
                }
            }
            level++;
        }
        return root;
    }
}