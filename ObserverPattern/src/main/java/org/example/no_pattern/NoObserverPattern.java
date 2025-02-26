package org.example.no_pattern;

public class NoObserverPattern {
    public static void main(String[] args) {
        StockData stockData = new StockData();
        stockData.updateStock("PETR4", 38.00);
        stockData.updateStock("VALE3", 60.00);
    }
}

class StockData{

    public void updateStock(String stock, Double stockPrice){
        System.out.println("Console notification - stock: " + stock + " Price: " + stockPrice);
        System.out.println("Email notification - stock: " + stock + " Price: " + stockPrice);
        System.out.println("SMS notification - stock: " + stock + " Price: " + stockPrice);
    }
}