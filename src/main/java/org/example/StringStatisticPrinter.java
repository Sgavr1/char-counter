package org.example;

public class StringStatisticPrinter {
    public String print(StringStatistics stringStatistics) {
        if (stringStatistics == null){
            throw new IllegalArgumentException("Argument is null");
        }

        String outString = stringStatistics.getInputString() + "\n";

        for (SymbolInformation symbolInformation : stringStatistics.getSymbols()) {
            outString += "\"" + symbolInformation.getSymbol() + "\" - " + symbolInformation.getCounter() + "\n";
        }

        return outString;
    }
}
