public class SLList{
	public static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}

	private IntNode = first;
	private int size;

	public SLList(int x){
		first = new IntNode(x, null);
		size = 1;
	}

	public void addFirst(int x){
		first = new IntNode(x, first);
		size += 1
	}

	public int getFirst(int x){
		return first.item;
	}

	public int size(){
		return size;
	}
}