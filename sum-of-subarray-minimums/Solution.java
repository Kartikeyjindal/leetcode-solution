class Solution 
{
    public int sumSubarrayMins(int[] arr) 
    {
        int n=arr.length;
        int []nsr=new int[n];
        int []nsl=new int[n];
        
        nsr=solve1(arr);
        nsl=solve2(arr);
        long sum=0;
        int mod=(int)1e9+7;

        for(int i=0;i<n;i++)
        {
            long ls= i-nsl[i];
            long rs= nsr[i]-i;

            long times=ls*rs;
            long multiply=arr[i]*times;

            sum=(sum+multiply)%mod;
        }
        return (int)sum;
    }

    public int[] solve1(int []arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int []ans=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=n;
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int [] solve2(int []arr)
    {
        Stack<Integer> st=new Stack<>();

        int n=arr.length;
        int []ans=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}