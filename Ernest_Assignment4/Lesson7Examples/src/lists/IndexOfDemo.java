package lists;

import java.util.Stack;
import static lists.PositionalList.transfer;

public class IndexOfDemo {
	public static void main(String[] args) {
		
		
		//Exercise 1
		PositionalList<String> list = new LinkedPositionalList<>();

        // Add elements
        Position<String> p1 = list.addLast("A");
        Position<String> p2 = list.addLast("B");
        Position<String> p3 = list.addLast("C");
        Position<String> p4 = list.addLast("D");

        System.out.println("Exercise 1:");
        System.out.println("List: " + list);

        System.out.println("Index of A: " + list.indexOf(p1));
        System.out.println("Index of B: " + list.indexOf(p2));
        System.out.println("Index of C: " + list.indexOf(p3));
        System.out.println("Index of D: " + list.indexOf(p4));

        //invalid
        PositionalList<String> other = new LinkedPositionalList<>();
        Position<String> external = other.addLast("Z");
        System.out.println("Index of Z: " + list.indexOf(external));
    
	
	
	
	
	
        //Exercise 2
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();
        for (int i = 1; i <= 4; i++) {S.push(i);}
        
        T.push(100);
        System.out.println("\n\n\n\n\nExercise 2:");
        System.out.println("Before transfer:");
        System.out.println("S = " + S); 
        System.out.println("T = " + T); 
        
        transfer(S, T);
        System.out.println("\nAfter transfer:");
        System.out.println("S = " + S);
        System.out.println("T = " + T);
	}
}
