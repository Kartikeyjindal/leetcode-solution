class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> ans=new ArrayList<>();
        Map<String ,List<String>> map=new HashMap<>();

        for(String s:strs)
        {
            char []sort=s.toCharArray();
            Arrays.sort(sort);
            String sorted=new String(sort);
            if(!map.containsKey(sorted))
            {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            List<String> a=entry.getValue();
            ans.add(a);
        }
        return ans;
    }
}