//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int distributeTicket(int N, int K) {
        // code here
        if (N == 1)
            return 1;
        
        int low = 0, high = N-1;
        
        while (low < high) {
            for (int i=0; i<K; i++) {
                low++;
                if (low >= high) {
                    return low + 1;
                }
            }
            for (int i=0; i<K; i++) {
                high--;
                if (high <= low) {
                    return high + 1;
                }
            }
        }
        
        return -1;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        int N;
        scanf("%d",&N);
        
        
        int K;
        scanf("%d",&K);
        
        Solution obj;
        int res = obj.distributeTicket(N, K);
        
        cout<<res<<endl;
        
    }
}

// } Driver Code Ends