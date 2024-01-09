package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterTest {
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNull() {
        SymbolCounter symbolCounter = new SymbolCounterImpl();

        assertThrows(IllegalArgumentException.class, () -> {
            symbolCounter.count(null);
        });
    }

    @Test
    public void shouldReturnEmptyStringStatisticsWhenStringIsEmpty() {
        SymbolCounter symbolCounter = new SymbolCounterImpl();

        Map<Character,Integer> stringStatistics = symbolCounter.count("");

        assertEquals(0, stringStatistics.size());
    }

    @Test
    public void shouldReturnCorrectStatisticsWhenAnyString() {
        SymbolCounter symbolCounter = new SymbolCounterImpl();

        Map<Character,Integer> symbols = symbolCounter.count("Hello world!");

        assertEquals(9, symbols.size());

        assertEquals(1, symbols.get('H'));
        assertEquals(1, symbols.get('e'));
        assertEquals(3, symbols.get('l'));
        assertEquals(2, symbols.get('o'));
        assertEquals(1, symbols.get(' '));
        assertEquals(1, symbols.get('w'));
        assertEquals(1, symbols.get('r'));
        assertEquals(1, symbols.get('d'));
        assertEquals(1, symbols.get('!'));
    }
}