class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            TreeNode node = null;

            while (n-- > 0)
            {
                node = queue.poll();

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            arr.add(node.val);
        }
        return arr;
    }
}
