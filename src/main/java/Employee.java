import java.io.*;

public class Employee {
    public static void main (String args[]){
        SubClass sc = new SubClass();
        SubClass sc2 = new SubClass(200);
    }
}


class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
class SubClass extends SuperClass{
    private int n;

    SubClass(){
        super(300);
        System.out.println("SubClass");
    }

    public SubClass(int n){
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}