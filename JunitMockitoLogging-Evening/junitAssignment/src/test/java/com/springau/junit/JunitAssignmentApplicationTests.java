package com.springau.junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitAssignmentApplicationTests {

	@Test
    public void test1() {
        LeapYear object = new LeapYear();
        boolean res = object.isLeapYear(2020);
        assertEquals(true, res);
    }

    @Test
    public void test2() {
        LeapYear object = new LeapYear();
        boolean res = object.isLeapYear(2021);
        assertEquals(false, res);
    }

    @Test
    public void test3() {
        LeapYear object = new LeapYear();
        boolean res = object.isLeapYear(2022);
        assertEquals(false, res);
    }

    @Test
    public void test4() {
        LeapYear object = new LeapYear();
        boolean res = object.isLeapYear(-2020);
        assertEquals(false, res);
    }

    @Test
    public void test5() {
        LeapYear object = new LeapYear();
        boolean res = object.isLeapYear(2000);
        assertEquals(true, res);
    }

}
