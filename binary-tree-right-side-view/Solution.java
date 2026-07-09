class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        preorder(root, 1, list);
        return list;
    }

    public void preorder(TreeNode root, int level, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }
        if (list.size() < level)
        {
            list.add(root.val);
        }
        preorder(root.right, level + 1, list);
        preorder(root.left, level + 1, list);
    }
}
