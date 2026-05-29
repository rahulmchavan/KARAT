package com.stocktrade;
import java.util.ArrayList;

class StockCollection {

    /**
     * Data for a collection of price records
     * for a particular stock.
 
	   * Data for a collection of price records for a particular stock, and methods for
	   * getting useful statistics about the stock's prices.
	   */

    ArrayList<PriceRecord> priceRecords = new ArrayList<>();

    Stock stock;

    StockCollection(Stock stock) {
        this.stock = stock;
    }

    int getNumPriceRecords() {

        /** Returns the number of PriceRecords */

        return priceRecords.size();
    }

    void addPriceRecord(PriceRecord priceRecord) {

        /** Adds a PriceRecord */

        if (!priceRecord.stock.equals(this.stock)) {

            throw new IllegalArgumentException(
                    "PriceRecord's Stock is not same as StockCollection's Stock");
        }

        priceRecords.add(priceRecord);
    }

    int getMaxPrice() {

        /** Returns maximum price */

        if (priceRecords.isEmpty()) {
            return -1;
        }

        return priceRecords.stream()
                .mapToInt(record -> record.price)
                .max()
                .getAsInt();
    }

    int getMinPrice() {

        /** Returns minimum price */

        if (priceRecords.isEmpty()) {
            return -1;
        }

        return priceRecords.stream()
                .mapToInt(record -> record.price)
                .min()
                .getAsInt();
    }

    double getAvgPrice() {

        /** Returns average price */

        if (priceRecords.isEmpty()) {
            return -1.0;
        }

        double total = priceRecords.stream()
                .mapToInt(record -> record.price)
                .sum();

        return total / priceRecords.size();
    }
}