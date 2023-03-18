package MyStudy;

public abstract class MyAbstract {

    String name ;

    int age = 12;

    public MyAbstract() {
        this.name = "jack";
        System.out.println("父类构造方法；");
    }

    public abstract void aMethod();

    public void bMethod() {
        System.out.println("普通方法");
    }

}


class SonClass extends MyAbstract{
    @Override
    public void aMethod() {
        this.name = "tom";

        System.out.println("子类实现抽象方法,name = " + this.name);
    }

    public static void main(String[] args) {
        SonClass sonClass = new SonClass();
        sonClass.aMethod();
    }
}