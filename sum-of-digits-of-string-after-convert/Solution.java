class Solution 
{
    public int getLucky(String s, int k) 
    {
        int n=s.length();
        int sum=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sb.append(((int)(s.charAt(i))-96));
        }
        for(int i=0;i<sb.length();i++)
        {
            sum+=((sb.charAt(i))-'0');
        }
        k--;
        while(k!=0)
        {
            int num=sum;
            sum=0;
            while(num!=0)
            {
                int a=num%10;
                num=num/10;
                sum=sum+a;
            }
            k--;
        }

        return sum;
    }
}