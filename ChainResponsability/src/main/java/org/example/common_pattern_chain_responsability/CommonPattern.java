package org.example.common_pattern_chain_responsability;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommonPattern {
    public static void main(String[] args) {
        Database database = new Database();
        BaseHandler handleRoleChecker = new RoleCheckerHandler();
        BaseHandler handlerPassword = new ValidPasswordHandler(database).setNext(handleRoleChecker);
        BaseHandler handlerUser = new UserExistsHandler(database).setNext(handlerPassword);
        BaseHandler handler = handlerUser;

        AuthService authorizationService = new AuthService(handler);
        authorizationService.logIn("admin_username", "admin_password");
        authorizationService.logIn("not_exist", "not_exist");
    }
}

class Database{
    private final Map<String, String> users;
    public Database(){
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    public boolean isUsernameInvalid(String username){
        return !users.containsKey(username);
    }

    public boolean isPasswordInvalid(String password){

        return !users.containsValue(password);
    }
}

abstract class BaseHandler implements Handler{
    private BaseHandler next;

    public BaseHandler setNext(BaseHandler next){
        this.next = next;
        return this;
    }

    protected boolean handleNext(String username, String password){
        return Objects.isNull(next) || next.handle(username, password);
    }
}

interface Handler{
    boolean handle(String username, String password);
}

class UserExistsHandler extends BaseHandler{
    private final Database database;

    public UserExistsHandler(Database database){ this.database = database; }

    @Override
    public boolean handle(String username, String password){
        if(database.isUsernameInvalid(username)){
            System.out.println("Username not valid!!");
            return false;
        }
        System.out.println("Username valid!!");
        return handleNext(username, password);
    }
}

class ValidPasswordHandler extends BaseHandler{
    private final Database database;

    public ValidPasswordHandler(Database database){ this.database = database; }

    @Override
    public boolean handle(String username, String password){
        if(database.isPasswordInvalid(password)){
            System.out.println("Password not valid!!");
            return false;
        }
        System.out.println("Password valid!!");
        return handleNext(username, password);
    }
}


class RoleCheckerHandler extends BaseHandler{

    @Override
    public boolean handle(String username, String password){
        if("admin_username".equals(username)){
            System.out.println("Redirecting to admin_page!");
            return true;
        }
        System.out.println("Redirecting to user_default_page!");
        return handleNext(username, password);
    }
}

class AuthService {
    private final BaseHandler handler;

    public AuthService(BaseHandler handler){
        this.handler = handler;
    }

    public boolean logIn(String username, String password){
        if(handler.handle(username, password)) {
            System.out.println("Authorization is succeed");
            return true;
        }
        return false;
    }
}

