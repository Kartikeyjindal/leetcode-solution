class Solution 
{
    public int chalkReplacer(int[] chalk, int k) 
    {
        double sum=0;
        for(int i=0;i<chalk.length;i++)
        {
            sum+=chalk[i];
        }

        double a=k%sum;
        int ans=0;
        while(a>=0)
        {
            if(a<chalk[ans])
            {
                break;
            }
            else
            {
                a=a-chalk[ans];
                ans++;
            }
        }
        return ans;
    }
}