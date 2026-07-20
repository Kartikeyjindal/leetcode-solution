class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int max=0;
       for(int i:piles)
       {
            max=Math.max(max,i);
       }

       int low=1;int high=max;
       while(low<high)
       {
            int mid=(low+high)/2;
            int reqtime=time(piles,mid);

            if(reqtime<=h)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
       }
       return low;
    }

    public int time(int []piles,int a)
    {
        int total=0;
        for(int i:piles)
        {
            total+=(int)Math.ceil((double)i/a);
        }
        return total;
    }
}