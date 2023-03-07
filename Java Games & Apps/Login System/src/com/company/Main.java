package com.company;

public class Main {

    public static void main(String[] args) {

        IDAndPasswords idAndPasswords = new IDAndPasswords();

        new LoginPage(idAndPasswords.getLoginInfo());
    }
}
