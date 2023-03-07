package com.company;

import java.util.HashMap;
import java.util.Map;

public class IDAndPasswords {

    Map<String, String> loginInfo = new HashMap<>();

    public IDAndPasswords() {

        loginInfo.put("Bro", "pizza");
        loginInfo.put("Angel", "123456");
        loginInfo.put("Honey", "sweet");
    }

    protected Map<String, String> getLoginInfo() {
        return loginInfo;
    }
}
