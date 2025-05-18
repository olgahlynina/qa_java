package com.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    @TestFactory
    List<DynamicTest> testLion() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(1);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        return Arrays.asList(
                DynamicTest.dynamicTest("Test Lion Male", () -> {
                    Lion lion = new Lion("Самец", felineMock);
                    assertTrue(lion.doesHaveMane());
                    assertEquals(1, lion.getKittens());
                    assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
                }),
                DynamicTest.dynamicTest("Test Lion Female", () -> {
                    Lion lion = new Lion("Самка", felineMock);
                    assertFalse(lion.doesHaveMane());
                    assertEquals(1, lion.getKittens());
                    assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
                })
        );
    }
}

