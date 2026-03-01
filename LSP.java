/*
 Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable 
with objects of a subclass without affecting the correctness of the program. In other words, 
if class B is a subclass of class A, then we should be able to replace instances of A with 
instances of B without altering the desirable properties of the program (e.g., correctness, t
ask performed, etc.).
 
Example:
Let's say we have a class called BirdV1 with a method fly(). We can create subclasses like SparrowV1 
that extend BirdV1 and implement the fly() method. According to LSP, we should be able 
to use SparrowV1 and EagleV1 objects wherever BirdV1 objects are expected without any issues.
 
Without LSP: If we have a method that takes a BirdV1 object and calls the fly() method, it would 
work fine for SparrowV1 and EagleV1. However, if we create a new subclass called PenguinV1 that extends
BirdV1 but does not implement the fly() method (since penguins cannot fly), it would violate LSP. 
If we try to use a Penguin object in place of a BirdV1 object, it would lead to unexpected behavior or errors.
 
With LSP: To adhere to LSP, we can design our classes in such a way that all subclasses can be used
interchangeably without causing issues. For example, we can create an interface called Flyable with a 
method fly(), and then have SparrowV1 and EagleV1 implement this interface. The PenguinV1 class would not 
implement Flyable since it cannot fly. This way, we can ensure that all classes that are expected to fly 
can do so without violating LSP.
*/


class LSP {
    public static void main(String[] args) {
        System.out.println("Liskov Substitution Principle (LSP) Example");
        SparrowV1 sparrow1 = new SparrowV1();
        PenguinV1 penguin1 = new PenguinV1();
        SparrowV2 sparrow2 = new SparrowV2();
        // PenguinV2 penguin2 = new PenguinV2(); // This would not compile since 
        // PenguinV2 does not implement Flyable, adhering to LSP
        testFlyV1(sparrow1); // Works fine
        testFlyV1(penguin1); // Throws UnsupportedOperationException, violating LSP
        testFlyV2(sparrow2); // Works fine
        //testFlyV2(penguin2); // Does not compile, adhering to LSP
        NotificationService emailNotification = new EmailNotificationService();
        NotificationService smsNotification = new SMSNotificationService();
        emailNotification.sendNotification("Hello via Email!");
        smsNotification.sendNotification("Hello via SMS!");
        emailNotification.attchFile("file.txt"); // Works fine
        //smsNotification.attchFile("file.txt"); // Throws UnsupportedOperationException, violating LSP
    }

    public static void testFlyV1(BirdV1 bird) {
        bird.fly();
    }

    public static void testFlyV2(Flyable flyableBird) {
        flyableBird.fly();
    }
}

class BirdV1 {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class SparrowV1 extends BirdV1 {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class PenguinV1 extends BirdV1 {
    // Penguins cannot fly, so we do not override the fly() method
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }   
}

interface Flyable {
    void fly();
}

abstract class BirdV2 {
    // Common properties and methods for all birds
}

class SparrowV2 extends BirdV2 implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class PenguinV2 extends BirdV2 {
    // Penguins cannot fly, so we do not implement the Flyable interface
}

class NotificationService {
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }

    public void attchFile(String filePath) {
        System.out.println("Attaching file: " + filePath);
    }
}

class EmailNotificationService extends NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }

    @Override
    public void attchFile(String filePath) {
        System.out.println("Attaching file to email: " + filePath);
    }
}

class SMSNotificationService extends NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }

    @Override
    public void attchFile(String filePath) {
        throw new UnsupportedOperationException("SMS does not support file attachments");
    }
}

