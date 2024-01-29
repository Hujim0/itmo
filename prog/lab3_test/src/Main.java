public class Main {
    public static void main(String[] args) {

        FunctionalInterface inter2 = new Animal()::methodAnimal;

        inter2.func();

    }

    static void method() {

    }

    public static class Test45 {

    }


}

enum test {
    TEST1,
    TEST2;
}


class Manager {
    String name="";
    int puk = 0;

    static Manager instance;

    public Manager() {
        instance = this;
    }
}