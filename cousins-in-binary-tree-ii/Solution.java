class Solution 
{
    ArrayList<Integer> lsum = new ArrayList<>();

    public TreeNode replaceValueInTree(TreeNode root) 
    {
        levelsum(root);
        root.val = 0;
        solve(root, 1);
        return root;
    }

    public void levelsum(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int sum = 0;

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

            lsum.add(sum);
        }
    }

    public void solve(TreeNode root, int depth)
    {
        if(root == null) return;

        int childSum = 0;

        if(root.left != null)
            childSum += root.left.val;

        if(root.right != null)
            childSum += root.right.val;

        if(root.left != null)
            root.left.val = lsum.get(depth) - childSum;

        if(root.right != null)
            root.right.val = lsum.get(depth) - childSum;

        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }
}
