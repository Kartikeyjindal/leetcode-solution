class pair
{
    int a,b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class MyCalendarThree 
{
    ArrayList<pair> arr;
    public MyCalendarThree() 
    {
        arr=new ArrayList<>();
    }
    
    public int book(int starttime, int endtime) 
    {
        int curr=0;
        int max=0;
        arr.add(new pair(starttime,+1));
        arr.add(new pair(endtime,-1));
        Collections.sort(arr,(x,y)->{
        if(x.a==y.a)
            return x.b-y.b;
        return x.a-y.a;
        });
        for(pair p:arr)
        {
            int st=p.a;
            int count=p.b;
            curr+=count;
            if(curr>max)
            {
                max=curr;
            }

        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */