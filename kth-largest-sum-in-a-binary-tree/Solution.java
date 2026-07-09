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
    public long kthLargestLevelSum(TreeNode root, int k) 
    {
        int h=height(root);
        if(h<k)
        {
            return -1;
        }
        ArrayList<Long> arr=new ArrayList<>();
        Queue<TreeNode> queue=new  LinkedList<>();
        queue.add(root);
        long sum=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            sum=0;
            while(size>0)
            {
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                size--;
            }
            arr.add(sum);
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        return arr.get(k-1);
    }

    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int h=1+Math.max(left,right);
        return h;
    }
}