class Solution 
{
    public List<String> buildArray(int[] target, int n) 
    {
        List<String> ans=new ArrayList<>();
        int k=0;
        int i=1;
        while(i<=n && k<target.length)
        {
            if(target[k]==i)
            {
                ans.add("Push");
                k++;
            }
            else
            {
                ans.add("Push");
                ans.add("Pop");
            }
            i++;
        }
        return ans;
    }
}