class Solution:
    def reverse(self, x):
    
        sign = -1 if x < 0 else 1
        x *= sign 
 
        reversed_x = 0
        while x != 0:
            digit = x % 10
            x //= 10
            reversed_x = reversed_x * 10 + digit
        reversed_x *= sign
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        
     
        if reversed_x < INT_MIN or reversed_x > INT_MAX:
            return 0
        else:
            return reversed_x

# Examples
solution = Solution()
print(solution.reverse(123))  
print(solution.reverse(-123))  
print(solution.reverse(120))   
