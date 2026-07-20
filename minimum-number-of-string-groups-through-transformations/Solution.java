class Solution 
{
    public int minimumGroups(String[] words) 
    {
        Set<String> set=new HashSet<>();

        for(String w:words)
            {
                StringBuilder e=new StringBuilder();
                StringBuilder o=new StringBuilder();

                for(int i=0;i<w.length();i++)
                    {
                        if(i%2==0)
                        {
                            e.append(w.charAt(i));
                        }
                        else
                        {
                            o.append(w.charAt(i));
                        }
                    }
                String mine=solve(e.toString());
                String mino=solve(o.toString());

                set.add(mine+"|"+mino);
            }
        return set.size();
    }

    public String solve(String s)
    {
        if(s==null || s.length()<=1)
        {
            return s;
        }
        int n=s.length();
        int i=0,j=1,k=0;

        while(i<n && j<n && k<n)
            {
                char a=s.charAt((i+k)%n);
                char b=s.charAt((j+k)%n);

                if(a==b)
                {
                    k++;
                }
                else if(a>b)
                {
                    i+=k+1;
                    if(i==j)
                    {
                        i++;
                    }
                    k=0;
                }
                else
                {
                    j+=k+1;
                    if(i==j)
                    {
                        j++;
                    }
                    k=0;
                }
            }
        int min=Math.min(i,j);
        return s.substring(min)+s.substring(0,min);
    }
}