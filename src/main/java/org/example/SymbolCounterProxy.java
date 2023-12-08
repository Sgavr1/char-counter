package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolCounterProxy implements SymbolCounter {
    private SymbolCounterImpl symbolCounter;
    private Map<String,Map<Character,Integer>> cache;
    public SymbolCounterProxy() {
        symbolCounter = new SymbolCounterImpl();
        cache = new HashMap<>();
    }


    @Override
    public Map<Character,Integer> count(String line) {
        Map<Character,Integer> answer = cache.get(line);

        if (answer != null) {
            return answer;
        }

        answer = symbolCounter.count(line);
        cache.put(line,answer);

        return answer;
    }
}
