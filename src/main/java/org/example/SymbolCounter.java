package org.example;

import java.util.Map;

public interface SymbolCounter {
    Map<Character,Integer> count(String line);
}
