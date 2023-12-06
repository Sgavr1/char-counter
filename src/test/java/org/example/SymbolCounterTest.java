package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterTest {
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenStringIsNull(){
        SymbolCounter symbolCounter = new SymbolCounter();

        assertThrows(IllegalArgumentException.class, () -> {
            symbolCounter.count(null);
        });
    }

    @Test
    public void shouldReturnEmptyStringStatisticsWhenStringIsEmpty(){
        SymbolCounter symbolCounter = new SymbolCounter();

        StringStatistics stringStatistics = symbolCounter.count("");

        assertEquals("", stringStatistics.getInputString());
        assertEquals(0, stringStatistics.getSymbols().size());
    }

    @Test
    public void shouldReturnCorrectStatisticsWhenAnyString(){
        SymbolCounter symbolCounter = new SymbolCounter();

        StringStatistics stringStatistics = symbolCounter.count("Hello world!");

        assertEquals("Hello world!", stringStatistics.getInputString());

        assertEquals(1, stringStatistics.getSymbols().get(0).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(1).getCounter());
        assertEquals(3, stringStatistics.getSymbols().get(2).getCounter());
        assertEquals(2, stringStatistics.getSymbols().get(3).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(4).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(5).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(6).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(7).getCounter());
        assertEquals(1, stringStatistics.getSymbols().get(8).getCounter());
    }

    @Test
    public void shouldReturnValueFromCacheWhenEqualsString(){
        SymbolCounter symbolCounter = new SymbolCounter();

        long noCacheTime = System.nanoTime();
        StringStatistics stringStatistics1 = symbolCounter.count("qwxwemcyfieuhfcfhneu herihfmeuhfncmj iuehrnueehjvn ehruhfiwofko;jiubkjhn iiejoifjwkeoifh2p38ouf8ouiv hn8i4htiugjv ou4yhtguy35go8iuythog483u ho87i4u3yhfonunjvvhe4i75uyghovuijh n8547iuyhtnof8uih");
        noCacheTime = System.nanoTime() - noCacheTime;

        long cacheTime = System.nanoTime();
        StringStatistics stringStatistics2 = symbolCounter.count("qwxwemcyfieuhfcfhneu herihfmeuhfncmj iuehrnueehjvn ehruhfiwofko;jiubkjhn iiejoifjwkeoifh2p38ouf8ouiv hn8i4htiugjv ou4yhtguy35go8iuythog483u ho87i4u3yhfonunjvvhe4i75uyghovuijh n8547iuyhtnof8uih");
        cacheTime = System.nanoTime() - cacheTime;

        assertEquals(stringStatistics1,stringStatistics2);
        assertTrue(cacheTime < noCacheTime -100000);
    }
}