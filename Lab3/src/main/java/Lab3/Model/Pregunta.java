package Lab3.Model;
import java.time.LocalDate;
import java.util.*;
/**
 * Clase Pregunta representa a las preguntas en el stack, contiene un valor questionId identificador, un valor votes votos,
 * una lista de Respuesta respuestas, un String title, un String content, un LocalDate questionDate para la fecha de la pregunta,
 * un String questionAuthor, un String status que indica el estado de la pregunta (cerrada - abierta) y un valor reward.
 */
public class Pregunta {
    private final int questionId;
    private int votes;
    private List<Respuesta> answers;
    private final List<Etiqueta> tags;
    private final String title;
    private final String content;
    private final LocalDate questionDate;
    private final String questionAuthor;
    private String status;
    private int reward;
    
    /**
     * Crea una pregunta
     * @param id Id de la pregunta
     * @param tags Etiqueta de la pregunta
     * @param title Titulo de la pregunta
     * @param content Contenido de la pregunta
     * @param author Autor de la pregunta
     */
    
    public Pregunta(int id, List<Etiqueta> tags, String title, String content, String author){
        this.questionId = id;
        this.votes = 0;
        this.answers = new ArrayList();
        this.tags = tags;
        this.title = title;
        this.content = content;
        this.questionDate = LocalDate.now();
        this.questionAuthor = author;
        this.status = "Abierta";
        this.reward = 0;
    }
    /**
     * Retorna el id de la pregunta
     * @return Id de la pregunta
     */
    public int getId(){
        return questionId;
    }
    /**
     * Retorna los votos de la pregunta
     * @return Votos de la pregunta
     */
    public int getVotes(){
        return votes;
    }
    /**
     * Retorna la lista de respuestas
     * @return Lista de respuestas
     */
    public List<Respuesta> getAnswers(){
        return answers;
    }
    /**
     * Retorna la lista de etiquetas
     * @return Lista de etiquetas
     */
    public List<Etiqueta> getTags(){
        return tags;
    }
    /**
     * Retorna el titulo de la pregunta
     * @return titulo de la pregunta
     */
    public String getTitle(){
        return title;
    }
    /**
     * Retorna el contenido de la preugunta
     * @return Contenido de la pregunta
     */
    public String getContent(){
        return content;
    }
    /**
     * Retorna la fecha de la pregunta
     * @return Fecha de la pregunta
     */
    public LocalDate getQuestionDate(){
        return questionDate;
    }
    /**
     * Retorna el nombre de usuario del autor de la pregunta
     * @return Nombre de usuario del autord de la pregunta
     */
    public String getQuestionAuthor(){
        return questionAuthor;
    }
    /**
     * Retorna el estado de la pregunta
     * @return Estado de la pregunta
     */
    public String getStatus(){
        return status;
    }
    /**
     * Retorna la recompensa de la pregunta
     * @return Recompensa de la pregunta
     */
    public int getReward(){
        return reward;
    }
    /**
     * Retorna el id que deberia tener la ultima pregunta (pregunta a crear)
     * @return el tamaño de la lista de respuestas, ya que al "partir" de 0 la lista, este tamaño siempre sera el id de la respuesta
     * siguiente
     */
    public int getIdLastAnswer(){
        if(this.answers.isEmpty())
            return 0;
        else
            return this.answers.size();
        
    }
    /**
     * Cambia el valor de votos al parametro dado
     * @param votes nuevosVotos
     */
    public void setVotes(int votes){
        this.votes = votes;
    }
    /**
     * Cambia el valor de estado al parametro dado
     * @param status nuevoEstado
     */
    public void setStatus(String status){
        this.status = status;
    }
    /**
     * Cambia el valor de recompensa al parametro dado
     * @param reward nuevaRecompensa
     */
    public void setReward(int reward){
        this.reward = reward;
    }
    /**
     * Agrega una nueva respuesta a la lista de respuestas de la pregunta
     * @param newAnswer Nueva respuesta a ser agregada
     */
    public void addAnswer(Respuesta newAnswer){
        this.answers.add(newAnswer);
    }
}
