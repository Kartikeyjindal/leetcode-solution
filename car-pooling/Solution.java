class pair
{
    int a;int b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution 
{
    public boolean carPooling(int[][] trips, int capacity) 
    {
        ArrayList<pair>arr=new ArrayList<>();
        for(int []a:trips)
        {
            int cap=a[0];
            int to=a[1];
            int from=a[2];
            arr.add(new pair(to,cap));
            arr.add(new pair(from,(cap*-1)));
        }
        Collections.sort(arr,(x,y)->{
                if(x.a==y.a)
                    return x.b-y.b;
                return x.a-y.a;
            });
            int total=0;
        for(pair p:arr)
        {
            int loc=p.a;
            int cap=p.b;

            total+=cap;
            if(total>capacity)
            {
                return false;
            }
        }
        return true;
    }
}