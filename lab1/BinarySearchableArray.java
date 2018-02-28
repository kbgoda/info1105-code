package lab1;

public class BinarySearchableArray<T extends Comparable<T>> extends SearchableArray<T> {

	// constructor
	public BinarySearchableArray(T[] data) {
		super(data); // call the constructor of the super-type as
						// SearchableArray<T>(data)
	}

	@Override
	public T search(T target) {

		// your code goes here.
		// to help implement this recursively, you may want to add another
		// method

		int low = 0;
		int high = data.length - 1;

		if (high < low) {
			return null;
		}

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			T midVal = data[mid];

			if (midVal.compareTo(target) == 0) {
				return midVal;
				// midVal is greater than target
			} else if (midVal.compareTo(target) < 0) {
				low = mid + 1;
			} else if (midVal.compareTo(target) > 0){
				high = mid - 1;
			}
		}
		return null;
		// System.out.println(high);

	}

}
