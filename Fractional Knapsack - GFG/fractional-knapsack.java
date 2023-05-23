//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        ArrayList<pair> list = new ArrayList<>();
        for(int i =0; i<n; i++){
            list.add(new pair(arr[i].value, arr[i].weight));
        }
        int initial_cap = W;
        double res =0;
        Collections.sort(list, (a,b)-> 
        a.w*b.v -a.v*b.w);
        for(int i =0; i<n; i++){
            if(list.get(i).w<=initial_cap){
                res +=list.get(i).v;
                initial_cap-=list.get(i).w;
            }
            else{
                res+= (list.get(i).v)*((double)initial_cap/(double)list.get(i).w);
                return res;
            }
        }
        return res;
    }
}
class pair{
    int v, w;
    pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}