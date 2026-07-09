class Solution 
{
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        return solve(p, q);
    }

    public boolean solve(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return solve(p.left, q.left) && solve(p.right, q.right);
    }
}
