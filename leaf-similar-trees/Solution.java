class Solution 
{
    ArrayList<Integer> r1 = new ArrayList<>();
    ArrayList<Integer> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        solve(root1, r1);
        solve(root2, r2);

        return r1.equals(r2);
    }

    public void solve(TreeNode root, ArrayList<Integer> res)
    {
        if (root == null)
        {
            return;
        }

        if (root.left == null && root.right == null)
        {
            res.add(root.val);
            return;
        }

        solve(root.left, res);
        solve(root.right, res);
    }
}
