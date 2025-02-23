package common_strategy;

import java.util.Objects;

public class CommonStrategy {
    public static void main(String[] args) {
        // 1 - CreditCard, 2 - BankSlip (Boleto), 3 - PIX
        // Open to extend, and handle dynamically to each context
        Integer paymentMethodChoice = 1;
        Double amount = 3.5;
        PaymentProcessor processor;

        PaymentMethod methodChosen = switch (paymentMethodChoice){
            case 1 -> new CreditCard();
            case 2 -> new BankSlip();
            case 3 -> new Pix();
            default -> throw new IllegalStateException("Payment method not supported.");
        };

        processor = new PaymentProcessor(methodChosen);
        processor.pay(amount);

    }
}

interface PaymentMethod {
    void processInvoice(Double amount);
}

class PaymentProcessor{
    private PaymentMethod paymentMethod;
    public PaymentProcessor(PaymentMethod paymentMethod){ this.paymentMethod = paymentMethod; }

    public void pay(Double amount){
        if (Objects.isNull(amount)) throw new IllegalStateException("Caught error: amount value is null.");
        paymentMethod.processInvoice(amount);
    }
}


class CreditCard implements PaymentMethod {

    @Override
    public void processInvoice(Double amount){
        System.out.println("Paying: " + amount + " with credit card.");
    }
}

class BankSlip implements PaymentMethod{
    @Override
    public void processInvoice(Double amount){
        System.out.println("Paying: " + amount + " with bank slip.");
    }
}

class Pix implements PaymentMethod{
    @Override
    public void processInvoice(Double amount){
        System.out.println("Paying: " + amount + " with PIX.");
    }
}


