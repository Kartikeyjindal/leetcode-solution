class pair
{
    int a,b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class MyCalendarTwo 
{
    ArrayList<pair>arr;

    public MyCalendarTwo() 
    {
        arr=new ArrayList<>();
    }
    
    public boolean book(int starttime, int endtime) 
    {
        pair p1=new pair(starttime,+1);
        pair p2=new pair(endtime,-1);
        arr.add(p1);
        arr.add(p2);

        Collections.sort(arr,(x,y)->{
            if(x.a == y.a) 
                return x.b-y.b;
            return x.a-y.a;
            });

        int curr=0;
        for(pair p:arr)
        {
            int time=p.a;
            int a=p.b;

            curr+=a;
            if(curr>=3)
            {
                arr.remove(p1);
                arr.remove(p2);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */