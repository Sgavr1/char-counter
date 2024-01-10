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
            Integer symbolCount = symbols.get(c);

            if (symbolCount == null) {
                symbolCount = 0;
            }

            symbols.put(c, symbolCount + 1);
        }

        return symbols;
    }
}
