class Solution 
{
    int count = 0;

    public int averageOfSubtree(TreeNode root) 
    {
        dfs(root);
        return count;
    }

    public int[] dfs(TreeNode root)
    {
        if (root == null)
        {
            return new int[]{0, 0}; // sum, count
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int num = left[1] + right[1] + 1;

        if (sum / num == root.val)
        {
            count++;
        }

        return new int[]{sum, num};
    }
}
