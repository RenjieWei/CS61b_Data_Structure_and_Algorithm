public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}

	/**using recursion method**/
	public int size(){
		if (rest == null){
			return 1;
		}
		return 1 + this.rest.size();
	}

	/**Not Recursion*/
	public int iterativeSize(){
		IntList p = this;
		int totalSize = 0;
		while (p != null){
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}
	/**Return the ith item of the list */
	public int get(int i){
		if (i == 0){
			return first;
		}
		return rest.get(i-1)
	}


	pulic static void main(String[] args){
		IntList L = new IntList(5, null);
		L = new IntList(10,L);
		L = new IntList(15,L);
	}
}