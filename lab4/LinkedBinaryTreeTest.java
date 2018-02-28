package lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedBinaryTreeTest {
	
	LinkedBinaryTree<String>tree = new LinkedBinaryTree<String>();
	
	@Test
	public void completeTree() {
		tree.addRoot("God");
		tree.addLeft(tree.root(), "Humans");
		tree.addRight(tree.root(), "Forest");
		
		// Root
		Position <String> god = tree.root();
		// Descendants of root
		Position <String> humans = tree.left(god);
		Position <String> forest = tree.right(god);
		
		assertEquals("God", tree.root().getElement());
		assertEquals("Humans", tree.left(tree.root()).getElement());
		
		// Descendants of humans
		tree.addLeft(tree.left(god), "Adam");
		tree.addRight(humans, "Eve");
		assertEquals("Adam", tree.left(tree.left(god)).getElement());
		assertEquals("Eve", tree.right(humans).getElement());
		// Adam is a leaf node
		assertNull(tree.left(tree.left(humans)));
		
		// Descendants of forest
		tree.addLeft(forest, "Trees");
		tree.addRight(forest, "Animals");

		// Children of forest stored in positions
		Position<String> trees = tree.left(forest);
		Position<String> animals = tree.right(forest);
		
		// Descendants of trees (leaf nodes)
		tree.addLeft(trees, "Apple Tree");
		tree.addRight(trees, "Orange Tree");
		assertEquals("Apple Tree", tree.left(trees).getElement());
		// Descendants of animals (leaf nodes)
		tree.addLeft(animals, "Snake");
		tree.addRight(animals, "Cow");
		assertEquals("Cow", tree.right(animals).getElement());	
	}
	
	@Test
	public void isProper() {
		assertEquals(true, tree.isProper());	
	}
	
	@Test
    public void testMirror() {
    
        //construct tree
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
        t.addRoot(1);
        Position<Integer> root = t.root();
        Position<Integer> n1 = t.addLeft(root, 2);
        t.addRight(root, 3);
        t.addRight(n1, 4);
        
        //check mirrored tree
        LinkedBinaryTree<Integer> tm = t.mirror();
        Position<Integer> tmroot = tm.root();
        assertEquals(tI(1), tmroot.getElement());
//        System.out.println(tm.root().getElement());
        assertEquals(tI(3), tm.left(tmroot).getElement());
        assertEquals(tI(2), tm.right(tmroot).getElement());
        assertEquals(tI(4), tm.left(tm.right(tmroot)).getElement());
    }

    private Integer tI(int x) {
        return (Integer)x;
    }
	
}
