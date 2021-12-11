import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        Node() {
            item = null;
            next = null;
        }
    }

    // deque attributes
    private Node head;
    private int  size;


    // construct an empty deque
    public Deque() {
        head = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        // if queue has no element
        if (size == 0) {
            head = new Node();
            head.item = item;
            head.next = null;
            size++;
            return;
        }

        Node newFirst = new Node();
        newFirst.item = item;
        Node tempFirst = this.head;
        this.head = newFirst;
        newFirst.next = tempFirst;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        // if queue has no element
        if (size == 0) {
            head = new Node();
            head.item = item;
            head.next = null;
            size++;
            return;
        }

        // create new node with given item
        Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;

        // travel to last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Insert the new node after last node
        last.next = newLast;
        size++;


    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        if (size == 1) {
            Item itemm = head.item;
            head = null;
            size--;
            return itemm;
        }

        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        // if deque has only one element
        if (size == 1) {
            Item itemm = head.item;
            head = null;
            size--;
            return itemm;
        }


        // travel to nearly last node
        Node last = head;
        while (last.next.next != null) {
            last = last.next;
        }
        Item itemm = last.next.item;
        last.next = null;
        size--;
        return itemm;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current;

        ListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> testDeque = new Deque<>();


        /*
        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            testDeque.addFirst(c);
        }
        */

        Iterator<Integer> iterator = testDeque.iterator();
        StdOut.println(iterator.hasNext());

        /*
        StdOut.println();


        StdOut.println(testDeque.size);

        StdOut.println("Removed : " + testDeque.removeLast());
        StdOut.println(testDeque.size);


        StdOut.println("Removed : " + testDeque.removeLast());
        StdOut.println(testDeque.size);
         */
    }

}
