class Singleton {
    private static volatile Singleton instance; // Double-checked locking

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code here if needed
    }

    // Public static method to get the single instance of the class
    public static Singleton getInstance() {
        // Double-checked locking to ensure thread safety
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) { // Check again inside the synchronized block
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from Singleton instance!");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.showMessage();

        // Attempt to create another instance
        Singleton singleton2 = Singleton.getInstance();
        singleton2.showMessage();

        // Both singleton1 and singleton2 are the same object
        System.out.println(singleton1 == singleton2);
    }
}
