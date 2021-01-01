package Lab3.Controller;
import Lab3.View.*;
import Lab3.Model.*;
public class Controller {
    private Menu menu;
    private Stack stack;
    public Controller(Menu menu, Stack stack){
        this.menu = menu;
        this.stack = stack;
    }
    //RF
    public void register(String username, String password){
        if(stack.checkUserAlreadyExists(username, password)== false){
            stack.addUserToList(username, password);
        }
        else
            menu.userAlreadyExists();
    }
    public void login(String username, String password){
        if(stack.getUsers().isEmpty()){
            menu.zeroUsersRegistered();
        }
        else{
            for (int i = 0; i < stack.getUsers().size(); i++) {
                if(stack.getUsers().get(i).getUsername().equals(username) &&  stack.getUsers().get(i).getPassword().equals(password)){
                    stack.addActiveUser(username);
                    menu.succesfullyLogged();
                    return;
                }
            }
            menu.wrongUserOrPass();
        }
    }
}
