class Solution 
{
    public int numSubmatrixSumTarget(int[][] matrix, int target) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        
        // cumm sum  of row
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]+=matrix[i-1][j];
            }
        }

        int ans=0;
        //just as 560 but col wise
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);
                int sum=0;
                for(int k=0;k<m;k++)
                {
                    if(i==0)
                    {
                        sum+=matrix[j][k];
                    }
                    else
                    {
                        sum+=matrix[j][k]-matrix[i-1][k];
                    }
                    if(map.containsKey(sum-target))
                    {
                        ans+=map.get(sum-target);
                    }
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return ans;

    }
}