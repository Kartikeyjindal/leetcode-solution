class Solution 
{
    public String findDifferentBinaryString(String[] nums) 
    {
        HashSet<String> set=new HashSet<>();
        int n=nums.length;

        for(String s:nums)
        {
            set.add(s);
        }
        return solve(set,"",n);
    }
    public String solve(HashSet <String> set,String curr,int n)
    {
        if(curr.length()==n)
        {
            if(!set.contains(curr))
            {
                return curr;
            }
            return null;
        }
        String left=solve(set,curr+"0",n);
        if(left!=null)
        {
            return left;
        }
        String right=solve(set,curr+"1",n);
        return right;
    }
}