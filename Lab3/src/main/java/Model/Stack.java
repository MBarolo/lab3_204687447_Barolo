package Model;
import java.util.ArrayList;
import java.util.List;
public class Stack {
    private List<Pregunta> questions;
    private List<Usuario> users;
    private String activeUser;
    
    public Stack(){
        this.questions = new ArrayList();
        this.users = new ArrayList();
        this.activeUser = "";
    }
    
    public List<Pregunta> getQuestions(){
        return questions;
    }
    public List<Usuario> getUsers(){
        return users;
    }
    public String getActiveUser(){
        return activeUser;
    }
    
    //RF
}
