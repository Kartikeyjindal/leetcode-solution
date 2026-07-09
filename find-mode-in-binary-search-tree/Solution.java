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
    int currfreq=0;
    int maxfreq=0;
    int pastnum=0;
    ArrayList<Integer> arr=new ArrayList<>();

    public int[] findMode(TreeNode root) 
    {
        dfs(root);
        int []result=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            result[i]=arr.get(i);
        }
        return result;    
    }

    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        dfs(root.left);
        if(root.val==pastnum)
        {
            currfreq++;
        }
        else
        {
            pastnum=root.val;
            currfreq=1;
        }
        if(currfreq==maxfreq)
        {
            arr.add(root.val);
        }
        if(currfreq>maxfreq)
        {
            arr.clear();
            arr.add(root.val);
            maxfreq=currfreq;
        }
        dfs(root.right);
    }
}