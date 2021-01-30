package com.springau.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockitoApplicationTests {

	Mock1 mock1 = new Mock1();
	Mock2 mock2 = new Mock2();

	@Test
	public void testUpperCaseConversion() {
		Mock1 mock1 = mock(Mock1.class);
		when(mock1.getName()).thenReturn("Intern");
		String str = mock2.upperCaseConversion(mock1);
		assertEquals("INTERN", str);
	}

	@Test
	public void testSubstring() {
		System.out.println("Testing SubString Method");
		Mock2 mock2 = mock(Mock2.class);
		when(mock2.getRole()).thenReturn("Intern lalalala");
		String res = mock1.subString(mock2);
		assertEquals("Intern", res);
	}

}
