package org.example.no_pattern;

public class NoStrategyPayment {

    public static void main(String[] args) {

        int paymentType = 1;
        Double amount = 3.5;

        if (paymentType == 1) {
            System.out.println("Credit card selected to invoice payment");
            redirectOrDoSomethingElse(amount);
        } else if (paymentType == 2) {
            System.out.println("Bar code selected to invoice payment");
            redirectOrDoSomethingElse(amount);
        } else if (paymentType == 3) {
            System.out.println("PIX selected to invoice payment");
            redirectOrDoSomethingElse(amount);
        } else {
            throw new IllegalStateException("Not possible process ");
        }
    }


    private static void redirectOrDoSomethingElse(Double amount) { } // redirectOrDoSomethingElse to spefic area with specific business rules

}