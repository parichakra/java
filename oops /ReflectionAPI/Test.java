import java.lang.reflect.*;

class Demo {
    private String msg;

    Demo() {
        this.msg = "New Message";
    }

    public void Method1() {
        System.out.println("I am public and void, I need no argument");
    }

    public int Method2() {
        int number = 42; // Define the variable
        return number;
    }

    private void method3() {
        System.out.println("Private msg = " + this.msg);
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        Demo obj = new Demo();

        // Get the class object
        Class<?> cls = obj.getClass();

        System.out.println("The name of the class = " + cls.getName());

        // Get the parent class (superclass)
        Class<?> parent = cls.getSuperclass();
        System.out.println("Parent class = " + parent.getName());

        // Invoke public method
        Method m1 = cls.getDeclaredMethod("Method1");
        m1.invoke(obj);

        // Access and modify private field
        Field f = cls.getDeclaredField("msg");
        f.setAccessible(true);
        f.set(obj, "Hello everyone");

        // Access and invoke private method
        Method m3 = cls.getDeclaredMethod("method3");
        m3.setAccessible(true);
        m3.invoke(obj);

        // Access and print constructors
        Constructor<?>[] constructors = cls.getConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
