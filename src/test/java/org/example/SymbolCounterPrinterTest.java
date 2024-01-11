package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterPrinterTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArgumentIsNull(){
        SymbolCounterPrinter printer = new SymbolCounterPrinter();

        assertThrows(IllegalArgumentException.class, () ->{
            printer.print(null);
        });
    }

    @Test
    public void shouldReturn(){
        SymbolCounterPrinter printer = new SymbolCounterPrinter();

        Map<Character,Integer> symbols = new HashMap<>();
        symbols.put('w',1);
        symbols.put('g',2);
        symbols.put('t',1);

        String correctResponse = "\"t\" - 1\n\"w\" - 1\n\"g\" - 2\n";

        assertEquals(correctResponse,printer.print(symbols));
    }
}