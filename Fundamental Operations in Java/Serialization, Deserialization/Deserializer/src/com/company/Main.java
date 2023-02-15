package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Steps to Deserialize
        // 1. Declare your object (Do not instantiate)
        // 2. Your class should implement Serializable interface
        // 3. Add import java.io.Serializable;
        // 4. FileInputStream fileIn = new FileInputStream(file path);
        // 5. ObjectInputStream in = new ObjectInputStream(fileIn);
        // 6. ObjectName = (Class) in.readObject();
        // 7. in.close(); fileIn.close();

        User user = null;
        FileInputStream fileIn = new FileInputStream("C:\\Users\\tasheva\\IdeaProjects\\Serializer\\src\\com\\company\\UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();
    }
}
