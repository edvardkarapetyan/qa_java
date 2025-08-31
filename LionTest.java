package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    private Predator predator;

    @Test
    public void testConstructorWithMale() throws Exception {

        Lion lion = new Lion("Самец", predator);
        assertNotNull(lion);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithFemale() throws Exception {

        Lion lion = new Lion("Самка", predator);
        assertNotNull(lion);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный", predator);
    }

    @Test
    public void testConstructorWithInvalidSexExceptionMessage() {
        try {
            new Lion("Неизвестный", predator);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }



    @Test
    public void testDoesHaveManeForMale() throws Exception {

        Lion lion = new Lion("Самец", predator);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {

        Lion lion = new Lion("Самка", predator);
        assertFalse(lion.doesHaveMane());
    }

}
