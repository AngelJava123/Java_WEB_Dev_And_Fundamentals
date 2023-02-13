package com.company.Generics;

public class MyGenericClass<T, V> {

    T x;
    V y;

    MyGenericClass(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public V getValue() {
        return y;
    }

}
