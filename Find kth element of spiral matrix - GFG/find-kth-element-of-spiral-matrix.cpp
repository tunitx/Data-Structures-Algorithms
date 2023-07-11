//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
#define MAX 1000

// } Driver Code Ends


class Solution
{
    public:
    /*You are required to complete this method*/
    int findK(int a[MAX][MAX],int n,int m,int target)
    {
        if (target>n*m) return -1;
        
        int rowStart = 0, colStart = 0;
        int rowEnd = n-1, colEnd = m-1;
        int sz = m*n;
        int count=0;
        
        //refer to arrows as directions of traversal
        
        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            for (int col = colStart; col<=colEnd; col++)    // -------->
            {
                count++;
                if (count==target) return a[rowStart][col];
            }
            
            for (int row = rowStart + 1; row<=rowEnd; row++)// |
            {                                               // |
                count++;                                    // |
                if (count==target) return a[row][colEnd];   // |
            }                                               // V
            
            for (int col = colEnd - 1; col>=colStart ; col--)// <--------- 
            {
                count++;
                if (count==target) return a[rowEnd][col];
            }

            for (int row = rowEnd - 1; row>rowStart; row--) // ^
            {                                               // |
                count++;                                    // |
                if (count==target) return a[row][colStart]; // |
            }                                               // |
            
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
        
        return 0;
    }
};


//{ Driver Code Starts.
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n,m;
        int k=0;
        //cin>>k;
        cin>>n>>m>>k;
        int a[MAX][MAX];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cin>>a[i][j];
            }
        }
        Solution ob;
        cout<<ob.findK(a,n,m,k)<<endl;
        
       
    }
}
// } Driver Code Ends