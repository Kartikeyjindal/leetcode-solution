class Solution 
{
    public String shiftingLetters(String s, int[][] shifts) 
    {
        int n=s.length();
        int []arr=new int[n];
        
        for(int[]st:shifts)
        {
            int l=st[0];
            int r=st[1];
            int d=st[2];

            if(d==0)
            {
                arr[l]+=-1;
                if(r+1<n)
                {
                    arr[r+1]+=1;
                }
            }
            else
            {
                arr[l]+=1;
                if(r+1<n)
                {
                    arr[r+1]-=1;
                }
            }
        }
        StringBuilder sb=new StringBuilder(s);
        int cum=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            cum+=arr[i];
            int shift=(cum%26+26)%26;
            int original=s.charAt(i)-'a';

            int newposition=(original+shift)%26;

            sb.setCharAt(i,(char)('a'+newposition));
            
        }
        return sb.toString();
    }
}