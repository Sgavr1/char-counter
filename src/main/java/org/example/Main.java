package org.example;

public class Main {
    public static void main(String[] args) {
        SymbolCounter symbolCounter = new SymbolCounterProxy();

        System.out.print(symbolCounter.count("Hello world!"));
    }
}