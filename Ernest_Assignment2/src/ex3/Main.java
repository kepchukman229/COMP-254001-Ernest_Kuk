package ex3;

import java.util.Arrays;
import java.util.Random;





//After two hours of research, i have no clue on how to complete this task, i end up getting
//outofmemory exception in any variant of my code, most of this code was generated with help of chatgpt.


public class Main {

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
     Random rand = new Random();
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
     final int REPEATS = 10;

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
     }
}
