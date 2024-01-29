public interface FunctionalInterface {

    String name = "";

    void func();

    default void Test() {
        System.out.println("Метод");
    }

    default FunctionalInterface test8() {
        return () -> {

        };
    }
}

