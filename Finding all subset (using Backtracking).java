public class SUBSET 
{
	// Display subset value
	public void display(int[] result, int n)
	{
		for (int i = 0; i < n; ++i) 
		{
			System.out.print("  " + result[i]);
		}
		System.out.print("\n");
	}

	// Find subset elements
	public void allSubset(int[] arr, int[] result, int i, int j, int n) 
	{
		if (i == n) 
		{
			display(result, j);
			return;
		}
		// Get element
		result[j] = arr[i];
		// Through by recursion find next subset
		allSubset(arr, result, i + 1, j + 1, n);
		allSubset(arr, result, i + 1, j, n);
	}

	// Handles the request to find all subsets
	public void findSubsets(int[] arr, int n)
	{
		if (n <= 0) 
		{
			return;
		}
		// Used to collect subset element
		int[] result = new int[n];
		allSubset(arr, result, 0, 0, n);
	}

	public static void main(String[] args) 
	{
		SUBSET task = new SUBSET();
		int[] arr = { 1, 2, 3, 4 };
		// Get the size
		int n = arr.length;
		task.findSubsets(arr, n);
	}
}


//Output -
//1  2  3  4
//1  2  3
//1  2  4
//1  2
//1  3  4
//1  3
//1  4
//1
//2  3  4
//2  3
//2  4
//2
//3  4
//3
//4
