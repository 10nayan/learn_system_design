public final class Singleton {
    // Private static instance variable to hold the single instance of the class
    private static final Singleton instance = new Singleton();

    // Make the constructor private to prevent instantiation from outside the class
    private Singleton() {}

    // Provide a public static method that returns the single instance of the class
    public static Singleton getInstance() {
        return instance;
    }

    // Example method
    public void doSomething() {
        System.out.println("Doing something...");
    }
}