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
    ArrayList<Integer>arr=new ArrayList<>();
    public int kthLargestPerfectSubtree(TreeNode root, int k) 
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            solve(node);
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }
        Collections.sort(arr);
        int n=arr.size();
        if(n<k)
        {
            return -1;
        }
        return arr.get(n-k);
    }
    public void solve(TreeNode root)
    {
        if(height(root.left)==height(root.right))
        {
            arr.add((int)Math.pow(2,1+height(root.left))-1);
        }
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(left!=right)
        {
            return Integer.MAX_VALUE;
        }
        return 1+Math.min(left,right);
    }

}