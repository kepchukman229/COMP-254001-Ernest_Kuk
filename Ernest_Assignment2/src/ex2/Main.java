package ex2;

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
