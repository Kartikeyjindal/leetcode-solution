class Solution 
{
    public long totalsum = 0;
    public long product = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) 
    {
        totalsum = sum(root);
        partialsum(root);
        return (int)(product % MOD);
    }

    public long sum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        long leftsum = sum(root.left);
        long rightsum = sum(root.right);
        return root.val + leftsum + rightsum;
    }

    public long partialsum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        long leftsum = partialsum(root.left);
        long rightsum = partialsum(root.right);
        long tsum = root.val + leftsum + rightsum;

        long remainingsum = totalsum - tsum;
        product = Math.max(product, tsum * remainingsum);

        return tsum;
    }
}
