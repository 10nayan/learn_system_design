// KISS - Keep It Simple, Stupid
// YAGNI - You Ain't Gonna Need This
// DRY - Don't Repeat Yourself

public class Introduction {
    public static void main(String[] args) {
        System.out.println("Introduction to OOP in Java");
        AreaCalculatorV1.calculate();
        double area1 = AreaCalculatorV2.calculate(10, 5);
        System.out.println("Area: " + area1);
        double area2 = AreaCalculatorV2.calculate(20, 10);
        System.out.println("Area: " + area2);
        int number = 4;
        boolean isEven1 = IsNumberEvenV1.isEven(number);
        System.out.println(number + " is even: " + isEven1);
        boolean isEven2 = IsNumberEvenV2.isEven(number);
        System.out.println(number + " is even: " + isEven2);
        InvoiceV1 invoice1 = new InvoiceV1("John Doe", 100.0);
        invoice1.printInvoice();
        InvoiceV2 invoice2 = new InvoiceV2("Jane Doe", 200.0);
        invoice2.printInvoice();
    }
}

/*
Class AreaCalculatorV1 is not following the DRY principle as it has duplicate code for calculating area.
*/
class AreaCalculatorV1{
    public static void calculate(){
        int length1 = 10;
        int breath1 = 5;
        double area1 = length1 * breath1;
        System.out.println("Area: " + area1);
        int length2 = 20;
        int breath2 = 10;
        double area2 = length2 * breath2;
        System.out.println("Area: " + area2);
    }
}

/*
Class AreaCalculatorV2 is following the DRY principle as it has a single method to calculate area, which 
can be reused for different length and breath values.
*/
class AreaCalculatorV2{
    public static double calculate(int length, int breath){
        return length * breath;
    }
}

/*
Class IsNumberEvenV1 is not following the KISS principle as it has unnecessary code to determine
if a number is even or not. It can be simplified to a single line of code.
*/
class IsNumberEvenV1{
    public static boolean isEven(int number){
        boolean isEven;
        if(number % 2 == 0){
            isEven = true;
        }
        else{
            isEven = false;
        }
        return isEven;
    }
}

/*
Class IsNumberEvenV2 is following the KISS principle as it has a simple and straightforward
implementation to determine if a number is even or not.
*/
class IsNumberEvenV2{
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}

/*
Class InvoiceV1 is not following the YAGNI principle as it has a getter method for customerName
which is not being used anywhere in the code.
*/
class InvoiceV1{
    private String customerName;
    private double amount;

    public InvoiceV1(String customerName, double amount){
        this.customerName = customerName;
        this.amount = amount;
    }
    public String getCustomerName(){
        return customerName;
    }

    public void printInvoice(){
        System.out.println("Customer Name: " + customerName);
        System.out.println("Amount: " + amount);
    }
}

/*
Class InvoiceV2 is following the YAGNI principle as it does not have any unnecessary code
and only contains the necessary code to print the invoice details.
*/
class InvoiceV2{
    private String customerName;
    private double amount;

    public InvoiceV2(String customerName, double amount){
        this.customerName = customerName;
        this.amount = amount;
    }

    public void printInvoice(){
        System.out.println("Customer Name: " + customerName);
        System.out.println("Amount: " + amount);
    }
}





