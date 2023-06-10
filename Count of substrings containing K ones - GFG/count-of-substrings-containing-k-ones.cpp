//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    public:
    
    long long solve(string s,int k){
        long long ans=0;
        int i=0;int j=0;
        int ones=0;
        while(j<s.size()){
            if(s[j]=='1') ones++;
            while(i<=j and ones>k){
                if(s[i]=='1') ones--;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
    long long int countOfSubstringWithKOnes(string S, int K){
        return solve(S,K)-solve(S,K-1);
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin >> t;
    while(t--){
       string s;
       int k;
       cin >> s >> k;
       Solution ob;
       cout << ob.countOfSubstringWithKOnes(s, k) << endl;
    }
return 0;
}


// } Driver Code Ends