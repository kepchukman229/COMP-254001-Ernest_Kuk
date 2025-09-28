package ex1;

public class Main {

    /**
     * Returns the sum of the integers in given array.
     * running time: O(n)
     * the loop visits every element in the array once
     */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)       // loop runs n times
            total += arr[j];
        return total;
    }

    /**
     * Returns the sum of the integers with even index in given array.
     * running time: O(n)
     * the loop still runs about n/2 times, which simplifies to O(n)
     */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    // note the increment of 2
            total += arr[j];
        return total;
    }

    /**
     * Returns the sum of the prefix sums of the given array.
     * running time: O(n^2)
     * outer loop runs n times, inner loop runs j times.
     * total operations = 1 + 2 + ... + n = O(n^2).
     */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];
        return total;
    }

    /**
     * Returns the sum of the prefix sums of given array.
     * running time: O(n)
     * the loop runs n times, each iteration just does a few additions,
     * no nested loops. So total cost grows linearly with n.
     */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     // loop runs n times
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /**
     * Returns the number of times second array stores sum of prefix sums from first.
     * running time: O(n^3)
     * three nested loops
     */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) {     // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1
                for (int k=0; k <= j; k++)  // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }
}
