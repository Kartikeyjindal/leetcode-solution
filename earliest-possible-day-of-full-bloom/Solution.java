class Solution 
{
    public int earliestFullBloom(int[] plantTime, int[] growTime) 
    {
        int n=plantTime.length;
        Pair[] flowertime=new Pair[n];
        for(int i=0;i<n;i++)
        {
            flowertime[i]=new Pair(plantTime[i],growTime[i]);
        }
        Arrays.sort(flowertime,(a,b)->b.growTime-a.growTime);
        int plantingdays=0;
        int totaldays=0;

        for(Pair current:flowertime)
        {
            totaldays=Math.max(totaldays,plantingdays+current.plantTime+current.growTime);
            plantingdays+=current.plantTime;
        }
        return totaldays;
    }

    class Pair
    {
        public int plantTime;
        public int growTime;

        Pair(int plantTime,int growTime)
        {
            this.plantTime=plantTime;
            this.growTime=growTime;
        }
    }
}