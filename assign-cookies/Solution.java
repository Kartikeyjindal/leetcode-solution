class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int greedy=0;
        int cookies=0;
        int count=0;
        while(greedy<g.length && cookies<s.length)
        {
            if(g[greedy] <= s[cookies])
            {
                greedy++;
            }
            cookies++;
        }
        return greedy;
    }
}