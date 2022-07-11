import java.util.ArrayList;
import java.util.Arrays;
 
public class permutation
{
    static void swap(int nums[], int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }
 
    // permutations
    static void permutations(ArrayList<int[]> res,
                             int[] nums, int l, int h)
    {
        // Base case
        if (l == h) {
            res.add(Arrays.copyOf(nums, nums.length));
            return;
        }
 
        for (int i = l; i <= h; i++) {
  
            swap(nums, l, i);
 
            permutations(res, nums, l + 1, h);
 
            // Backtracking
            swap(nums, l, i);
        }
    }
 
    static ArrayList<int[]> permute(int[] nums)
    {
        ArrayList<int[]> res = new ArrayList<int[]>();
        int x = nums.length - 1;
 
        permutations(res, nums, 0, x);
        return res;
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 3,6,7,9 };
        ArrayList<int[]> res = permute(nums);
 
        for (int[] x : res) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

//Output-
//3 6 7 9 
//3 6 9 7 
//3 7 6 9 
//3 7 9 6 
//3 9 7 6 
//3 9 6 7 
//6 3 7 9 
//6 3 9 7 
//6 7 3 9 
//6 7 9 3 
//6 9 7 3 
//6 9 3 7 
//7 6 3 9 
//7 6 9 3 
//7 3 6 9 
//7 3 9 6 
//7 9 3 6 
//7 9 6 3 
//9 6 7 3 
//9 6 3 7 
//9 7 6 3 
//9 7 3 6 
//9 3 7 6 
//9 3 6 7 
