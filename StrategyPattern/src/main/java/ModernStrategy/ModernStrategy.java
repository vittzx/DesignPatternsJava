package ModernStrategy;

import java.util.function.Consumer;

public class ModernStrategy {
    public static void main(String[] args) {
        Double amount = 3.5;
        String PAYMENT_TYPE = "CREDIT_CARD";
        PaymentChosen.valueOf(PAYMENT_TYPE).pay(amount);
    }
}

class PaymentMethods {
    public static void creditCard(double amount){
        // instance class or something else
        System.out.println("Paying: " + amount + " with credit card.");
    }
    public static void bankSlip(double amount){
        System.out.println("Paying: " + amount + " with bank slip.");

    }
    public static void pix(double amount){
        System.out.println("Paying: " + amount + " with pix.");
    }
}

enum PaymentChosen {
    CREDIT_CARD(PaymentMethods::creditCard),BANK_SLIP(PaymentMethods::bankSlip), PIX(PaymentMethods::pix);

    private Consumer<Double> paymentoStrategy;
    PaymentChosen(Consumer<Double> paymentStrategy){
        this.paymentoStrategy = paymentStrategy;
    }

    // Here, its call the method that was used in each Enum Type
    // Aceita um valor, invocando ele
    public void pay(Double amount){
        paymentoStrategy.accept(amount);
    }
}

