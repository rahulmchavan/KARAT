package com.stocktrade;
 
import java.util.Objects;

class Stock {

    /* Data about a particular stock. */
    String symbol;
    String name;

    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true;

        if (other == null || getClass() != other.getClass())
            return false;

        Stock stock = (Stock) other;

        return symbol.equals(stock.symbol)
                && name.equals(stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name);
    }
}