package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolCounterImpl implements SymbolCounter {
    @Override
    public Map<Character,Integer> count(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        Map<Character,Integer> symbols = new HashMap<>();

        for (char c : line.toCharArray()) {
            Integer symbolCounter = symbols.get(c);

            if (symbolCounter == null) {
                symbolCounter = 0;
            }

            symbols.put(c,symbolCounter + 1);
        }

        return symbols;
    }
}
