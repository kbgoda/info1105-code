package lab1;

import java.util.ArrayList;
import java.util.List;

//Start with any positive integer. 
//If the current number is even, divide it by two; 
//else if it is odd, multiply it by three and add one. Repeat until 1 is reached.
public class Hailstone {
	ArrayList<Integer> list;
	public Hailstone() {
		this.list = new ArrayList<Integer>();
	}
	public List<Integer>hailstone(int n) {
		list.add(n);
		while(n != 1) {
			if(n % 2 == 0) {
				n = n/2;
			} else {
				n = (n*3) + 1;
			}
			list.add(n);
		}
		return list;	
	}
}
