package Lab3.Controller;
import java.util.List;
import Lab3.View.*;
import Lab3.Model.*;
/**
 * Clase controller, que opera un stack y el menu de ese stack.
 */
public class Controller {
    private final Menu menu;
    private final Stack stack;
    /**
     * Crea un controlador para operar a los parametros dados
     * @param menu menu controlado por controlador
     * @param stack stack controlado por controlador
     */
    public Controller(Menu menu, Stack stack){
        this.menu = menu;
        this.stack = stack;
    }
   
    //RF
    /**
     * registra un nuevo usuario en el stack, si no existe ya
     * @param username nombre de usuario nuevo
     * @param password contraseña de usuario nuevo
     */
    public void register(String username, String password){
        if(stack.checkUserAlreadyExists(username, password)== false){
            stack.addUserToList(username, password);
        }
        else
            menu.showMessage("El usuario ya existe");
    }
    /**
     * Inicia sesion en el stack, si existe el usuario
     * @param username nombre de usuario a iniciar sesion
     * @param password contraseña de usuario a iniciar sesion
     */
    public void login(String username, String password){
        if(stack.getUsers().isEmpty()){
            menu.showMessage("No existen usuarios registrados");
        }
        else{
            for (int i = 0; i < stack.getUsers().size(); i++) {
                if(stack.getUsers().get(i).getUsername().equals(username) &&  stack.getUsers().get(i).getPassword().equals(password)){
                    stack.setActiveUser(username);
                    menu.showMessage("Sesion iniciada");
                    return;
                }
            }
            menu.showMessage("Usuario o contraseña incorrectos");
        }
    }
    /**
     * Cierra sesion iniciada, si existe
     */
    public void logout(){
        if(stack.getActiveUser().equals("")){
            menu.showMessage("No hay usuario con sesion iniciada");
        }
        else{
            menu.showMessage("Sesion cerrada");
            stack.setActiveUser("");
        }
    }
    /**
     * Añade una pregunta a la lista de preguntas del stack
     * @param title String que indica el titulo de la pregunta
     * @param content String que indica el contenido de la pregunta
     * @param tags  Lista de Etiquetas que indica las etiquetas escogidas para la pregunta
     */
    public void ask(String title, String content, List<Etiqueta> tags){
        Pregunta newQuestion = new Pregunta(stack.getIdLastQuestion(), tags, title, content, stack.getActiveUser());
        stack.getQuestions().add(newQuestion);
    }
    /**
     * Añade una respuesta a la pregunta con id dado
     * @param answer String que contiene la respuesta
     * @param questionId Id de la pregunta a responder
     */
    public void answer(String answer, int questionId){
        boolean searchCondition = true;
        int idNewAnswer = -1;
        int i = 0;
        while(searchCondition){
            if(stack.getQuestions().get(i).getId() == questionId){
                idNewAnswer = stack.getQuestions().get(i).getIdLastAnswer();
                searchCondition = false;
            }
            else
                i = i + 1; 
        }
        if (idNewAnswer!=-1){
        Respuesta newAnswer = new Respuesta(idNewAnswer,stack.getActiveUser(), answer);
        stack.getQuestions().get(i).addAnswer(newAnswer);
        }
        else
            menu.showMessage("Pregunta no encontrada");
    }
    /**
     * Añade una recompensa a la pregunta dada, en caso de tener ya recompensa el valor se añade
     * @param id id de la pregunta a recompensar
     * @param reward valor de la recompensa
     */
    public void reward(int id, int reward){
        if(stack.getQuestions().get(id).getStatus().equals("Abierta")){
            int repUser = 0;
            for(int i = 0; i<stack.getUsers().size();i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getActiveUser())){
                    repUser = stack.getUsers().get(i).getReputation();
                    if(repUser>reward){
                        stack.getUsers().get(i).setReputation(repUser-reward);
                        stack.getQuestions().get(id).setReward(reward);
                        return;
                    }
                    else{
                        menu.showMessage("No tienes suficiente reputacion para ofrecer el reward");
                        return;
                    }
                }
            }
        }
        else
            menu.showMessage("Pregunta cerrada, no puede realizarse el reward");
    }
    /**
     * Metodo que acepta la respuesta de la pregunta especificada, cambia el estado a aceptada, el estado de la pregunta a cerrada y reparte la reputacion a quien corresponda
     * @param questionId id de la pregunta donde se encuentra la respuesta a aceptar
     * @param answerId id de la respuesta a aceptar
     */
    public void accept(int questionId, int answerId){
        if(stack.getQuestions().get(questionId).getStatus().equals("Abierta") && questionId<=stack.getQuestions().size() && answerId<=stack.getQuestions().get(questionId).getAnswers().size() && stack.getQuestions().get(questionId).getQuestionAuthor().equals(stack.getActiveUser())){
            for(int i = 0; i<stack.getUsers().size();i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getQuestions().get(questionId).getAnswers().get(answerId).getAuthor())){
                    stack.getUsers().get(i).setReputation(stack.getQuestions().get(questionId).getReward() + stack.getUsers().get(i).getReputation() + 15);
                    stack.getQuestions().get(questionId).setStatus("Cerrada");
                    stack.getQuestions().get(questionId).setReward(0);
                    stack.getQuestions().get(questionId).getAnswers().get(answerId).setStatus("Aceptada");  
                }
                if(stack.getUsers().get(i).getUsername().equals(stack.getActiveUser())){
                    stack.getUsers().get(i).setReputation(stack.getUsers().get(i).getReputation() + 2);
                }
            }
        }
        else
            menu.showMessage("Pregunta cerrada, pregunta o respuesta inexistentes, o usuario activo no es autor de la pregunta");
    }
    /**
     * Hace un voto positivo o negativo a una pregunta
     * @param questionId Id de la pregunta a votar
     * @param vote tipo de voto, 1 positivo, 0 negativo
     */
    public void vote(int questionId, int vote){
        if(vote == 1 && !stack.getQuestions().get(questionId).getQuestionAuthor().equals(stack.getActiveUser())){
            stack.getQuestions().get(questionId).setVotes(1 + stack.getQuestions().get(questionId).getVotes());
            for(int i = 0; i<stack.getUsers().size(); i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getQuestions().get(questionId).getQuestionAuthor())){
                    stack.getUsers().get(i).setReputation(10 + stack.getUsers().get(questionId).getReputation());
                }
            }
        }
        else if(vote == 0 && !stack.getQuestions().get(questionId).getQuestionAuthor().equals(stack.getActiveUser())){
            stack.getQuestions().get(questionId).setVotes(stack.getQuestions().get(questionId).getVotes() - 1);
            for(int i = 0; i<stack.getUsers().size();i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getQuestions().get(questionId).getQuestionAuthor()))
                    stack.getUsers().get(i).setReputation(stack.getUsers().get(i).getReputation() - 2);
            }
        }
        else
            menu.showMessage("Voto invalido, o id de pregunta/respuesta entregado pertenece al usuario activo");     
    }
    
    
    /**
     * Hace un voto positivo o negativo a la respuesta de una pregunta
     * @param questionId Id donde se encuentra la respuesta a votar
     * @param answerId Id de la respuesta a votar
     * @param vote tipo de voto
     */
    public void vote(int questionId, int answerId,int vote){
        if(vote == 1 && !stack.getQuestions().get(questionId).getAnswers().get(answerId).getAuthor().equals(stack.getActiveUser())){
            stack.getQuestions().get(questionId).getAnswers().get(answerId).setVotes(1 + stack.getQuestions().get(questionId).getAnswers().get(answerId).getVotes());
            for(int i = 0; i<stack.getUsers().size(); i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getQuestions().get(questionId).getAnswers().get(answerId).getAuthor())){
                    stack.getUsers().get(i).setReputation(10 + stack.getUsers().get(i).getReputation());
                }
            }
        }
        else if(vote == 0 && !stack.getQuestions().get(questionId).getAnswers().get(answerId).getAuthor().equals(stack.getActiveUser())){
            stack.getQuestions().get(questionId).getAnswers().get(answerId).setVotes(stack.getQuestions().get(questionId).getAnswers().get(answerId).getVotes() - 1);
            for(int i = 0; i<stack.getUsers().size();i++){
                if(stack.getUsers().get(i).getUsername().equals(stack.getActiveUser())){
                    stack.getUsers().get(i).setReputation(stack.getUsers().get(i).getReputation() -1);
                }
                if(stack.getUsers().get(i).getUsername().equals(stack.getQuestions().get(questionId).getAnswers().get(answerId).getAuthor()))
                    stack.getUsers().get(i).setReputation(stack.getUsers().get(i).getReputation() - 2);
            }
        }
        else
            menu.showMessage("Voto invalido, o id de pregunta/respuesta entregado pertenece al usuario activo");    
    }
}
