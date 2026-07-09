class Solution 
{
    public int maxSumRangeQuery(int[] nums, int[][] requests) 
    {
        int n=nums.length;
        int []arr=new int[n+1];
        
        for(int []a:requests)
        {
            arr[a[0]]+=1;
            arr[a[1]+1]-=1;
        }
        int count=0;
        for(int i=0;i<=n;i++)
        {
            count+=arr[i];
            arr[i]=count;
        }
        int[] freq = new int[n];
        for(int i=0;i<n;i++)
            freq[i] = arr[i];
        Arrays.sort(freq);
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=(long)freq[i]*nums[i];
        }
        return (int)(ans % 1000000007);
    }
}