#User function Template for python3

class Solution:
	def FirstNonRepeating(self, A):

		# Code here
	    dic = {}
	    lo = "abcdefghijklmnopqrstuvwxyz"
	    for a in lo:
	        dic[a] = True
	    
	    q = []
	    out = ""
	    
	    for a in A:
	        if a not in q and dic[a] == True:
	            q.append(a)
            else:
                if a in q:
                    q.remove(a)
                dic[a] = False
            if not q:
                out += "#"
            else:
                out += q[0]
        return out



#{ 
 # Driver Code Starts

#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		A = input()
		ob = Solution()
		ans = ob.FirstNonRepeating(A)
		print(ans)

# } Driver Code Ends