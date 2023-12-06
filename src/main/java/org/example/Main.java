package org.example;

public class Main {
    public static void main(String[] args) {
        SymbolCounter symbolCounter = new SymbolCounter();
        StringStatisticPrinter symbolPrinter = new StringStatisticPrinter();

        StringStatistics stringStatistics = symbolCounter.count("qqwsadwedsas");
        System.out.print(symbolPrinter.print(stringStatistics));
    }
}