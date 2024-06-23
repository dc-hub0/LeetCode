class Solution:
    def myAtoi(self, s):

        i, n = 0, len(s)
     
        while i < n and s[i] == ' ':
            i += 1

        if i == n:
            return 0
   
        sign = 1
        if s[i] == '+':
            i += 1
        elif s[i] == '-':
            sign = -1
            i += 1
   
        num = 0
        while i < n and s[i].isdigit():
            num = num * 10 + int(s[i])
            i += 1
        num *= sign
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        if num < INT_MIN:
            return INT_MIN
        if num > INT_MAX:
            return INT_MAX
        
        return num

# Examples
solution = Solution()
print(solution.myAtoi("42"))         
print(solution.myAtoi("   -42"))     
print(solution.myAtoi("1337c0d3"))   
print(solution.myAtoi("0-1"))         
print(solution.myAtoi("words and 987")) 
