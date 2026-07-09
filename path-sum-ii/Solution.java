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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> output=new ArrayList<>();
        dfs(root,targetSum,0,output,new ArrayList<>());
        return output;
    }

    public void dfs(TreeNode root, int targetsum,int currsum,List<List<Integer>> output,List<Integer> currlist)
    {
        if(root==null)
        {
            return ;
        }
        currsum+=root.val;
        currlist.add(root.val);

        if(root.left==null && root.right==null && currsum==targetsum)
        {
            output.add(new ArrayList<>(currlist));
        }
        dfs(root.left,targetsum,currsum,output,currlist);
        dfs(root.right,targetsum,currsum,output,currlist);

        currlist.remove(currlist.size()-1);
    }
}