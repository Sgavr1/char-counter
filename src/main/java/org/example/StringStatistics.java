package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringStatistics {
    private String inputString;
    private List<SymbolInformation> symbols;

    public StringStatistics(String inputString) {
        this.inputString = inputString;
        symbols = new ArrayList<>();
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public List<SymbolInformation> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<SymbolInformation> symbols) {
        this.symbols = symbols;
    }
}