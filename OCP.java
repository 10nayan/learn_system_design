/*
Open/Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) 
should be open for extension but closed for modification. This means that you should be able to 
add new functionality to a class without changing its existing code.

In Java, you can achieve this by using interfaces, abstract classes, or inheritance. The idea 
is to design your classes in such a way that they can be extended without modifying their existing
behavior.
 
Example:
Let's say we have a class that process payments. Initially, we might have a 
method that processes credit card payments. If we want to add support for processing PayPal payments, 
we should not modify the existing method; instead, we can create new classes that extend the functionality.

Without OCP: We might have a single class with methods for processing different types of payments. 
This would require modifying the existing class every time we want to add support for a new payment method, 
which can lead to bugs and maintenance issues.

With OCP: We can create an interface called PaymentMethod with a method processPayment(). Then, we can create 
separate classes for each payment method (e.g., CreditCardPaymentMethod, PayPalPaymentMethod) that implement 
the PaymentMethod interface. This way, we can add new payment methods without modifying the existing code, 
adhering to the Open/Closed Principle.
*/
public class OCP {
    public static void main(String[] args) {
        System.out.println("Open/Closed Principle (OCP) Example");
    }    
}

class PaymentMethodV1 {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            // Process credit card payment
        } else if (paymentType.equals("PayPal")) {
            // Process PayPal payment
        }
        // Adding new payment types would require modifying this class, which violates OCP
    }
}

interface PaymentMethod {
    void processPayment();
}

class CreditCardPaymentMethod implements PaymentMethod {
    @Override
    public void processPayment() {
        // Process credit card payment
    }
}

class PayPalPaymentMethod implements PaymentMethod {
    @Override
    public void processPayment() {
        // Process PayPal payment
    }
}

class PaymentProcessorV2 {
    private PaymentMethod paymentMethod;

    public PaymentProcessorV2(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process() {
        paymentMethod.processPayment();
    }
}


