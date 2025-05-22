package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {

    private final Feline felineMock = Mockito.mock(Feline.class);

    public LionTest() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }

    @ParameterizedTest(name = "Test Lion {0}")
    @ValueSource(strings = {"Самец", "Самка"})
    void testLion(String gender) throws Exception {
        Lion lion = new Lion(gender, felineMock);

        if ("Самец".equals(gender)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }

        assertEquals(1, lion.getKittens());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    void testLionInvalidGender() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lion("Неправильный пол", felineMock);
        });
        assertEquals("Некорректный пол", exception.getMessage());
    }
}
