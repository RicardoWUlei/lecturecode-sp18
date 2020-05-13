public class IntList {
	public int first;
	public IntList rest;

    /**Constructor. */
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
    }
    
    /**Add two identical numbers in a row and make one larger
     * node. Using recursion.    */
    public void addAdjacent(){
        if(rest==null)
            return;
        if(first==rest.first){
            first *= 2;
            rest = rest.rest;
            addAdjacent();
        }
        else{
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

	public static void main(String[] args) {
		IntList L = new IntList(3, null);
		L = new IntList(2, L);
        L = new IntList(1, L);
        L = new IntList(1, L);
        L.addAdjacent();
		System.out.println(L.size());
	}
}