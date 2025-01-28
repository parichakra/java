interface A{
    void show();
}

interface B {
    void show();
}

class Main implements A,B {
    public void show(){
        System.out.println("Interface A and B");
    }

    public static void main (String [] args ){
        Main m = new Main();
        m.show();
    }
}
