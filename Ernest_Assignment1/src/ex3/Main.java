package ex3;

public class Main {

    public static class CircularlyLinkedList<E> {

        private static class Node<E> {

            private E element;
            private Node<E> next;
            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() { return element; }
            public Node<E> getNext() { return next; }
            public void setNext(Node<E> n) { next = n; }
        }

        private Node<E> tail = null;
        private int size = 0;
        public CircularlyLinkedList() { }
        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        public E first() {             // returns (but does not remove) the first element
            if (isEmpty()) return null;
            return tail.getNext().getElement();         // the head is *after* the tail
        }

        public E last() {              // returns (but does not remove) the last element
            if (isEmpty()) return null;
            return tail.getElement();
        }

        public void rotate() {         // rotate the first element to the back of the list
            if (tail != null)                // if empty, do nothing
                tail = tail.getNext();         // the old head becomes the new tail
        }

        public void addFirst(E e) {                // adds element e to the front of the list
            if (size == 0) {
                tail = new Node<>(e, null);
                tail.setNext(tail);                     // link to itself circularly
            } else {
                Node<E> newest = new Node<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public void addLast(E e) { // adds element e to the end of the list
            addFirst(e);             // insert new element at front of list
            tail = tail.getNext();   // now new element becomes the tail
        }

        public E removeFirst() {                   // removes and returns the first element
            if (isEmpty()) return null;              // nothing to remove
            Node<E> head = tail.getNext();
            if (head == tail) tail = null;           // must be the only node left
            else tail.setNext(head.getNext());       // removes "head" from the list
            size--;
            return head.getElement();
        }

        public String toString() {
            if (tail == null) return "()";
            StringBuilder sb = new StringBuilder("(");
            Node<E> walk = tail;
            do {
                walk = walk.getNext();
                sb.append(walk.getElement());
                if (walk != tail)
                    sb.append(", ");
            } while (walk != tail);
            sb.append(")");
            return sb.toString();
        }

        public CircularlyLinkedList<E> clone() {
            CircularlyLinkedList<E> clone = new CircularlyLinkedList<>();
            if (tail == null) return clone;

            Node<E> curr = tail.next;
            do {
                clone.addLast(curr.element);
                curr = curr.next;
            } while (curr != tail.next);

            return clone;
        }
    }

    //MAIN
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);

        System.out.print("Original list: " + list + "\n");

        CircularlyLinkedList<Integer> cloned = list.clone();
        System.out.print("Cloned list: " + cloned + "\n");
    }
}
