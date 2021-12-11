import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

        Node() {
            item = null;
            next = null;
        }
    }

    private Node head;
    private int  size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        head = null;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {

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

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // get a random number [0,size)
        int rd = StdRandom.uniform(size);
        // if rd == 0
        if (rd == 0) {
            Item item = head.item;
            head = head.next;
            size--;
            return item;
        }

        Node runner = head;
        while (rd > 1) {
            rd--;
            runner = runner.next;
        }
        Item item = runner.next.item;
        runner.next = runner.next.next;
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int rd = StdRandom.uniform(size);
        Node runner = head;
        while (rd > 0) {
            rd--;
            runner = runner.next;
        }
        return  runner.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // Iterator
    private class RandomizedQueueIterator implements Iterator<Item> {

        private Node current;
        private boolean[] checked = new boolean[size];

        RandomizedQueueIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int rd = StdRandom.uniform(size);
            while (checked[rd]) {
                rd = StdRandom.uniform(size);
            }

            checked[rd] = true;
            Node runner = head;
            while (rd > 0) {
                rd--;
                runner = runner.next;
            }
            return  runner.item;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> testRdQueue = new RandomizedQueue<>();

        testRdQueue.enqueue(0);

        testRdQueue.iterator();
        /*
        while (iterator.hasNext()) {
            StdOut.println(iterator.next());
        }
         */

    }

}