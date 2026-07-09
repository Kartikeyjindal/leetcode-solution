class Solution 
{
    public int minLights(int[] lights) 
    {
        int n=lights.length;

        int []diff=new int[n+1];

        for(int i=0;i<n;i++)
        {
            int v=lights[i];
            if(v>0)
            {
                int left=Math.max(0,i-v);
                int right=Math.min(n-1,i+v);

                diff[left]++;
                diff[right+1]--;
            }
        }
        boolean []illuminated=new boolean[n];
        int curr=0;

        for(int i=0;i<n;i++)
        {
            curr+=diff[i];
            if(curr>0)
            {
                illuminated[i]=true;
            }
        }
        int ans=0;
        int i=0;

        while(i<n)
        {
            if(!illuminated[i])
            {
                ans++;
                i+=3;
            }
            else
            {
                i++;
            }
        }
        return ans;
    }
}