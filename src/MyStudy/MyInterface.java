package MyStudy;

public interface MyInterface {

    String name = "jack";

    int age = 12;

    public default void defaultMethod() {
        System.out.println("default 方法；name = " + this.name);
    }

    public void aMethod();



}

class MyInterface1 implements MyInterface {

    @Override
    public void aMethod() {

        // this.name = "jane";
        System.out.println("子类实现父类方法；" + this.name);
    }

    public static void main(String[] args) {
        MyInterface1 m = new MyInterface1();
        m.aMethod();
        m.defaultMethod();
    }
}
