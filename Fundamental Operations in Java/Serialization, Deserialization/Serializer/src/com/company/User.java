package com.company;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1;
    String name;
    String password;

    public void sayHello() {
        System.out.println("Hello " + name);
    }
}
