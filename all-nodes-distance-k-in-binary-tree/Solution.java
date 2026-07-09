/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    List<Integer> ans=new ArrayList<>();
    Map<TreeNode,TreeNode> parent=new HashMap<>();
    Set<TreeNode> visited=new HashSet<>();
    public void solve(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        if(root.left!=null)
        {
            parent.put(root.left,root);
        }
        solve(root.left);
        if(root.right!=null)
        {
            parent.put(root.right,root);
        }
        solve(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        solve(root);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        visited.add(target);
        while(!queue.isEmpty())
        {
            if(k==0)
            {
                break;
            }
            int size=queue.size();
            while(size>0)
            {
                TreeNode node=queue.poll();
                if(node.left!=null&&!visited.contains(node.left))
                {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null&&!visited.contains(node.right))
                {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(parent.get(node)!=null&&!visited.contains(parent.get(node)))
                {
                    queue.add(parent.get(node));
                    visited.add(parent.get(node));
                }
                size--;
            }
            k--;
        }
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            ans.add(node.val);
        }
        return ans;
    }
}