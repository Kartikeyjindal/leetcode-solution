class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case where dividend equals divisor
        if (dividend == divisor) {
            return 1;
        }

        // Determine the sign of the result
        boolean sign = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = false;
        }

        // Use long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        // Perform division using bitwise shifts
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << cnt)) {
                cnt++;
            }

            quotient += 1L << (cnt - 1);
            n -= d << (cnt - 1);
        }

        // Handle overflow cases
        if (quotient >= (1L << 31)) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Return the result with the correct sign
        return sign ? (int) quotient : -(int) quotient;
    }
}