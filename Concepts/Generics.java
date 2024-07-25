import java.util.*;

class MyGenerics<T> {
    T data1;
    T data2;

    MyGenerics(T data1, T data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    void get() {
        System.out.println("You entered: " + data1 + " " + data2);
    }
}

public class Generics {
    public static void main(String[] args) {
        MyGenerics<String> m1 = new MyGenerics<>("Libin", "Lavesh");
        m1.get();
        
        MyGenerics<Integer> m2 = new MyGenerics<>(23, 35);
        m2.get();

    }
}
