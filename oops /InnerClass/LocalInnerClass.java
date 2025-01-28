class OuterClass {
    void method() {
        class localls {
            void display() {
                System.out.println("Hello from LocalInnerClass");
            }
        }

        localls localInner = new localls();
        localInner.display();
    }
}

public class LocalInnerClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.method();
    }
}
