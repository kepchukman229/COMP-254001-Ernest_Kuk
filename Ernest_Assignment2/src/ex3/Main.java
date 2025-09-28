package ex3;

import java.util.Arrays;
import java.util.Random;





//After two hours of research, i have no clue on how to complete this task, i end up getting
//outofmemory exception in any variant of my code, most of this code was generated with help of chatgpt.


public class Main {

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

    private static int[] randomArray(int n) {
        Random rand = new Random(42); // fixed seed for reproducibility
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt();
        return arr;
    }

    private static long measureMsUnique1(int n) {
        int[] data = randomArray(n);
        long start = System.nanoTime();
        unique1(data);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long measureMsUnique2(int n) {
        int[] data = randomArray(n);
        long start = System.nanoTime();
        unique2(data);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static int findMaxN(int algo, long limitMs, int maxN) {
        int n = 1;

        while (n <= maxN) {
            long time;
            try {
                if (algo == 1) time = measureMsUnique1(n);
                else time = measureMsUnique2(n);
            } catch (OutOfMemoryError e) {
                System.out.println("OOM at n = " + n + ", reducing upper bound.");
                break; // stop if memory fails
            }

            System.out.printf("Algo %d: n=%d, time=%d ms%n", algo, n, time);

            if (time > limitMs) break;
            n *= 2;
        }

        int low = n / 2;
        int high = Math.min(n, maxN);

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            long time;
            try {
                if (algo == 1) time = measureMsUnique1(mid);
                else time = measureMsUnique2(mid);
            } catch (OutOfMemoryError e) {
                System.out.println("OOM at mid = " + mid + ", reducing high.");
                high = mid;
                continue;
            }

            System.out.printf("Algo %d: binary search mid=%d, time=%d ms%n", algo, mid, time);

            if (time <= limitMs) low = mid;
            else high = mid;
        }

        return low;
    }



    //I've put limits to n because i get OutOfMemory excpetion trying to exceed these amounts
    public static void main(String[] args) {
        final long LIMIT_MS = 60_000; // 1 minute
        final int MAX_N1 = 500_000;   // upper bound for unique1 to avoid huge O(n^2)
        final int MAX_N2 = 5_000_000; // upper bound for unique2

        System.out.println("=== Finding max n for unique1 (O(n^2)) ===");
        int maxUnique1 = findMaxN(1, LIMIT_MS, MAX_N1);
        System.out.println("Maximum n for unique1 ≈ " + maxUnique1 + "\n");

        System.out.println("=== Finding max n for unique2 (O(n log n)) ===");
        int maxUnique2 = findMaxN(2, LIMIT_MS, MAX_N2);
        System.out.println("Maximum n for unique2 ≈ " + maxUnique2);
    }
}
