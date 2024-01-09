package org.example;

import java.util.Map;

public class SymbolCounterPrinter {
    public String print(Map<Character,Integer> characters){

        String infoChars = "";

        for (Map.Entry<Character, Integer> c:characters.entrySet()) {
            infoChars += "\"" + c.getKey() + "\" - " + c.getValue() + '\n';
        }

        return infoChars;
    }
}
