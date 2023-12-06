package org.example;

import java.util.*;

public class SymbolCounter {
    private Map<String, StringStatistics> cache;

    public SymbolCounter(){
        cache = new HashMap<>();
    }

    public StringStatistics count(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        if (line.isEmpty()) {
            return new StringStatistics("");
        }

        StringStatistics stringStatistics = cache.get(line);

        if (stringStatistics != null) {
            return stringStatistics;
        }

        stringStatistics = new StringStatistics(line);

        char[] chars = line.toCharArray();

        List<SymbolInformation> symbolInformations = stringStatistics.getSymbols();
        for (char c : chars) {
            boolean isContain = false;

            for (int i = 0; i < symbolInformations.size(); i++) {
                SymbolInformation symbolInformation = symbolInformations.get(i);

                if (symbolInformation.getSymbol() == c) {
                    symbolInformation.setCounter(symbolInformation.getCounter() + 1);
                    isContain = true;

                    break;
                }
            }

            if (!isContain) {
                symbolInformations.add(new SymbolInformation(c));
            }
        }

        cache.put(line, stringStatistics);

        return stringStatistics;
    }
}