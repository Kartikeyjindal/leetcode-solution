class Solution 
{
    public int[] findDiagonalOrder(List<List<Integer>> nums) 
    {
        int n = nums.size();
        int size = 0;

        List<int[]> pair = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            int m = nums.get(i).size();
            for (int j = 0; j < m; j++)
            {
                pair.add(new int[]{i + j, j});
                size++;
            }
        }

        Collections.sort(pair, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] result = new int[size];
        for (int i = 0; i < size; i++)
        {
            int diag = pair.get(i)[0];
            int col  = pair.get(i)[1]; 
            int row  = diag - col;     

            result[i] = nums.get(row).get(col);
        }

        return result;
    }
}
