//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int arr[], int n)
    {
	// Your code here
	int sum =0;
	int Si = 0;
	for(int i =0; i<arr.length; i++){
	    sum+=arr[i];
	    Si +=i*arr[i];
	}
	int max = Si;
	for(int i =0; i<arr.length-1; i++){
	    int SiPlus1 = Si + sum - n*arr[arr.length-1-i];
	    if(SiPlus1>max){
	        max = SiPlus1;
	    }
	    Si = SiPlus1;
	}
	return max;
    }	
}
