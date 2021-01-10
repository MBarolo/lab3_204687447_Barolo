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
    
    public int getId(){
        return questionId;
    }
    public int getVotes(){
        return votes;
    }
    public List<Respuesta> getAnswers(){
        return answers;
    }
    public List<Etiqueta> getTags(){
        return tags;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public LocalDate getQuestionDate(){
        return questionDate;
    }
    public String getQuestionAuthor(){
        return questionAuthor;
    }
    public String getStatus(){
        return status;
    }
    public int getReward(){
        return reward;
    }
    /**
     * Retorna el id que deberia tener la ultima pregunta (pregunta a crear)
     * @return el tamaño de la lista de respuestas, ya que al "partir" de 0, este tamaño siempre sera el id de la respuesta
     * siguiente
     */
    public int getIdLastAnswer(){
        if(this.answers.isEmpty())
            return 0;
        else
            return this.answers.size();
        
    }
    
    public void setVotes(int votes){
        this.votes = votes;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
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
