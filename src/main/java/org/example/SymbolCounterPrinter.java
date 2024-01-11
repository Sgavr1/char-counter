package org.example;

import java.util.Map;

public class SymbolCounterPrinter {
    public String print(Map<Character,Integer> characters){

        if(characters == null){
            throw new IllegalArgumentException("Argument is Null");
        }

        String infoChars = "";

        for (Map.Entry<Character, Integer> c:characters.entrySet()) {
            infoChars += "\"" + c.getKey() + "\" - " + c.getValue() + '\n';
        }

        return infoChars;
    }
}
