/**Array Based List
 * @author Xiaotiao
 */

// Invariants:
// addLast: the next item we want to add, will go into the position size
// getLast: the item we want to return is in position (size-1)
// size: the number of items in the list should be the size
// removeLast
public class AList<Item>{
	private Item[] items;
	private int size;


	// Create an empty list
	public AList(){
		items = (Item[]) new Object[100];
		size = 0;
	}

	public void resize(int capacity){
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(items,0,a,0,size);
		items = a;	
	}
	// Insert X into the back of the list
	public void addLast(Item x){
		if (size == items.length){
			resize(size*2);
		}
		items[size] = x;
		size = size + 1;
	}

	// Return the item from the back of the list
	public Item getLast(){
		return items[size - 1];
	}

	// Get the ith item from the list(0 is the front)
	public Item get(int i){
		return items[i];
	}

	// Return the number of items in the list
	public int size(){
		return size;
	}
	// Delete the item from back of the list 
	// and return the deleted item.
	public Item removeLast(){
		Item x = getLast();
		size = size - 1;
		return x;
	}


}