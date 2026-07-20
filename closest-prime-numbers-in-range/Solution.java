class Solution 
{
    // Step 1: Define a function to check if a number is prime.
    public boolean isPrime(int n) 
    {
        if (n <= 1) 
        {
            return false; 
        }

        if (n == 2 || n == 3) 
        {
            return true; 
        }

        if (n % 2 == 0) 
        {
            return false; 
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0) 
            {
                return false; 
            }
        }

        return true; 
    }

    // Step 2: Define the function to find the closest pair of primes in the range [left, right].
    public int[] closestPrimes(int left, int right) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Step 2a: Collect all primes in the range [left, right].
        while(left <= right) 
        {
            if(isPrime(left)) 
            {
                list.add(left);
            }
            left++;
        }

        // Step 2b: If fewer than two primes are found, return [-1, -1].
        if(list.size() < 2) 
        {
            return new int[]{-1, -1};
        }

        int minIdx = 0;
        int minPair = Integer.MAX_VALUE;

        // Step 2c: Find the pair of primes with the smallest difference.
        for(int i = 1; i < list.size(); i++) 
        {
            int diff = list.get(i) - list.get(i - 1); 
            // Step 2d: If the difference is smaller than the current minimum difference, update.
            if(diff < minPair) 
            { 
                minPair = diff;
                minIdx = i - 1;
            }
        }

        return new int[]{list.get(minIdx), list.get(minIdx + 1)};
    }
}