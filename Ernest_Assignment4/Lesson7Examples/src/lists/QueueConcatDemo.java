package lists;

public class QueueConcatDemo {

	public static void main(String[] args) {
	    LinkedQueue<Integer> Q1 = new LinkedQueue<>();
	    LinkedQueue<Integer> Q2 = new LinkedQueue<>();

	    Q1.enqueue(1);
	    Q1.enqueue(2);
	    Q1.enqueue(3);

	    Q2.enqueue(4);
	    Q2.enqueue(5);
	    Q2.enqueue(6);

	    System.out.println("Before concatenate:");
	    System.out.println("Q1 = " + Q1);
	    System.out.println("Q2 = " + Q2);

	    Q1.concatenate(Q2);

	    System.out.println("\nAfter concatenate:");
	    System.out.println("Q1 = " + Q1);
	    System.out.println("Q2 = " + Q2);

	    System.out.println("\nQ2 is empty? " + Q2.isEmpty());
	  }
}
