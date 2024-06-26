public class Solution {
    public int divide(int dividend, int divisor) {
     
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
       
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        
        long left = 0;
        long right = absDividend;
        long quotient = 0;
     
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * absDivisor == absDividend) {
                quotient = mid;
                break;
            } else if (mid * absDivisor < absDividend) {
                quotient = mid; 
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        
        
        if (isNegative) {
            quotient = -quotient;
        }
        
  
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)quotient;
        }
    }
}
