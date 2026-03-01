/*
The Interface Segregation Principle (ISP) is one of the SOLID principles of object-oriented design. 
It states that clients should not be forced to depend on interfaces they do not use. In other words, 
a class should not be required to implement interfaces that it does not need.

The main idea behind ISP is to create smaller, more specific interfaces rather than large, general 
ones. This allows classes to implement only the methods that are relevant to their functionality, 
leading to better modularity and easier maintenance.

Example:
Let's say we have an interface called MultiFunctionalDevice that has methods for printing, scanning, 
and faxing. If we have a class that only needs to print documents, it should not be forced to implement
the scanning and faxing methods.

Without ISP: We might have one interface with methods for printing, scanning, and faxing. This would 
require classes that only need to print to implement the scanning and faxing methods, which can lead 
to confusion and maintenance issues.

With ISP: We can create three separate interfaces: Printable for printing, Scannable for scanning, 
and Faxable for faxing. Classes that only need to print can implement the Printable interface without 
being forced to implement the Scannable and Faxable interfaces, adhering to the Interface Segregation 
Principle.
*/

public class ISP {
    public static void main(String[] args) {
        System.out.println("Interface Segregation Principle (ISP) Example");
    }
}

interface MultiFunctionalDevice {
    void print();
    void scan();
    void fax();
}

class MultiFunctionalPrinter implements MultiFunctionalDevice {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Faxing not supported");
    }
}

interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

class SimplePrinter implements Printable {
    @Override
    public void print() {
        System.out.println("Printing...");
    }
}

class AllInOnePrinter implements Printable, Scannable, Faxable {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing...");
    }
}
