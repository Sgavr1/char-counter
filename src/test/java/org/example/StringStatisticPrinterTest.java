package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringStatisticPrinterTest {
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenArgumentIsNull(){
        StringStatisticPrinter stringStatisticPrinter = new StringStatisticPrinter();

        assertThrows(IllegalArgumentException.class, () -> {
            stringStatisticPrinter.print(null);
        });
    }

    @Test
    public void shouldReturnCorrectStringInformationWhereAnyText(){
        StringStatisticPrinter stringStatisticPrinter = new StringStatisticPrinter();
        SymbolCounter symbolCounter = new SymbolCounter();

        String correctString = "Hello world!\n";
        correctString += "\"H\" - 1\n";
        correctString += "\"e\" - 1\n";
        correctString += "\"l\" - 3\n";
        correctString += "\"o\" - 2\n";
        correctString += "\" \" - 1\n";
        correctString += "\"w\" - 1\n";
        correctString += "\"r\" - 1\n";
        correctString += "\"d\" - 1\n";
        correctString += "\"!\" - 1\n";

        assertEquals(correctString, stringStatisticPrinter.print(symbolCounter.count("Hello world!")));
    }

}