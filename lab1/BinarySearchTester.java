package lab1;

import static org.junit.Assert.*;
import org.junit.Test;


public class BinarySearchTester {
	
	@Test
	  public void test1(){

	    //create an array to search with:
	    Integer[] objectArray = {1,2,3,4,5,6};

	    //Create a new object with "this_array" as the data, and of type int
	    BinarySearchableArray<Integer> hayStack = new BinarySearchableArray<Integer>(objectArray);
	    
	    Integer needle = 4;
	    //Search for "4" from the "hayStack"
	    assertEquals(needle,hayStack.search(4));
	    // Should return null
	    assertEquals(null, hayStack.search(10));
	    
	  }

	
}
