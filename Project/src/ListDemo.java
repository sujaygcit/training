import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListDemo {

	public static void main(String[] args) {
		
		List myList = new ArrayList();
		
		//Display elements using iterator
		myList.add("pear");
		myList.add("banana");
		myList.add("tangerine");
		myList.add("strawberry");
		myList.add("blackberry");
		System.out.println("**** Iterating list using Iterator ****");
		Iterator it = myList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//Display elements in reverse using ListIterator
		System.out.println("**** Reverse iteration using ListIterator ****");
		ListIterator lt = myList.listIterator(myList.size());
		while(lt.hasPrevious()){
			System.out.println(lt.previous());
		}
		
		//Insert bananas between strawberry and tangerine
		myList.add(3, "banana");
		System.out.println("**** Contents of myList after insertion");
		System.out.println(myList);
	}
}
