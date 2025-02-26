package org.example.modern_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ModernObserverPattern {
    public static void main(String[] args) {
        var stockData = new StockData();
        // all business and implementation logic inside the BiConsumer
        stockData.addNotification(
                (stockName, stockPrice) ->   System.out.println("Console notification - stock: " + stockName + " Price: " + stockPrice)
        );
        stockData.addNotification(
                (stockName, stockPrice) ->   System.out.println("Email notification - stock: " + stockName + " Price: " + stockPrice)
        );
        stockData.addNotification(
                (stockName, stockPrice) ->   System.out.println("SMS notification - stock: " + stockName + " Price: " + stockPrice)
        );

        stockData.newStockData("PETR4", 38.00);
        stockData.newStockData("VALE3", 60.00);
    }
}

class StockData {
    private final List<BiConsumer<String, Double>> observers = new ArrayList<>();
    private String stockName;
    private Double stockPrice;

    public void newStockData(String stockName, Double stockPrice){
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void addNotification(BiConsumer<String, Double> observer){
        observers.add(observer);
    }

    public void removeNotification(BiConsumer<String, Double> observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        observers.forEach( observers ->observers.accept(stockName, stockPrice));
    }
}