package com.example;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class AnimalTest {
    private final Animal animal = new Animal();

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        List<String> expected = Arrays.asList("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodForUnknownTypeThrowsException() throws Exception {
        animal.getFood("Неизвестный");
    }

    @Test
    public void testGetFoodForUnknownTypeExceptionMessage() {
        try {
            animal.getFood("Неизвестный");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @RunWith(Parameterized.class)
    public static class AnimalParameterizedTest {
        private String animalKind;
        private Class<? extends Exception> expectedException;
        private Animal animal = new Animal();

        public AnimalParameterizedTest(String animalKind, Class<? extends Exception> expectedException) {
            this.animalKind = animalKind;
            this.expectedException = expectedException;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Травоядное", null},
                    {"Хищник", null},
                    {"Неизвестный", Exception.class},
                    {"", Exception.class},
                    {null, Exception.class}
            });
        }

        @Test
        public void testGetFoodParameterized() throws Exception {
            if (expectedException != null) {
                try {
                    animal.getFood(animalKind);
                    fail("Expected exception was not thrown");
                } catch (Exception e) {
                    assertTrue(expectedException.isInstance(e));
                }
            } else {
                assertNotNull(animal.getFood(animalKind));
            }
        }
    }
}
