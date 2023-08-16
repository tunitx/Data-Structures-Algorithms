
from math import factorial
class Solution:
    def findCatalan(self, n: int) -> int:
        mod = 10**9 + 7
        numerator=factorial(2*n)
        denominator=factorial(n+1)*factorial(n)
        return (numerator//denominator)%mod



#{ 
 # Driver Code Starts
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        obj = Solution()
        res = obj.findCatalan(n)
        
        print(res)
        

# } Driver Code Ends