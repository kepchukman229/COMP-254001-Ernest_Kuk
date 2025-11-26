package maps;

import java.util.Random;

public class Test {

  private static void runExperiment(String label,
                                    AbstractHashMap<Integer,Integer> map,
                                    int nInserts) {
    Random rand = new Random();

    long start = System.nanoTime();
    for (int i = 0; i < nInserts; i++) {
      int key = rand.nextInt(Integer.MAX_VALUE);
      map.put(key, i);
    }
    long end = System.nanoTime();

    double avgPutNs = (end - start) / (double) nInserts;
    System.out.printf("%s: size=%d, avg put time=%.1f ns%n",
                      label, map.size(), avgPutNs);
  }

  public static void main(String[] args) {
    int n = 50000;                     // number of insert operations
    double[] loads = {0.5, 0.75, 0.9};  // different load-factor limits

    System.out.println("=== ChainHashMap experiments ===");
    for (double lf : loads) {
      ChainHashMap<Integer,Integer> m =
          new ChainHashMap<>(17, 109345121, lf);
      runExperiment("ChainHashMap (lf=" + lf + ")", m, n);
    }
  }
}
