package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterProxyTest {
    @Test
    public void shouldReturnFixedAnswerWhenUseMockClass(){
        SymbolCounter mock = Mockito.mock(SymbolCounter.class);

        Mockito.when(mock.count("Hello world!")).thenReturn(new HashMap<>());

        SymbolCounter symbolCounter = new SymbolCounterCache(mock);

        symbolCounter.count("Hello world!");

        verify(mock).count("Hello world!");
    }

    @Test
    public void shouldReturnCachedResponseWhenRepeatedData(){
        SymbolCounter symbolCounter = new SymbolCounterCache(new SymbolCounterImpl());

        assertEquals(symbolCounter.count("Hello world!"), symbolCounter.count("Hello world!"));
    }
}