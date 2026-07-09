class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();

        for(String s:strs)
        {
            String generated=solve(s);
            if(!map.containsKey(generated))
            {
                map.put(generated,new ArrayList<>());
            }
            map.get(generated).add(s);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public String solve(String str)
    {
        int[] alp=new int[26];

        for(char c:str.toCharArray())
        {
            alp[c-'a']++;
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<26;i++)
        {
            while(alp[i]>0)
            {
                s.append((char)('a'+i));
                alp[i]--;
            }
        }
        return s.toString();
    }
}