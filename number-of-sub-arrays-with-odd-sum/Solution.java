class Solution 
{
    public int numOfSubarrays(int[] arr) 
    {
        int ans = 0;
        int currentsum = 0;
        int oddCount = 0;
        int evenCount = 1; // Start with 1 to account for the empty subarray
        int MOD = 1_000_000_007; // Modulo value

        for (int num : arr) 
        {
            currentsum += num;

            if (currentsum % 2 == 0) 
            {
                ans = (ans + oddCount) % MOD; 
                evenCount++;
            } 
            else 
            {
                ans = (ans + evenCount) % MOD; 
                oddCount++;
            }
        }
        return ans;
    }
}
