package org.example.common_observer;

import java.util.ArrayList;
import java.util.List;

public class CommonObserverPattern {
    public static void main(String[] args) {
        var stockData = new StockData();

        var consoleNotification = new ConsoleNotification();
        var emailNotification = new EmailNotification();
        var smsNotification = new SMSNotification();

        stockData.addNotification(consoleNotification);
        stockData.addNotification(emailNotification);
        stockData.addNotification(smsNotification);

        stockData.newStockData("PETR4", 38.00); // here should receive class Stock, that receives stockName and stockPrice
        stockData.newStockData("VALE3", 60.00);
    }
}

interface Observer {
    void update(String stockName, Double stockPrice);
}

class ConsoleNotification implements Observer{
    @Override
    public void update(String stockName, Double stockPrice){
        System.out.println("Console notification - stock: " + stockName + " Price: " + stockPrice);
    }
}

class EmailNotification implements Observer{
    @Override
    public void update(String stockName, Double stockPrice){
        System.out.println("Email notification - stock: " + stockName + " Price: " + stockPrice);
    }
}


class SMSNotification implements Observer{
    @Override
    public void update(String stockName, Double stockPrice){
        System.out.println("SMS notification - stock: " + stockName + " Price: " + stockPrice);
    }
}

class StockData {
    private final List<Observer> observers = new ArrayList<>();
    private String stockName;
    private Double stockPrice;

    public void newStockData(String stockName, Double stockPrice){
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void addNotification(Observer observer){
        observers.add(observer);
    }

    public void removeNotification(Observer observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        for (Observer o: observers){
            o.update(stockName, stockPrice);
        }
    }
}

