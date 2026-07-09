class Solution 
{
    public String smallestEquivalentString(String s1, String s2, String base) 
    {
        ArrayList<ArrayList<Character>> adj=new ArrayList<>();
        int n=s1.length();
        
        for(int i=0;i<26;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            adj.get(s1.charAt(i)-'a').add(s2.charAt(i));
            adj.get(s2.charAt(i)-'a').add(s1.charAt(i));
        }
        
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<base.length();i++)
        {
            boolean []visited=new boolean[26];
            char minchar=dfs(base.charAt(i),visited,adj);
            ans.append(minchar);
        }
        return ans.toString();
    }

    public char dfs(char c,boolean []visited,ArrayList<ArrayList<Character>> adj)
    {
        visited[c-'a']=true;
        char min=c;
        for(char neighbor:adj.get(c-'a'))
        {
            if(!visited[neighbor-'a'])
            {
               char smallest= dfs(neighbor,visited,adj);
               if(smallest<min)
                {
                    min=smallest;
                }
            }
        }
        return min;
    }
}