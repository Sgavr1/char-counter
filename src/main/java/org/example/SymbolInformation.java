package org.example;

public class SymbolInformation {
    private char symbol;
    private int counter;

    public SymbolInformation(char symbol) {
        this.symbol = symbol;
        counter = 1;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
