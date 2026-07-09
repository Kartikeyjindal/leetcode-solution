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
    public int[] findMode(TreeNode root) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            int key=node.val;
            if(map.containsKey(key))
            {
                map.put(key,map.get(key)+1);
            }
            else
            {
                map.put(key,1);
            }
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }
        int max=0;
        for(int value:map.values())
        {
            max=Math.max(max,value);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==max)
            {
                arr.add(entry.getKey());
            }
        }
        int[]ans=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            ans[i]=arr.get(i);
        }
        return ans;
    }
}