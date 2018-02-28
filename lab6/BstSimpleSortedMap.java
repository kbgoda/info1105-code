package lab6;

public class BstSimpleSortedMap implements SimpleSortedMap {

	private class MySimpleEntry implements SimpleEntry {

		private final Integer key;
		private final String value;
		private MySimpleEntry left;
		private MySimpleEntry right;
		private MySimpleEntry parent;

		MySimpleEntry(Integer key, String value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		@Override
		public Integer getKey() {
			return key;
		}

		@Override
		public String getValue() {
			return value;
		}

		protected MySimpleEntry getLeft() {
			return left;
		}

		protected MySimpleEntry getRight() {
			return right;
		}

		protected MySimpleEntry getParent() {
			return parent;
		}

		protected void setLeft(MySimpleEntry entry) {
			left = entry;
		}

		protected void setRight(MySimpleEntry entry) {
			right = entry;
		}

		protected void setParent(MySimpleEntry entry) {
			parent = entry;
		}
	}

	private int size;
	private MySimpleEntry root;

	public BstSimpleSortedMap() {
		size = 0;
		root = null;
	}

	// attaches the subtree rooted at 'child', to the parent
	private void attachLeft(MySimpleEntry parent, MySimpleEntry child) {
		if (child != null) {
			child.setParent(parent);
		}
		if (parent != null) {
			parent.setLeft(child);
		}
	}

	// attaches the subtree rooted at 'child', to the parent
	private void attachRight(MySimpleEntry parent, MySimpleEntry child) {
		if (child != null) {
			child.setParent(parent);
		}
		if (parent != null) {
			parent.setRight(child);
		}
	}

	//////////////////////////
	// Map ADT methods:
	//////////////////////////

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String get(Integer k) {
		return get(k, root);
	}

	private String get(Integer k, MySimpleEntry subtreeRoot) {
		// base case: empty subtree
		if (subtreeRoot == null) {
			// k isn't in this subtree
			return null;
		}

		// base case: k matches the key in the current entry
		if (k.compareTo(subtreeRoot.getKey()) == 0) {
			// TODO: return the value
			return subtreeRoot.getValue();
		}
		// recursive case: k < the current entry
		else if (k.compareTo(subtreeRoot.getKey()) < 0) {
			// TODO: return the result of recursing to the left
			return get(k, subtreeRoot.getLeft());
		}
		// recursive case: k > the current entry
		else {
			// TODO: return the result of recursing to the right
			return get(k, subtreeRoot.getRight());
		}
	}

	@Override
	public String put(Integer k, String v) {
		// We will implement this recursively.

		// Replace the subtree rooted at 'root' with
		// the resulting subtree after doing the put
		if (this.root == null) {
			this.root = put(k, v, this.root);
		} else if (this.root != null) {
			String old = get(k, this.root);
			this.root = put(k, v, this.root);
			return old;
		} else if (get(k) != null) {
			// If the key already exists, we will need to return the old value
			String old = get(k, this.root);
			// Replaces the value at key
			put(k, v, this.root);
			// returns us the old value
			return old;
			// Default case when value does not exist
		} else {
			put(k, v, this.root);
		}
		return null;
	}

	// Recursive helper method for put
	// Returns the subtree rooted at entry after performing the put
	private MySimpleEntry put(Integer k, String v, MySimpleEntry subtreeRoot) {
		// base case: the key wasn't in the subtree
		if (subtreeRoot == null) {
			// we have reached a null subtree, where k should be
			// TODO: create a new entry
			subtreeRoot = new MySimpleEntry(k, v);
			// TODO: increment the size variable
			size++;
			// Return
			return subtreeRoot;
		}

		// base case: k matches the one in the current entry
		if (k.compareTo(subtreeRoot.getKey()) == 0) {
			// The new replacement child
			MySimpleEntry replacement = new MySimpleEntry(k, v);
			// TODO: create a new entry
			MySimpleEntry parent = null;
			if (subtreeRoot != this.root) {
				parent = subtreeRoot.getParent();
				// Replacing the parent's old child with the new child
				if (parent.getKey() < subtreeRoot.getKey()) {
					parent.setRight(replacement);
				} else if (parent.getKey() > subtreeRoot.getKey()) {
					parent.setLeft(replacement);
				}
				replacement.setParent(parent);
			}
			
			// TODO: attachLeft the left child of the current entry to it
			attachLeft(replacement, subtreeRoot.getLeft());
			// TODO: attachRight the right child of the current entry to it
			attachRight(replacement, subtreeRoot.getRight());
			
			// Setting old root connections to null
			subtreeRoot.setParent(null);
			subtreeRoot.setLeft(null);
			subtreeRoot.setRight(null);
			// TODO: return the new subtree
			return replacement;
		}
		// recursive case: k < the current entry
		else if (k.compareTo(subtreeRoot.getKey()) < 0) {
			if (subtreeRoot.getLeft() != null) {
				this.put(k, v, subtreeRoot.getLeft());
			} else {
				MySimpleEntry left = new MySimpleEntry(k, v);
				// TODO: attach that subtree to the current entry
				this.attachLeft(subtreeRoot, left);
				size++;
			}
			// TODO: return the modified entry
		}
		// recursive case: k > the current entry
		else {
			if (subtreeRoot.getRight() != null) {
				// TODO: get the subtree resulting from recursing right
				this.put(k, v, subtreeRoot.getRight());
			} else {
				MySimpleEntry subtreeRight = new MySimpleEntry(k, v);
				// TODO: attach that subtree to the current entry
				this.attachRight(subtreeRoot, subtreeRight);
				size++;
			}
			// TODO: return the modified entry
		}
		return subtreeRoot;
	}

	@Override
	public String remove(Integer k) {
		// TODO implement this in exercise 2
		// Implement it recursively.
		return null;
	}

	@Override
	public Iterable<Integer> keySet() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<String> values() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<SimpleEntry> entrySet() {
		throw new java.lang.UnsupportedOperationException();
	}

	//////////////////////////
	// SortedMap ADT methods:
	//////////////////////////

	@Override
	public SimpleEntry firstEntry() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry lastEntry() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry ceilingEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry floorEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry lowerEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SimpleEntry higherEntry(Integer key) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Iterable<Integer> subMap(Integer fromKey, Integer toKey) {
		throw new java.lang.UnsupportedOperationException();
	}

}
