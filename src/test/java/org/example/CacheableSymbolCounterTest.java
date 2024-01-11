package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CacheableSymbolCounterTest {
    @Test
    public void shouldReturnFixedAnswerWhenUseMockClass(){
        SymbolCounter symbolCounter = Mockito.mock(SymbolCounter.class);

        Mockito.when(symbolCounter.count("Hello world!")).thenReturn(new HashMap<>());

        SymbolCounter cacheableSymbolCounter = new CacheableSymbolCounter(symbolCounter);

        symbolCounter.count("Hello world!");

        verify(symbolCounter, times(1)).count("Hello world!");
    }

    @Test
    public void shouldReturnCachedResponseWhenRepeatedData(){
        SymbolCounter symbolCounter = Mockito.mock(SymbolCounter.class);
        Mockito.when(symbolCounter.count("Hello world!")).thenReturn(new HashMap<>());

        SymbolCounter cacheableSymbolCounter = new CacheableSymbolCounter(symbolCounter);

        cacheableSymbolCounter.count("Hello world!");
        cacheableSymbolCounter.count("Hello world!");

        verify(symbolCounter, times(1)).count("Hello world!");
    }
}