package com.shop.novelbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovelBookingApplicationTests {

	@Test
	void contextLoads() {
	}


	class Calculator{
		int add(int a, int b){
			return a+ b;
		}
	}

	Calculator underTest = new Calculator();


	@Test
	void itShouldAddTwoNumbers(){
		//given
		  int numberOne = 30;
		  int numberTwo = 20;

		//when
		  int result = underTest.add(numberOne, numberTwo);

		//then
		  assertEquals(result,50);

	}
}
