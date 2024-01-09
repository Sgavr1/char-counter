package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterProxyTest {
    @ParameterizedTest()
    @CsvSource({"Hello world!", "qqqwwweeerrr", "Using Mock class"})
    public void shouldReturnFixedAnswerWhenUseMockClass(String line){
        SymbolCounter symbolCounter = new SymbolCounterProxy(new SymbolCounterMock());

        Map<Character,Integer> symbolStatistic = symbolCounter.count(line);

        assertEquals(4,symbolStatistic.size());
        assertEquals(1,symbolStatistic.get('M'));
        assertEquals(1,symbolStatistic.get('o'));
        assertEquals(1,symbolStatistic.get('c'));
        assertEquals(1,symbolStatistic.get('k'));
    }

    @Test
    public void shouldReturnCorrectAnswerWhenUseActualImplementationInterface(){
        SymbolCounter symbolCounter = new SymbolCounterProxy(new SymbolCounterImpl());

        Map<Character,Integer> answer = symbolCounter.count("Hello world!");

        assertEquals(9, answer.size());

        assertEquals(1, answer.get('H'));
        assertEquals(1, answer.get('e'));
        assertEquals(3, answer.get('l'));
        assertEquals(2, answer.get('o'));
        assertEquals(1, answer.get(' '));
        assertEquals(1, answer.get('w'));
        assertEquals(1, answer.get('r'));
        assertEquals(1, answer.get('d'));
        assertEquals(1, answer.get('!'));
    }
}