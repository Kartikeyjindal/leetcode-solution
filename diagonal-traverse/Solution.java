class Solution 
{
    public int[] findDiagonalOrder(int[][] mat) 
    {
        int m=mat.length;
        int n=mat[0].length;
        int []ans=new int[n*m];
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=mat[i][j];
                int pos=i+j;

                if(!map.containsKey(pos))
                {
                    map.put(pos,new ArrayList<>());
                }
                map.get(pos).add(val);
            }
        }
        int k=0;
        for(int pos=0;pos<=m+n-2;pos++)
        {
            List<Integer> curr=map.get(pos);
            if(pos%2!=0)
            {
                for(int i=0;i<curr.size();i++)
                {
                    ans[k]=curr.get(i);
                    k++;
                }
            }
            else
            {
                for(int i=curr.size()-1;i>=0;i--)
                {
                    ans[k]=curr.get(i);
                    k++;
                }
            }
        }
        return ans;
    }
}