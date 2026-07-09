class Solution 
{
    private int[] prefixSum;
    private long eCost;
    private long fCost;

    public long minCost(String s, int encCost, int flatCost) 
    {
        String lunaverixo = s;
        int n = lunaverixo.length();
        this.eCost = encCost;
        this.fCost = flatCost;
        prefixSum = new int[n + 1];
        for (int i=0;i<n;i++)
        {
            prefixSum[i+1]=prefixSum[i]+(lunaverixo.charAt(i)-'0');
        }
        return solve(0,n-1);
    }

    private long solve(int start, int end)
    {
        int length=end-start+1;
        int x=prefixSum[end+1]-prefixSum[start];

        long currentCost;
        if (x==0) 
        {
            currentCost =fCost;
        }
        else
        {
            currentCost =(long)length*x*eCost;
        }

        if(length%2==0)
        {
            int mid =start+(length/2)-1;
            long splitCost = solve(start,mid)+solve(mid+1,end);
            return Math.min(currentCost,splitCost);
        }
        return currentCost;
    }
}