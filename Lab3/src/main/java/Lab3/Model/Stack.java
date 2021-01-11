package Lab3.Model;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase stack, formada por una lista de Pregunta, una lista de Usuario, una lista de Etiqueta y un String usuarioActivo
 */
public class Stack{
    private List<Pregunta> questions;
    private List<Usuario> users;
    private List<Etiqueta> tags;
    private String activeUser;
    
    /**
     * Stack vacio con algunas etiquetas bases
     */
    
    public Stack(){
        this.questions = new ArrayList();
        this.users = new ArrayList();
        this.tags = new ArrayList();
        //Tags base del stack
        tags.add(new Etiqueta("C",": Dedicado para preguntas relacionadas con el lenguaje C."));
        tags.add(new Etiqueta("C++,",": Dedicado para preguntas relacionadas con el lenguaje C++."));
        tags.add(new Etiqueta("C#,",": Dedicado para preguntas relacionadas con el lenguaje C#."));
        tags.add(new Etiqueta("Java,",": Dedicado para preguntas relacionadas con el lenguaje Java."));
        tags.add(new Etiqueta("Python,",": Dedicado para preguntas relacionadas con el lenguaje Python."));
        tags.add(new Etiqueta("Programacion,", ": Dedicado para preguntas relacionadas con programacion"));
        tags.add(new Etiqueta("Teoria,",": Dedicado para preguntas relacionadas con teoria"));
        tags.add(new Etiqueta("Diseño,","Dedicado para preguntas relacionadas con diseño"));
        this.activeUser = "";
    }
    /**
     * Getter de Lista de Pregunta
     * @return Lista de Pregunta
     */
    public List<Pregunta> getQuestions(){
        return questions;
    }
    /**
     * Getter de Lista de Usuario
     * @return Lista de Usuario
     */
    public List<Usuario> getUsers(){
        return users;
    }
    /**
     * Getter de Lista de Etiqueta
     * @return Lista de Etiqueta
     */
    public List<Etiqueta> getTags(){
        return tags;
    }
    /**
     * Getter de Usuario Activo
     * @return String que contiene el usuario activo
     */
    public String getActiveUser(){
        return activeUser;
    }
    /**
     * Getter que retorna el id que debiera tener la ultima pregunta (a añadir)
     * @return Ultimo id (para pregunta a añadir)
     */
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
