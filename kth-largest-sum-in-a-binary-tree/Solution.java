class Solution 
{
    public long kthLargestLevelSum(TreeNode root, int k) 
    {
        ArrayList<Long> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            long sum = 0;

            while (size > 0)
            {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
                size--;
            }
            arr.add(sum);
        }
        if (arr.size() < k)
        {
            return -1;
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        return arr.get(k - 1);
    }
}
