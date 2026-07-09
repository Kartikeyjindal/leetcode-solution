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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) 
    {
        if(root==null)
        {
            return ans;
        }
        dfs(root,targetsum,0,new ArrayList<>());
        return ans;
    }
    public void dfs(TreeNode root,int target,int sum,List<Integer> currans)
    {
        if(root==null)
        {
            return;
        }
        sum+=root.val;
        currans.add(root.val);
        if(root.left==null&&root.right==null&&sum==target)
        {
            ans.add(new ArrayList<>(currans));
        }
        dfs(root.left,target,sum,currans);
        dfs(root.right,target,sum,currans);
        currans.remove(currans.size()-1);
    }
}