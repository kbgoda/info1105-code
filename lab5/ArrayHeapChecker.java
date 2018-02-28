package lab5;

public class ArrayHeapChecker {

	// Check if the given array is a representation of a binary tree
	public static boolean isBinaryTree(Integer[] array) {
		// Checks the size of the array
		int size = array.length;
		if (size == 0 || size == 1)
			return true;
		// n is in multiples of (2^n)-1
		int n = 1;
		// prevPow = pow's previous number
		int prevPow = 0;
		int pow = 0;
		// Verifies size of array is equivalent to a binary tree
		while (size >= pow) {
			prevPow = pow;
			pow = (int) Math.pow(2, n) - 1;
			n++;
			if (size == pow) {
				break;
			}
		}
		// A fully null binary tree will have its root as null
		// Hence children will always be null
		if (array[0] == null) {
			boolean emptyArray = true;
			for (int i = 0; i < size; i++) {
				if (array[i] != null) {
					emptyArray = false;
				}
			}
			if (emptyArray == false) {
				return false;
			}
		}
		// Checks the children of the nodes if root is not null
		if (array[0] != null) {
			for (int pos = 0; pos < prevPow; pos++) {
				if (array[pos] == null) {
					// Checks that the position value is less than size of array
					if (pos * 2 + 2 < size) {
						// Right is position*2 + 2
						if (array[pos * 2 + 2] != null)
							return false;
					}
					if (pos * 2 + 1 < size) {
						// Left is position*2 + 1
						if (array[pos * 2 + 1] != null)
							return false;
					}
				}
			}
		}
		return true;
	}

	// Check if the given array is a complete binary tree
	public static boolean isCompleteBinaryTree(Integer[] array) {
		int size = array.length;
		if (!isBinaryTree(array)) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (array[i] == null) {
				// Checks children
				for (int j = i; j < size; j++) {
					if (array[j] != null) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// Check if the given array is a min-heap
	public static boolean isMinHeap(Integer[] array) {
		int size = array.length;
		if (size == 0 || size == 1)
			return true;
		if (!isCompleteBinaryTree(array))
			return false;
		// If child is lesser than parent, return false
		for (int i = 1; i < size; i++) {
			if (array[i] != null && array[i] < array[(i - 1) / 2])
				return false;
		}
		return true;
	}
}
