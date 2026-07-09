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
    public List<List<Long>> splitPainting(int[][] segments) 
    {
        ArrayList<pair>arr=new ArrayList<>();
        for(int []a:segments)
        {
            int from=a[0];
            int to=a[1];
            int val=a[2];

            arr.add(new pair(from,val));
            arr.add(new pair(to,(val*-1)));
        }
        Collections.sort(arr,(x,y)->{
            if(x.a==y.a)
                return x.b-y.b;
            return x.a-y.a;
        });

        List<List<Long>>result=new ArrayList<>();
        long curr=0;
        int prev=arr.get(0).a;
        for(pair p:arr)
        {
            int point=p.a;
            if(curr>0 && point!=prev)
            {
                List<Long> temp=new ArrayList<>();
                temp.add((long)prev);
                temp.add((long)point);
                temp.add(curr);
                result.add(temp);
            }
            curr+=p.b;
            prev=point;
        }
        return result;
    }
}