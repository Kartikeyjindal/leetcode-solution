class Solution 
{
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        int n = inorder.length;
        return solve(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode solve(int[] inorder, int[] postorder,int instart, int inend,int poststart, int postend)
    {
        if (instart > inend || poststart > postend)
            return null;

        TreeNode root = new TreeNode(postorder[postend]);

        int i = instart;
        for (; i <= inend; i++)
        {
            if (inorder[i] == root.val)
                break;
        }

        int leftsize = i - instart;
        int rightsize = inend - i;
        root.left = solve(inorder, postorder,instart, i - 1,poststart, poststart + leftsize - 1);
        root.right = solve(inorder, postorder,i + 1, inend,postend - rightsize, postend - 1);

        return root;
    }
}
