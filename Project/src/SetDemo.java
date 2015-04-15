import java.util.*;

public class SetDemo {
	public static void main(String[] args) {
		// Create a set called mySet
		Set<String> mySet = new HashSet();
		// Ensure that this set contains an interesting selection of fruit
		String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine", fruit4 = "strawberry", fruit5 = "blackberry";
		mySet.add(fruit1);
		mySet.add(fruit2);
		mySet.add(fruit3);
		mySet.add(fruit2);
		mySet.add(fruit4);
		mySet.add(fruit5);
		// Display contents of mySet
		System.out.println("mySet now contains:");
		System.out.println(mySet);
		//Display the cardinality of mySet
		System.out.println("Cardinality of mySet is : " +mySet.size());
		//Remove blackberry and strawberry
		mySet.remove(fruit4);
		mySet.remove(fruit5);
		System.out.println("After removing strawberry and blackberry, mySet now contains:");
		System.out.println(mySet);
		//Remove all fruits
		mySet.removeAll(mySet);
		//Show if empty
		System.out.println("Is mySet empty? " + mySet.isEmpty());
	}
}
