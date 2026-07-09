class Solution 
{
    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);

        int l=1;
        int h=position[position.length-1]-position[0];
        int ans=0;

        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(canfit(position,mid,m))
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return ans;
    }

    public boolean canfit(int []position,int mid,int m)
    {
        int count=1;
        int lpos=position[0];

        for(int i=1;i<position.length;i++)
        {
            if(position[i]-lpos>=mid)
            {
                count++;
                lpos=position[i];
                if(count>=m)
                {
                    return true;
                }
            }
        }
        return false;
    }
}