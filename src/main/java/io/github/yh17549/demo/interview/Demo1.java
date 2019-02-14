package io.github.yh17549.demo.interview;

/**
 * @author xyh
 * @date 2019-02-14
 */
public class Demo1 {

    public static void main(String[] args){
        // A B a b
        A a = new B();

        // a b
        a = new B();

        // a b
        B b = new B();
    }

}

class A {
    static {
        System.out.println("A");
    }
    public A(){
        System.out.println("a");

    }
}

class B  extends  A{
    static {
        System.out.println("B");
    }
    public B(){
        System.out.println("b");

    }
}
