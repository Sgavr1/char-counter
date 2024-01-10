package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolCounterCache implements SymbolCounter {
    private final SymbolCounter symbolCounter;
    private final Map<String,Map<Character,Integer>> cachedValues;
    public SymbolCounterCache(SymbolCounter symbolCounter) {
        this.symbolCounter = symbolCounter;
        cachedValues = new HashMap<>();
    }


    @Override
    public Map<Character,Integer> count(String line) {
        Map<Character,Integer> cachedValue = cachedValues.get(line);

        if (cachedValue != null) {
            return cachedValue;
        }

        cachedValue = symbolCounter.count(line);
        cachedValues.put(line, cachedValue);

        return cachedValue;
    }
}
