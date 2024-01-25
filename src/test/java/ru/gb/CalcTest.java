package ru.gb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calcAverageTest() {
        double result=Calc.calcAverage(Stream.of(1,2,3).toList());
        assertEquals(2,result);
    }

//    @Test
//    void checkListsEqualTest() {
//        String result=Calc.checkLists(Stream.of(1,2,3).toList(),Stream.of(-0,2).toList());
//        assertEquals("Средние значения равны",result);
//    }
}