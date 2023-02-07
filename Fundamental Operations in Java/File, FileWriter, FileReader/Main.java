package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // file = An abstract representation of file and directory pathname

        // FileReader = read the contents of a file as a stream of characters. One by one
        //              read() returns an int value, which contains the byte value
        //              when read() returns -1, there is no data to be read.

        File file = new File("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\Example.txt");
        FileWriter writer = new FileWriter("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\Example.txt");
        FileReader reader = new FileReader("C:\\Users\\tasheva\\IdeaProjects\\Additional_Problems\\src\\com\\company\\Example.txt");

        if (file.exists()) {
            System.out.println("That file exists");
            System.out.println(file.getPath());
            System.out.println(file.isFile());
            // file.delete();
        } else {
            System.out.println("That file does not exist");
        }

        writer.write("Roses are red \nViolets are blue \nThe weather is great \nMy sadness fade");
        writer.append("\n(A poem by Angel)");
        writer.close();

        int data = reader.read();
        while (data != -1) {
            System.out.print((char) (data));
            data = reader.read();
        }
    }
}
