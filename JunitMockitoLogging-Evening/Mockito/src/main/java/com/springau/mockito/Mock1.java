package com.springau.mockito;

public class Mock1 {
	public Mock2 mock2;
	public int[] getValues() {
		int[] arr = {10,20,30,40};
		return arr;
	}
	public String getName() {
		return "Intern";
	}
	
//	public int maxValue(Mock2 mock2) {
//		int[] nums = mock2.getNums();
//		int max
//	}
	
	public String subString(Mock2 mock2) {
		return mock2.getRole().substring(0,6);
	}	
}
