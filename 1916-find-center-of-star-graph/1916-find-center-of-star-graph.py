class Solution:
    def findCenter(self, edges):
 
        u1, v1 = edges[0]
        u2, v2 = edges[1]
 
        if u1 == u2 or u1 == v2:
            return u1
        else:
            return v1

solution = Solution()
print(solution.findCenter([[1, 2], [2, 3], [4, 2]])) 
print(solution.findCenter([[1, 2], [5, 1], [1, 3], [1, 4]]))
