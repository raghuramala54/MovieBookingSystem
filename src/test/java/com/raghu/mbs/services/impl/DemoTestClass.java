package com.raghu.mbs.services.impl;

import org.junit.jupiter.api.*;

public class DemoTestClass {
    @BeforeEach
    public void executeBeforeEachTest(){
        System.out.println("Executed before each test");
    }
    /**
     * First test method
     */
    @Test
    public void firstTest()
    {
        System.out.println("This is the first test method");
    }

    @Test
    public void secondTest()
    {
        System.out.println("This is the second test method");
    }

    @AfterEach
    public void executeAfterEachTest()
    {
        System.out.println("Executed after each test");
    }

    @BeforeAll
    public static void beforeEverything()
    {
        System.out.println("Before Everything");
    }

    @AfterAll
    public static void afterEveryThing(){
        System.out.println("After Every Thing");
    }

    @Test
    public void assertionTest(){
        int expected =5;
        int actual=3+2;
        Assertions.assertEquals(expected,actual);
    }
}
