class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int []prev=new int[n];
        Arrays.fill(prev,-1);
        int []len=new int[n];
        Arrays.fill(len,1);
        int maxlen=1;
        int lastchoosen=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(len[i]<len[j]+1)
                    {
                        len[i]=len[j]+1;
                        prev[i]=j;
                    }
                    if(len[i]>maxlen)
                    {
                        maxlen=len[i];
                        lastchoosen=i;
                    }
                }
            }
        }
        while(lastchoosen!=-1)
        {
            ans.add(nums[lastchoosen]);
            lastchoosen=prev[lastchoosen];
        }
        return ans;
    }
}
