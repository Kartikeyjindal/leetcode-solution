class Solution 
{
    public int maximizeSquareHoleArea(int n, int m, int[] hbar, int[] vbar) 
    {
        Arrays.sort(hbar);
        Arrays.sort(vbar);

        int maxconhbar=1;
        int maxconvbar=1;

        int convbar=1;
        for(int i=1;i<hbar.length;i++)
        {
            if(hbar[i]-hbar[i-1]==1)
            {
                convbar++;
            }
            else
            {
                convbar=1;
            }
            maxconhbar=Math.max(maxconhbar,convbar);
        }

        convbar=1;
        for(int i=1;i<vbar.length;i++)
        {
            if(vbar[i]-vbar[i-1]==1)
            {
                convbar++;
            }
            else
            {
                convbar=1;
            }
            maxconvbar=Math.max(maxconvbar,convbar);
        }

        int side=Math.min(maxconhbar,maxconvbar)+1;
        return side*side;
    }
}