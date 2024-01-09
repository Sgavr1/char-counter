package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolCounterProxy implements SymbolCounter {
    private final SymbolCounter symbolCounter;
    private final Map<String,Map<Character,Integer>> cachedValue;
    public SymbolCounterProxy(SymbolCounter symbolCounter) {
        this.symbolCounter = symbolCounter;
        cachedValue = new HashMap<>();
    }


    @Override
    public Map<Character,Integer> count(String line) {
        Map<Character,Integer> answer = cachedValue.get(line);

        if (answer != null) {
            return answer;
        }

        answer = symbolCounter.count(line);
        cachedValue.put(line, answer);

        return answer;
    }
}
