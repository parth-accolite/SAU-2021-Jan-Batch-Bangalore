package com.springau.mockito;

public class Mock2 {

	public Mock1 mock1;

	public String upperCaseConversion(Mock1 mock1) {
		this.mock1 = mock1;
		String str = mock1.getName();
		return str.toUpperCase();
	}

	public String getRole() {
		return "Intern lala";
	}
}
