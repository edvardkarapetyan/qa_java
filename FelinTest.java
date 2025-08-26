package com.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class FelinTest {
    private final Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @RunWith(Parameterized.class)
    public static class FelineParameterizedTest {
        private int input;
        private int expected;
        private Feline feline = new Feline();

        public FelineParameterizedTest(int input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0}, {1, 1}, {5, 5}, {10, 10}
            });
        }

        @Test
        public void testGetKittensWithCount() {
            assertEquals(expected, feline.getKittens(input));
        }
    }
}
