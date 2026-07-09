class Solution 
{
    public int minDeletionSize(String[] strs) 
    {
        int row = strs.length;
        int col = strs[0].length();
        int delete = 0;

        boolean[] arr = new boolean[row - 1];

        for (int i = 0; i < col; i++)
        {
            boolean del = false;
            for (int j = 0; j < row - 1; j++)
            {
                if (!arr[j] && strs[j].charAt(i) > strs[j + 1].charAt(i))
                {
                    del = true;
                    delete++;
                    break;
                }
            }

            if (del) continue;
            for (int k = 0; k < row - 1; k++)
            {
                if (!arr[k] && strs[k].charAt(i) < strs[k + 1].charAt(i))
                {
                    arr[k] = true;
                }
            }
        }
        return delete;
    }
}
