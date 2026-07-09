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
    public TreeNode createBinaryTree(int[][] d) 
    {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int []a:d)
        {
            int parentv=a[0];
            int childv=a[1];
            int left=a[2];

            map.putIfAbsent(parentv,new TreeNode(parentv));
            map.putIfAbsent(childv,new TreeNode(childv));
            TreeNode parent=map.get(parentv);
            TreeNode child=map.get(childv);
            if(left==1)
            {
                parent.left=child;
            }
            else
            {
                parent.right=child;
            }

            set.add(childv);
        }
        for(int a:map.keySet())
        {
            if(!set.contains(a))
            {
                return map.get(a);
            }
        }
        return null;
    }
}