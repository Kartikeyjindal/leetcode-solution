class Solution 
{
    public int maxValue(int[] nums1, int[] nums0) 
    {
        int n=nums1.length;
        int mod=(int)1e9+7;

        int[][]arr=new int[n][2];

        for(int i=0;i<n;i++)
            {
                arr[i][0]=nums1[i];
                arr[i][1]=nums0[i];
            }
        Arrays.sort(arr,(a,b)->{
                
            if(a[1]==0 && b[1]!=0) return -1;
            if(b[1]==0 && a[1]!=0) return 1;

            if(a[0]!=b[0])
            {
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });

        long result=0;
        for(int []a:arr)
            {
                int one=a[0];
                int zero=a[1];

                for(int i=0;i<one;i++)
                {
                    result=(result*2+1)%mod;        
                }
                for(int i=0;i<zero;i++)
                {
                    result=(result*2)%mod;            
                }
            }
        return (int)result;
    }
}