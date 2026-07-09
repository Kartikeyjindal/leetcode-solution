class Solution 
{
    public String sortVowels(String s) 
    {
        int n=s.length();
        int[]freq=new int[256];
        int []pos=new int[256];
        Arrays.fill(pos,-1);
        String v="aeiou";

        for(int i=0;i<n;i++)
            {
                char ch=s.charAt(i);
                freq[ch]++;
                if(pos[ch]==-1)
                {
                    pos[ch]=i;
                }
            }
        List<Character> vol=new ArrayList<>();
        for(int i=0;i<n;i++)
            {
                char ch=s.charAt(i);
                if(v.indexOf(ch)!=-1)
                {
                    vol.add(ch);
                }
            }
        Collections.sort(vol,(a,b)->{
            if(freq[a]!=freq[b])
            {
                return freq[b]-freq[a];
            }
            return pos[a]-pos[b];
        });

        StringBuilder sb=new StringBuilder();
        int idx=0;

        for(int i=0;i<n;i++)
            {
                char ch=s.charAt(i);
                if(v.indexOf(ch)!=-1)
                {
                    sb.append(vol.get(idx++));
                }
                else
                {
                    sb.append(ch);
                }
            }
        return sb.toString();
    }
}