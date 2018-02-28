package lab1;

public class EnglishCalculator {
	  public EnglishCalculator() {
	  }
	  public static double calculate(String s) {
//		  4 times 5 (which gives 20)
//		  2 plus 10 (which gives 12)
//		  6 minus 7 (which gives -1)
//		  15 divided by 5 (which gives 3)
		  
		  s = s.replaceAll("\\s+","");
		  String[] numbers = s.split("[^A-Z0-9.]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
		  String operation = s.substring(numbers[0].length(), s.length() - numbers[1].length());
		  
		  double[] nums = new double[numbers.length];
		  for(int i = 0; i < numbers.length; i++) {
			  nums[i] = Double.parseDouble(numbers[i]);
//			  System.out.println(nums[i]);
		  }
		  
		  if(operation.equals("dividedby")) {
			 return nums[0] / nums[1];
		  } else if(operation.equals("times")) {
			  return nums[0] * nums[1];
		  } else if(operation.equals("minus")) {
			  return nums[0] - nums[1];
		  } else if(operation.equals("add")){
			  return nums[0] + nums[1];
		  // If it is an invalid operation
		  } else {
			  System.out.println(operation);
			  return -1;
		  }
	  }
}
