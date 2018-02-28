package lab4;

/**
 * This is a simple implementation of a Linked Binary Tree, designed for use in
 * INFO1105/1905/9105 at the University of Sydney.
 *
 * It contains some code derived from work: Copyright 2014, Michael T. Goodrich,
 * Roberto Tamassia, Michael H. Goldwasser Developed for use with the book: Data
 * Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich, Roberto
 * Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {

	/*
	 * This nested class contains a completed implementation of Position which
	 * you should use within LinkedPositionalList.
	 * 
	 * You do not need to edit the nested class.
	 */
	@SuppressWarnings("hiding")
	protected class Node<E> implements Position<E> {

		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		private E element;

		public Node(E element) {
			this.element = element;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public Node<E> getParent() {
			return parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		}

		public E getElement() {
			return element;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public void setElement(E element) {
			this.element = element;
		}
	} // end of nested class

	private Node<E> root;
	private int size;

	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}

	@Override
	public Position<E> left(Position<E> p) {
		Node<E> node = (Node<E>) p;
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) {
		Node<E> node = (Node<E>) p;
		return node.getRight();
	}

	@Override
	public Position<E> sibling(Position<E> p) {
		Node<E> node = (Node<E>) p;
		Node<E> parent = node.getParent();
		if (parent == null) {
			return null;
		} else if (parent.getLeft() == node) {
			return parent.getRight();
		} else {
			return parent.getRight();
		}
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) {
		Node<E> node = (Node<E>) p;
		return node.getParent();
	}

	@Override
	public int numChildren(Position<E> p) {
		Node<E> node = (Node<E>) p;
		int numChildren = 0;
		if (node.getLeft() != null) {
			numChildren += 1;
		}
		if (node.getRight() != null) {
			numChildren += 1;
		}
		return numChildren;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		return root == (Node<E>) p;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// add a root to an empty tree
	public Position<E> addRoot(E e) {
		// if the tree is not empty, throw an exception
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
		// create the new root
		root = new Node<E>(e);
		size = 1;
		return root;
	}

	/**
	 * Creates a new left child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p
	 *            the Position to the left of which the new element is inserted
	 * @param e
	 *            the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException
	 *             if p is not a valid Position for this tree
	 * @throws IllegalArgumentException
	 *             if p already has a left child
	 */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> n = (Node<E>) p;
		if (n.getLeft() != null) {
			throw new IllegalArgumentException("Node already had a left child!");
		}
		Node<E> child = new Node<E>(e);
		n.setLeft(child);
		child.setParent(n);
		size += 1;
		return child;
	}

	/**
	 * Creates a new right child of Position p storing element e and returns its
	 * Position.
	 *
	 * @param p
	 *            the Position to the right of which the new element is inserted
	 * @param e
	 *            the new element
	 * @return the Position of the new element
	 * @throws IllegalArgumentException
	 *             if p already has a right child
	 */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> n = (Node<E>) p;
		if (n.getRight() != null) {
			throw new IllegalArgumentException("Node already had a right child!");
		}
		Node<E> child = new Node<E>(e);
		n.setRight(child);
		child.setParent(n);
		size += 1;
		return child;
	}

	/**
	 * Replaces the element at Position p with element e and returns the
	 * replaced element.
	 *
	 * @param p
	 *            the relevant Position
	 * @param e
	 *            the new element
	 * @return the replaced element
	 */
	public E set(Position<E> p, E e) {
		Node<E> node = (Node<E>) p;
		E oldElement = node.getElement();
		node.setElement(e);
		return oldElement;
	}

	/**
	 * Removes the node at Position p and replaces it with its child, if any.
	 *
	 * @param p
	 *            the relevant Position
	 * @return element that was removed
	 * @throws IllegalArgumentException
	 *             if p has two children.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = (Node<E>) p;

		// get the child
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}

		// get the child
		Node<E> child = node.getLeft();
		if (child == null) {
			child = node.getRight();
		}

		if (child != null) {
			// child's grandparent becomes it's parent
			child.setParent(node.getParent());
		}

		if (node == root) {
			// child becomes root
			root = child;
		} else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}

		size -= 1;

		return node.getElement();
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of
	 * the leaf Position p. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param p
	 *            a leaf of the tree
	 * @param t1
	 *            an independent tree whose structure becomes the left child of
	 *            p
	 * @param t2
	 *            an independent tree whose structure becomes the right child of
	 *            p
	 * @throws IllegalArgumentException
	 *             if p is not a leaf
	 */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = (Node<E>) p;
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size += t1.size() + t2.size();

		// attach t1 as left subtree of node
		if (!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}

		// attach t2 as right subtree of node
		if (!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	// ----------- TUTORIAL exercise 1 -----------
	/** Returns the number of leaf nodes */
	public int countLeaves() {
		if (this.root == null) {
			return 0;
		}
		return countLeaves(this.root);
	}

	/** Returns the number of leaf nodes that are in the subtree rooted at p */
	private int countLeaves(Position<E> p) {
		Node<E> node = (Node<E>) p;
		int numLeaves = 0;

		if (isExternal(p)) {
			// TODO: code for the base case (nodes without children)
			return 1;
		} else {
			// code for the recursive case (nodes with children)
			if (node.getLeft() != null) {
				// There is a left child, count its leaves
				numLeaves += countLeaves(node.getLeft());
			}
			if (node.getRight() != null) {
				// TODO: if there is a right child
				numLeaves += countLeaves(node.getRight());

			}
		}
		return numLeaves;
	}

	public boolean preorder(Position<E> p) {
		Node<E> node = (Node<E>) p;
		// Base Case 1:
		// Tree that is just a leaf

		// Base Case 2 :
		// Number of leaves is not right
		if (node == null) {
			return true;
		} else if (isExternal(node)) {
			return true;
		} else if (numChildren(node) == 2) {
			return (preorder(node.left) && preorder(node.right));
		}
		return false;
	}

	// ----------- TUTORIAL exercise 2 -----------
	/** Returns true if the tree is proper, false otherwise */
	public boolean isProper() {
		// If the tree is empty it is a proper tree
		if (this.root == null) {
			return true;
		}
		Position<E> main = this.root;
		Node<E> node = (Node<E>) main;
		Node<E> left = node.getLeft();
		Node<E> right = node.getRight();
		// If the root has 0 children, it is a proper tree
		if (isExternal(node)) {
			return true;
		} else if (left == null || right == null) {
			return false;
		}
		return preorder(left) && preorder(right);
	}

	public LinkedBinaryTree<E> reverseTree(Position<E> o, Position<E> n, LinkedBinaryTree<E> reversed) {
		Node<E> oldNode = (Node<E>) o;
		Node<E> newNode = (Node<E>) n;
		// Checks that node's left child is not null
		if (oldNode.getLeft() != null) {
			// Add right flipped node to tree
			reversed.addRight(n, oldNode.getLeft().getElement());
			reverseTree(oldNode.getLeft(), newNode.getRight(), reversed);
		}
		// Checks that node's right child is not null
		if (oldNode.getRight() != null) {
			// Add left flipped node to tree
			reversed.addLeft(n, oldNode.getRight().getElement());
			reverseTree(oldNode.getRight(), newNode.getLeft(), reversed);
		}
		return reversed;
	}

	// ----------- TUTORIAL exercise 3 -----------
	/** Returns a mirrored copy of the tree */
	public LinkedBinaryTree<E> mirror() {
		LinkedBinaryTree<E> reversed = new LinkedBinaryTree<E>();
		// Root is null
		if (this.root == null) {
			return null;
			// Root has no children
		} else if (isExternal(this.root)) {
			reversed.addRoot(this.root.getElement());
			return reversed;
			// Otherwise it calls reverseTree to make a new reversed tree
		} else {
			reversed.addRoot(this.root.getElement());
			reversed = reverseTree(this.root, reversed.root, reversed);
			return reversed;
		}
	}

	public Position<E> invertTree(Position<E> root) {
		Node<E> parent = (Node<E>) root;
		// If root is null, it returns null
		if (root == null) {
			return null;
		}
		// Saves the values to variables and recursive calls
		Node<E> right = (Node<E>) invertTree(parent.getRight());
		Node<E> left = (Node<E>) invertTree(parent.getLeft());
		// Switches the positions
		parent.left = right;
		parent.right = left;
		// Returns root
		return root;
	}

	// ----------- TUTORIAL exercise 4 -----------
	/** Reverses the tree */
	public void reverseMe() {
		// If the tree is not null, it will call a reversing Algorithm
		if (this.root.getElement() != null) {
			invertTree(this.root());
		}
	}

}
