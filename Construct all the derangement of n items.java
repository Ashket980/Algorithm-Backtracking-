import java.util.*;
 
public class _Q2_2
{
 
    public static void main(String[] args)
    {
        System.out.println("derangements for n = 4\n");
        for (Object d  : (ArrayList)(construct_candidate(4, false)[0])) 
        {
            System.out.println(Arrays.toString((int[])d));
        }
 
       
    }
 
    static Object[] construct_candidate(int n, boolean countOnly) 
    {
        int[] seq = iota(n);
        int[] ori = Arrays.copyOf(seq, n);
        long tot = fact(n);
 
        List<int[]> all = new ArrayList<int[]>();
        int cnt = n == 0 ? 1 : 0;
 
        while (--tot > 0) 
        {
            int j = n - 2;
            while (seq[j] > seq[j + 1])
            {
                j--;
            }
            int k = n - 1;
            while (seq[j] > seq[k])
            {
                k--;
            }
            swap(seq, k, j);
 
            int r = n - 1;
            int s = j + 1;
            while (r > s) 
            {
                swap(seq, s, r);
                r--;
                s++;
            }
 
            j = 0;
            while (j < n && seq[j] != ori[j])
            {
                j++;
            }
            if (j == n)
            {
                if (countOnly) 
                {
                    cnt++;
                }
                else 
                {
                    all.add(Arrays.copyOf(seq, n));
                }
            }
        }
        return new Object[]{all, cnt};
    }
 
    static long fact(long n) 
    {
        long result = 1;
        for (long i = 2; i <= n; i++) 
        {
            result *= i;
        }
        return result;
    }
 
    static void swap(int[] arr, int lhs, int rhs) 
    {
        int tmp = arr[lhs];
        arr[lhs] = arr[rhs];
        arr[rhs] = tmp;
    }
 
    static int[] iota(int n) 
    {
        if (n < 0) 
        {
            throw new IllegalArgumentException("iota cannot accept < 0");
        }
        int[] r = new int[n];
        for (int i = 0; i < n; i++) 
        {
            r[i] = i;
        }
        return r;
    }
}
