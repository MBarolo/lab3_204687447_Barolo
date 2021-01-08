package Lab3.Model;
import java.util.ArrayList;
import java.util.List;
public class Stack{
    private List<Pregunta> questions;
    private List<Usuario> users;
    List<Etiquetas> tags;
    private String activeUser;
    
    public Stack(){
        this.questions = new ArrayList();
        this.users = new ArrayList();
        this.tags = new ArrayList();
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
    public int getIdLastQuestion(){
        if(this.questions.isEmpty()){
            return 0;
        }
        else
            return this.questions.size();
    }
    public boolean checkUserAlreadyExists(String username, String password){
        for(int i = 0; i < this.getUsers().size();i++){
            if(this.getUsers().get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }
    public void addUserToList(String username, String password){
        Usuario addedUser = new Usuario(username, password);
        this.getUsers().add(addedUser);
    }
    public void setActiveUser(String username){
        this.activeUser = username;
    }
}
