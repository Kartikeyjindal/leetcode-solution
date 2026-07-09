class pair
{
    int a;
    int b;
    public pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution 
{
    public int[] sortByBits(int[] arr) 
    {
        int n=arr.length;
        ArrayList<pair> a=new ArrayList<>();
        for(int i:arr)
        {
            int noone=solve(i);
            a.add(new pair(i,noone));
        }
        Collections.sort(a,(x,y)->{
            if(x.b==y.b)
                return x.a-y.a;
            return x.b-y.b;
        });
        int []result=new int[n];
        for(int i=0;i<n;i++)
        {
            result[i]=a.get(i).a;
        }
        return result;
    }
    public int solve(int n)
    {
        int noone=0;
        while(n>0)
        {
            int digit=n&1;
            n=n>>1;
            if(digit==1)
            {
                noone++;
            }
        }
        return noone;
    }
}