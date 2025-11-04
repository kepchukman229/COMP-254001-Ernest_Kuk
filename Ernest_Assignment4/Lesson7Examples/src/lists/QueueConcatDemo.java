package lists;

public class QueueConcatDemo {

	public static void main(String[] args) {
	    LinkedQueue<Integer> Q1 = new LinkedQueue<>();
	    LinkedQueue<Integer> Q2 = new LinkedQueue<>();

	    // Fill Q1 (front..rear): 1, 2, 3
	    Q1.enqueue(1);
	    Q1.enqueue(2);
	    Q1.enqueue(3);

	    // Fill Q2 (front..rear): 4, 5, 6
	    Q2.enqueue(4);
	    Q2.enqueue(5);
	    Q2.enqueue(6);

	    System.out.println("Before concatenate:");
	    System.out.println("Q1 = " + Q1); // delegates to SinglyLinkedList#toString()
	    System.out.println("Q2 = " + Q2);

	    // O(1) concat: Q1 <- Q2; Q2 becomes empty
	    Q1.concatenate(Q2);

	    System.out.println("\nAfter concatenate:");
	    System.out.println("Q1 = " + Q1); // (1, 2, 3, 4, 5, 6)
	    System.out.println("Q2 = " + Q2 + "  (should be empty)");

	    // quick sanity checks
	    System.out.println("\nDequeue Q1 (expect 1..6):");
	    while (!Q1.isEmpty()) System.out.print(Q1.dequeue() + " ");
	    System.out.println("\nQ2 is empty? " + Q2.isEmpty());
	  }
}
