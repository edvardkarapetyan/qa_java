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

public class CatTest {
    @Mock
    private Predator predator;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(predator);
        assertEquals(expectedFood, cat.getFood());
        verify(predator, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        when(predator.eatMeat()).thenThrow(new Exception("Ошибка"));
        Cat cat = new Cat(predator);
        cat.getFood();
    }
}
