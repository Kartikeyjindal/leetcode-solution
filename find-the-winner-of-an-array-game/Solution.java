class Solution 
{
    public int getWinner(int[] arr, int k) 
    {
        int curr=arr[0];
        int win=0;

        if(k<arr.length)
        {
            for(int i=1;i<arr.length;i++)
            {
                if(curr>arr[i])
                {
                    win++;
                }
                else
                {
                    curr=arr[i];
                    win=1;
                }
                if(win==k)
                {
                    return curr;
                }
            }
        }
        else
        {
            int max=0;
            for(int i=0;i<arr.length;i++)
            {
                max=Math.max(max,arr[i]);
            }
            return max;
        }
        return curr;
    }
}