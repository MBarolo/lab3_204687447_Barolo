package Lab3.Model;
import java.util.ArrayList;
import java.util.List;
public class Stack{
    private List<Pregunta> questions;
    private List<Usuario> users;
    private List<Etiquetas> tags;
    private String activeUser;
    
    /**
     * Stack vacio con etiquetas bases
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
    public List<Etiquetas> getTags(){
        return tags;
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
    /**
     * Verifica si el nombre de usuario entregado esta registrado en el stack
     * @param username String que representa el nuevo nombre de usuario
     * @param password String que representa la nueva contraseña
     * @return true o false dependiendo si el nombre de usuario dado existe o no
     */
    public boolean checkUserAlreadyExists(String username, String password){
        for(int i = 0; i < this.users.size();i++){
            if(this.getUsers().get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }
    /**
     * Añade un usuario a la lista de usuarios del stack
     * @param username String que representa el nuevo nombre de usuario
     * @param password String que representa la contraseña del nuevo nombre de usuario
     */
    public void addUserToList(String username, String password){
        Usuario addedUser = new Usuario(username, password);
        this.users.add(addedUser);
    }
    /**
     * Settea el nombre de usuario entregado como usuario activo
     * @param username String que representa nombre de usuario activo
     */
    public void setActiveUser(String username){
        this.activeUser = username;
    }
}
