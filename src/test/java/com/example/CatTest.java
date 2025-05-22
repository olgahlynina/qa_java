package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CatTest {

    private Feline felineMock;
    private Cat cat;
    private List<String> expectedFood;

    @BeforeEach
    void setUp() {
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}
