package ex2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        for (int j=0; j < n; j++) {
            double total = 0;            // begin computing x[0] + ... + x[j]
            for (int i=0; i <= j; i++)
                total += x[i];
            a[j] = total / (j+1);        // record the average
        }
        return a;
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        double total = 0;              // compute prefix sum as x[0] + x[1] + ...
        for (int j=0; j < n; j++) {
            total += x[j];               // update prefix sum to include x[j]
            a[j] = total / (j+1);        // compute average based on current sum
        }
        return a;
    }





    //I'll use .nanoTime() function  to measure the running time

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            double[] data = new double[n];
            for (int x = 0; x < n; x++) data[x] = Math.random();


            long start1 = System.nanoTime();
            prefixAverage1(data);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            prefixAverage2(data);
            long end2 = System.nanoTime();

            System.out.printf("n = %d, prefixAverage1: %.3f ms, prefixAverage2: %.3f ms%n",
                    n, (end1 - start1) / 1e6, (end2 - start2) / 1e6);
        }
    }
}






















/**
// ---- Algorithms -----------------------------------------
public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j = 0; j < n - 1; j++)
        for (int k = j + 1; k < n; k++)
            if (data[j] == data[k]) return false;
    return true;
}

public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);
    Arrays.sort(temp);
    for (int j = 0; j < n - 1; j++)
        if (temp[j] == temp[j + 1]) return false;
    return true;
}

// ---- Helpers --------------------------------------------
private static int[] randomArray(int n) {
    Random rand = new Random(42);
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = rand.nextInt();
    return a;
}

private static long measureMsUnique1(int[] data) {
    long start = System.nanoTime();
    unique1(data);
    return (System.nanoTime() - start) / 1_000_000;
}

private static long measureMsUnique2(int[] data) {
    long start = System.nanoTime();
    unique2(data);
    return (System.nanoTime() - start) / 1_000_000;
}

private static long median(long[] arr) {
    Arrays.sort(arr);
    return arr[arr.length / 2];
}

// ---- Experimental Analysis ------------------------------
private static long timeUnique1(int n, int repeats) {
    long[] times = new long[repeats];
    for (int r = 0; r < repeats; r++) {
        int[] data = randomArray(n);
        times[r] = measureMsUnique1(data);
    }
    return median(times);
}

private static long timeUnique2(int n, int repeats) {
    long[] times = new long[repeats];
    for (int r = 0; r < repeats; r++) {
        int[] data = randomArray(n);
        times[r] = measureMsUnique2(data);
    }
    return median(times);
}

public static void main(String[] args) {
    final long LIMIT_MS = 60_000; // 1 minute
    final int REPEATS = 3;

    // Sample small sizes to estimate runtime
    int sampleN1 = 20000;   // adjust if too fast or slow
    int sampleN2 = 50000;  // adjust if too fast or slow

    System.out.println("Testing unique1...");
    long t1 = timeUnique1(sampleN1, REPEATS);
    double c1 = (double) t1 / (sampleN1 * sampleN1);
    int estN1 = (int) Math.sqrt(LIMIT_MS / c1);
    System.out.printf("Sample n=%d took %d ms → estimated max n ≈ %d%n",
            sampleN1, t1, estN1);

    System.out.println("\nTesting unique2...");
    long t2 = timeUnique2(sampleN2, REPEATS);
    double log2 = Math.log(sampleN2) / Math.log(2);
    double c2 = (double) t2 / (sampleN2 * log2);
    // approximate solution for n log n = LIMIT/c
    int estN2 = (int) (LIMIT_MS / (c2 * Math.log(LIMIT_MS) / Math.log(2)));
    System.out.printf("Sample n=%d took %d ms → estimated max n ≈ %d%n",
            sampleN2, t2, estN2);
} */