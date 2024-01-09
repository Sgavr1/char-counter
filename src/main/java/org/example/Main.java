package org.example;

public class Main {
    public static void main(String[] args) {
        SymbolCounter symbolCounter = new SymbolCounterProxy(new SymbolCounterImpl());

        System.out.print(new SymbolCounterPrinter().print(symbolCounter.count("Hello world!")));
    }
}