class Solution 
{
    int[] height = new int[1000001];
    int[] level = new int[1000001];
    int[] maxlevel = new int[1000001];
    int[] secondmax = new int[1000001];

    public int[] treeQueries(TreeNode root, int[] queries) 
    {
        h(root, 0);

        int[] ans = new int[queries.length];
        int idx = 0;

        for(int q : queries)
        {
            int l = level[q];

            int best = (height[q] == maxlevel[l]) 
                        ? secondmax[l] 
                        : maxlevel[l];

            ans[idx++] = l + best - 1;
        }

        return ans;
    }

    public int h(TreeNode root, int l)
    {
        if(root == null)
            return 0;

        level[root.val] = l;

        int left = h(root.left, l + 1);
        int right = h(root.right, l + 1);

        height[root.val] = Math.max(left, right) + 1;
        if(maxlevel[l] < height[root.val])
        {
            secondmax[l] = maxlevel[l];
            maxlevel[l] = height[root.val];
        }
        else if(secondmax[l] < height[root.val])
        {
            secondmax[l] = height[root.val];
        }

        return height[root.val];
    }
}
