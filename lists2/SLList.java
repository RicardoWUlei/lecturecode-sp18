/**
 * An SLList is a list of integers, which hides the terrible truth of the
 * nakedness within.
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
            // System.out.println(size);
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Construct a SLList with an array of integers. */
    public SLList(int[] x) {
        sentinel = new IntNode(63, null);
        size = 0;
        IntNode p = sentinel;
        for (int i = 0; i < x.length; i++) {
            p.next = new IntNode(x[i], null);
            p = p.next;
            size += 1;
        }
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Deletes the first item in the list. */
    public void deleteFirst() {
        size = size - 1;
        IntNode p = sentinel.next.next;
        sentinel.next = p;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        int[] x = { 1, 2, 3 };
        SLList L = new SLList(x);
        System.out.println(L.getFirst());
    }
}