class Solution 
{
    public long minNumberOfSeconds(int mountainHeight, int[] works) 
    {
        int n=works.length;
        long[] vec=new long[n];
        int ht=mountainHeight;

        PriorityQueue<long []> pq=new PriorityQueue<>(
            (a,b)->Long.compare(a[0],b[0])
        );

        for(int i=0;i<n;i++)
        {
            pq.add(new long[]{works[i],i,1});
        }

        while(ht>0)
        {
            long[]top=pq.poll();
            long val=top[0];
            int idx=(int)top[1];
            long mul=top[2];

            ht--;

            vec[idx]=val;
            mul++;
            val+=(long)works[idx]*mul;

            pq.add(new long[]{val,idx,mul});
        }
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,vec[i]);
        }
        return ans;   
    }
}