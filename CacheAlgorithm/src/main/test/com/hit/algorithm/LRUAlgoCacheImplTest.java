package com.hit.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUAlgoCacheImplTest implements IAlgoCacheTest{

    @Test
    public void getElement() {
        IAlgoCache<Integer, String> testObject = new LRUAlgoCacheImpl<>(3);

        testObject.putElement(10, "Ten");
        testObject.putElement(20, "Twenty");
        testObject.putElement(30, "Thirty");

        assertEquals("Ten", testObject.getElement(10));
        assertEquals("Twenty", testObject.getElement(20));
        assertEquals(null, testObject.getElement(2));
        assertEquals("Ten", testObject.getElement(10));
        assertEquals("Twenty", testObject.getElement(20));
        assertEquals("Thirty", testObject.getElement(30));
    }

    @Test
    public void putElement() {
        IAlgoCache<Integer, String> testObject = new LRUAlgoCacheImpl<>(3);

        testObject.putElement(10, "Ten");
        testObject.putElement(20, "Twenty");
        testObject.putElement(30, "Thirty");

        String s1 = testObject.putElement(40, "Forty");
        assertEquals("Ten", s1);
        s1 = testObject.putElement(10, "Ten");
        assertEquals("Twenty", s1);

        s1 = testObject.putElement(40, "Forty");
        assertEquals(null, s1);
    }

    @Test
    public void removeElement() {
        IAlgoCache<Integer, String> testObject = new LRUAlgoCacheImpl<>(3);

        testObject.putElement(10, "Ten");
        testObject.putElement(20, "Twenty");
        testObject.putElement(30, "Thirty");

        testObject.removeElement(20);
        assertEquals(null, testObject.getElement(20));
        testObject.removeElement(10);
        assertEquals(null, testObject.getElement(10));
        testObject.removeElement(30);
        assertEquals(null, testObject.getElement(30));
    }
}