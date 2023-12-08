package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterTest {
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNull() {
        SymbolCounter symbolCounter = new SymbolCounterProxy();

        assertThrows(IllegalArgumentException.class, () -> {
            symbolCounter.count(null);
        });
    }

    @Test
    public void shouldReturnEmptyStringStatisticsWhenStringIsEmpty() {
        SymbolCounter symbolCounter = new SymbolCounterProxy();

        Map<Character,Integer> stringStatistics = symbolCounter.count("");

        assertEquals(0, stringStatistics.size());
    }

    @Test
    public void shouldReturnCorrectStatisticsWhenAnyString() {
        SymbolCounter symbolCounter = new SymbolCounterProxy();

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

    @Test
    public void shouldReturnValueFromCacheWhenEqualsString() {
        SymbolCounter symbolCounter = new SymbolCounterProxy();

        long noCacheTime = System.nanoTime();
        Map<Character,Integer> symbolMap1 = symbolCounter.count("qwxwemcyfieuhfcfhneu herihfmeuhfncmj iuehrnueehjvn ehruhfiwofko;jiubkjhn iiejoifjwkeoifh2p38ouf8ouiv hn8i4htiugjv ou4yhtguy35go8iuythog483u ho87i4u3yhfonunjvvhe4i75uyghovuijh n8547iuyhtnof8uih");
        noCacheTime = System.nanoTime() - noCacheTime;

        long cacheTime = System.nanoTime();
        Map<Character,Integer> symbolMap2 = symbolCounter.count("qwxwemcyfieuhfcfhneu herihfmeuhfncmj iuehrnueehjvn ehruhfiwofko;jiubkjhn iiejoifjwkeoifh2p38ouf8ouiv hn8i4htiugjv ou4yhtguy35go8iuythog483u ho87i4u3yhfonunjvvhe4i75uyghovuijh n8547iuyhtnof8uih");
        cacheTime = System.nanoTime() - cacheTime;

        assertEquals(symbolMap1, symbolMap2);
        assertTrue(cacheTime < noCacheTime - 10000);
    }
}