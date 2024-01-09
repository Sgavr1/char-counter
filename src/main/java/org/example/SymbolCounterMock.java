package org.example;

import java.util.HashMap;
import java.util.Map;

public class SymbolCounterMock implements SymbolCounter{
    @Override
    public Map<Character, Integer> count(String line) {
        HashMap<Character, Integer> answer = new HashMap<>();

        answer.put('M',1);
        answer.put('o',1);
        answer.put('c',1);
        answer.put('k',1);

        return answer;
    }
}
