public class IntList {
    public int first;
    public IntList rest;

    /** Constructor. */
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /**
     * Add two identical numbers in a row and make one larger node. Using recursion.
     */
    public void addAdjacent() {
        if (rest == null)
            return;
        if (first == rest.first) {
            first *= 2;
            rest = rest.rest;
            addAdjacent();
        } else {
            rest.addAdjacent();
        }
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /**
     * Add an node and "sqaure" the list using recursion.
     */
    public void addNode(int x) {
        if (rest == null) {
            rest = new IntList(first * first, null);
            rest.rest = new IntList(x, null);
            return;
        } else {
            IntList p = rest;
            rest = new IntList(first * first, p);
            rest.rest.addNode(x);
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(2, null);
        L = new IntList(1, L);
        L.addNode(5);
        L.addNode(7);
    }
}