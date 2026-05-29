package com.stocktrade;
class PriceRecord {

    /** Data and methods about a single price record of a stock. */

    Stock stock;
    int price;
    String date;

    PriceRecord(Stock stock, int price, String date) {
        this.stock = stock;
        this.price = price;
        this.date = date;
    }
}