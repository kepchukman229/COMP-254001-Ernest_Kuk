package ex2;

public class Main {

    public static class SinglyLinkedList<E> implements Cloneable {

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

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
        public SinglyLinkedList() { }
        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        public E first() {             // returns (but does not remove) the first element
            if (isEmpty()) return null;
            return head.getElement();
        }

        public E last() {              // returns (but does not remove) the last element
            if (isEmpty()) return null;
            return tail.getElement();
        }

        public void addFirst(E e) {                // adds element e to the front of the list
            head = new Node<>(e, head);              // create and link a new node
            if (size == 0)
                tail = head;                           // special case: new node becomes tail also
            size++;
        }

        public void addLast(E e) {                 // adds element e to the end of the list
            Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
            if (isEmpty())
                head = newest;                         // special case: previously empty list
            else
                tail.setNext(newest);                  // new node after existing tail
            tail = newest;                           // new node becomes the tail
            size++;
        }

        public E removeFirst() {                   // removes and returns the first element
            if (isEmpty()) return null;              // nothing to remove
            E answer = head.getElement();
            head = head.getNext();                   // will become null if list had only one node
            size--;
            if (size == 0)
                tail = null;                           // special case as list is now empty
            return answer;
        }

        public Node<E> getNode(E value) {
            Node<E> curr = head;
            while (curr != null) {
                if (curr.element.equals(value)) return curr;
                curr = curr.next;
            }
            return null;
        }


        public void swapNodes(Node<E> node1, Node<E> node2) {
            if (node1 == node2) return;

            Node<E> prev1 = null, prev2 = null, curr = head;

            while (curr != null && (prev1 == null || prev2 == null)) {
                if (curr.next == node1) prev1 = curr;
                if (curr.next == node2) prev2 = curr;
                curr = curr.next;
            }

            if (node1 == head) {
                head = node2;
            } else if (node2 == head) {
                head = node1;
            }

            if (prev1 != null) prev1.next = node2;
            if (prev2 != null) prev2.next = node1;

            Node<E> temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;

            if (node1.next == null) tail = node1;
            if (node2.next == null) tail = node2;
        }
    }
    //MAIN

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.print("Original list: " + list + "\n");

        SinglyLinkedList.Node<Integer> node1 = list.getNode(20);
        SinglyLinkedList.Node<Integer> node2 = list.getNode(30);

        list.swapNodes(node1, node2);

        System.out.print("After swapping 20 and 30: " + list + "\n");
    }
}
