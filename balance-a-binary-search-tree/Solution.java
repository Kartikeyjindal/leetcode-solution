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
    ArrayList<Integer> arr=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) 
    {
        dfs(root);
        return maketree(0,arr.size()-1);
    }
    
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }

    public TreeNode maketree(int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(arr.get(mid)); 
        node.left=maketree(start,mid-1);
        node.right=maketree(mid+1,end);
        return node;
    }
}