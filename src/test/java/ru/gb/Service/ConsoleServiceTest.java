package ru.gb.Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleServiceTest {
    private InputStream inDefault,inTest;
    private PrintStream outDefault,outTest;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private ConsoleService consoleService;
    @BeforeEach
    void setUp() {
        inDefault=System.in;
        outDefault=System.out;
        consoleService=new ConsoleService();
    }

    @AfterEach
    void tearDown() {
        System.setIn(inDefault);
        System.setOut(outDefault);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "Test"
            ,""
            ,"Тест"
            ,"1,2,3,4,5"
            ,"Hello world!"
            ,"Привет мир!"
    })
    void writeMessageTest(String testString) {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        consoleService.writeMessage(testString);
        String result=testOut.toString().strip();

        assertEquals(testString,result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Test"
            ,"Тест"
            ,"1,2,3,4,5"
            ,"Hello world!"
            ,"Привет мир!"
    })
    void getStringTest(String testString) {
        testIn =new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        String result=consoleService.getString();

        assertEquals(testString,result);
    }
    @Test
    void getStringTestEmpty() {
        testIn =new ByteArrayInputStream("".getBytes());
        System.setIn(testIn);


        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
           String result=consoleService.getString();
        });

        assertNotNull(thrown.getMessage());

    }


}