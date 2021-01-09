package Lab3.Model;
import java.util.ArrayList;
import java.util.List;
public class Stack{
    private List<Pregunta> questions;
    private List<Usuario> users;
    List<Etiquetas> tags;
    private String activeUser;
    
    /**
     * @param questions Lista de Preguntas que contiene las preguntas del stack
     * @param users Lista de Usuraios que contiene los usuarios del stack
     * @param tags Lista de Etiquetas que contiene las etiquetas del stack
     * @param activeUser String que indica el nombre de usuario con sesion iniciada, si existe
     */
    
    public Stack(){
        this.questions = new ArrayList();
        this.users = new ArrayList();
        this.tags = new ArrayList();
        //Tags base del stack
        tags.add(new Etiquetas("C",": Dedicado para preguntas relacionadas con el lenguaje C."));
        tags.add(new Etiquetas("C++,",": Dedicado para preguntas relacionadas con el lenguaje C++."));
        tags.add(new Etiquetas("C#,",": Dedicado para preguntas relacionadas con el lenguaje C#."));
        tags.add(new Etiquetas("Java,",": Dedicado para preguntas relacionadas con el lenguaje Java."));
        tags.add(new Etiquetas("Python,",": Dedicado para preguntas relacionadas con el lenguaje Python."));
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
        for(int i = 0; i < this.users.size();i++){
            if(this.getUsers().get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }
    public void addUserToList(String username, String password){
        Usuario addedUser = new Usuario(username, password);
        this.users.add(addedUser);
    }
    public void setActiveUser(String username){
        this.activeUser = username;
    }
}
