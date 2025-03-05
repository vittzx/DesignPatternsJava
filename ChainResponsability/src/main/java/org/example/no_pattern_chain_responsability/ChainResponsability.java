package org.example.no_pattern_chain_responsability;

import java.util.HashMap;
import java.util.Map;

public class ChainResponsability {
}

class Database{
    private final Map<String, String> users;
    public Database(){
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    public boolean isValidUser(String username){
        return users.containsKey(username);
    }

    public boolean isValidPassword(String password){
        return users.containsValue(password);
    }
}