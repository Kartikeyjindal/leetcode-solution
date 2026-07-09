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
class FindElements 
{
    TreeNode root;

    public FindElements(TreeNode root) 
    {
        this.root = root; 
        if(root != null)
        {
            root.val = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty())
            {
                TreeNode node = queue.poll();

                if(node.left != null)
                {
                    node.left.val = 2 * node.val + 1;
                    queue.add(node.left);
                }

                if(node.right != null)
                {
                    node.right.val = 2 * node.val + 2;
                    queue.add(node.right);
                }
            }
        }
    }
    
    public boolean find(int target) 
    {
        if(root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if(node.val == target)
                return true;

            if(node.left != null)
                queue.add(node.left);

            if(node.right != null)
                queue.add(node.right);
        }

        return false;
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */