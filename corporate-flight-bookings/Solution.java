class Solution 
{
    public int[] corpFlightBookings(int[][] booking, int n) 
    {
        int []arr=new int[n];
        for(int []a:booking)
        {
            int start=a[0];
            int end=a[1];
            int val=a[2];

            arr[start-1]+=val;
            if(end<n)
            {
                arr[end]+=-val;
            }
        }
        int sum=0;
        int []ans=new int[n];
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            ans[i]=sum;
        }
        return ans;
    }
}