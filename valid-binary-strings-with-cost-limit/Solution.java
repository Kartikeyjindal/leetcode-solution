class Solution 
{
    public List<String> generateValidStrings(int n, int k) 
    {
        List<String > ans=new ArrayList<>();

        char[]current=new char[n];
        dfs(0,0,current,ans,n,k);

        return ans;
    }

    public void dfs(int idx,int currcost,char[]current,List<String > ans,int n, int k)
    {
        if(idx==n)
        {
            ans.add(new String(current));
            return ;
        }

        current[idx]='0';
        dfs(idx+1,currcost,current,ans,n,k);

        boolean prev=(idx>0 && current[idx-1]=='1');
        boolean undercost=(currcost+idx<=k);

        if(!prev && undercost)
        {
            current[idx]='1';
            dfs(idx+1,currcost+idx,current,ans,n,k);
        }
    }
}