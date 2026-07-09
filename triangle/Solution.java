class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int n=triangle.size();
        List<Integer> ans=triangle.get(n-1);

        for(int row=n-2;row>=0;row--)
        {
            for(int col=0;col<=row;col++)
            {
                int temp=triangle.get(row).get(col)+Math.min(ans.get(col),ans.get(col+1));
                ans.set(col,temp);
            }
        }
        return ans.get(0);
    }
}
