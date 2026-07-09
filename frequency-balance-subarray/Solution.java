class Solution 
{
    public int getLength(int[] nums) 
    {
        int n=nums.length;
        int ans=1;

        for(int i=0;i<n;i++)
        {
            if(n-i<=ans)
            {
                break;
            }
            Map<Integer,Integer> fmap=new HashMap<>();
            Map<Integer,Integer> countmap=new HashMap<>();

            int max=0;
            for(int j=i;j<n;j++)
                {
                    int x=nums[j];
                    int f=fmap.getOrDefault(x,0);

                    fmap.put(x,f+1);

                    if(f>0)
                    {
                        if(countmap.get(f)==1)
                        {
                            countmap.remove(f);
                        }
                        else
                        {
                            countmap.put(f,countmap.get(f)-1);
                        }
                    }
                    countmap.put(f+1,countmap.getOrDefault(f+1,0)+1);

                    max=Math.max(max,f+1);

                    if(countmap.size()==1)
                    {
                        if(fmap.size()==1)
                        {
                            ans=Math.max(ans,j-i+1);
                        }
                    }
                    else if(countmap.size()==2 && max%2==0)
                    {
                        if(countmap.containsKey(max) && countmap.containsKey(max/2))
                        {
                            ans=Math.max(ans,j-i+1);
                        }
                    }
                }
            
        }
        return ans;
    }
}