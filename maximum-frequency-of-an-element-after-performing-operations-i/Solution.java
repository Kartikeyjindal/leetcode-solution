class Solution 
{
    public int maxFrequency(int[] nums, int k, int no) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        
        int offset=Math.abs(nums[0]-k);
        int maxal=nums[n-1]+k+1+offset;

        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        int []arr=new int[maxal];

        for(int i=0;i<n;i++)
        {
            int l=nums[i]-k+offset;
            int r=nums[i]+k+offset;
            arr[l]+=1;
            if(r+1<maxal)
            arr[r+1]+=-1;
        }
        int cum=0;
        int ans=0;;
        for(int i=0;i<maxal;i++)
        {
            cum+=arr[i];
            int val=i-offset;
            int present=mp.getOrDefault(val,0);
            int possible=present+Math.min(cum-present,no);
            ans=Math.max(possible,ans);
        }
        return ans;
    }
}