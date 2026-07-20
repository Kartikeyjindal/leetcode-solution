class Solution 
{
    public boolean[] transformStr(String s, String[] strs) 
    {
        int n=s.length();
        int m=strs.length;
        boolean[]ans=new boolean[m];

        int[]prefs=new int[n+1];
        for(int i=0;i<n;i++)
            {
                prefs[i+1]=prefs[i]+(s.charAt(i)=='0'?1:0);
            }
        int totalzero=prefs[n];

        for(int i=0;i<m;i++)
            {
                String str=strs[i];
                int currzero=0;
                int question=0;

                for(int j=0;j<n;j++)
                    {
                        if(str.charAt(j)=='0')
                        {
                            currzero++;
                        }
                        else if(str.charAt(j)=='?')
                        {
                            question++;
                        }
                    }
                int need=totalzero-currzero;

                if(need<0 || need>question)
                {
                    ans[i]= false;
                    continue;
                }
                int runningzero=0;
                boolean isvalid=true;

                for(int j=0;j<n;j++)
                    {
                        char c=str.charAt(j);
                        if(c=='0')
                        {
                            runningzero++;
                        }
                        else if(c=='?')
                        {
                            if(need>0)
                            {
                                runningzero++;
                                need--;
                            }
                        }
                        if(runningzero<prefs[j+1])
                        {
                            isvalid=false;
                            break;
                        }
                    }
                ans[i]=isvalid;
                
            }
        return ans;
    }
}