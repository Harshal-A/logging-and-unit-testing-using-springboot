package com.web.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorImplTest {


	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { 1, 2, 3 }, { 1, -1, 0 }, { -1, -2, -3 } });
	}
	
	

	@ParameterizedTest
	@MethodSource("data")
	public void test(int num1,int num2,int expectedResult) {
		Calculator calculate = new CalculatorImpl();
		int result = calculate.add(num1, num2);
		assertEquals(expectedResult, result);
	}

}
