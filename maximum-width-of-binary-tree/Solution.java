class Solution 
{
    class Pair 
    {
        TreeNode node;
        long idx;
        Pair(TreeNode n, long i) 
        {
            node = n;
            idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) 
    {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0L));
        long maxw = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            long start = queue.peek().idx;
            long end = start;

            for (int i = 0; i < size; i++)
            {
                Pair p = queue.poll();
                TreeNode node = p.node;
                long idx = p.idx;

                end = idx;

                if (node.left != null)
                    queue.add(new Pair(node.left, 2 * idx));

                if (node.right != null)
                    queue.add(new Pair(node.right, 2 * idx + 1));
            }

            maxw = Math.max(maxw, end - start + 1);
        }

        return (int) maxw;
    }
}
