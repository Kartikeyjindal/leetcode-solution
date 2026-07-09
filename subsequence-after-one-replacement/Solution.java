class Solution 
{
    public boolean canMakeSubsequence(String s, String t) 
    {
        int n=s.length();
        int m=t.length();

        if(n>m)
        {
            return false;
        }

        int[] l=new int[n];
        int j=0;
        for(int i=0;i<n;i++)
        {
            while(j<m && t.charAt(j)!=s.charAt(i))
            {
                j++;
            } 
            l[i]=j;
            if(j<m)
            {
                j++;
            }
        }
        if(l[n-1]<m)
        {
            return true;
        }

        int []r=new int[n];
        j=m-1;
        for(int i=n-1;i>=0;i--)
        {
            while(j>=0 && t.charAt(j)!= s.charAt(i))
                {
                    j--;
                }
            r[i]=j;
            if(j>=0)
            {
                j--;
            }
        }
        if(n==1)
        {
            return true;
        }
        if(r[1]>=1)
        {
            return true;
        }
        if(l[n-2]<=m-2)
        {
            return true;
        }
        for(int i=1;i<n-1;i++)
            {
                if(l[i-1]<m && r[i+1]>=0 && l[i-1]<r[i+1]-1)
                {
                    return true;
                }
            }
        return false;
    }
}