package Lab3.Model;
import java.time.LocalDate;
import java.util.*;

public class Pregunta {
    private final int questionId;
    private int votes;
    private List<Respuesta> answers;
    private final List<Etiquetas> tags;
    private final String title;
    private final String content;
    private final LocalDate questionDate;
    private final String questionAuthor;
    private String status;
    private int reward;
    
    /**
     * Clase usuario
     * @param questionId El identificador de la pregunta
     * @param votes Valor que indica los votos de la pregunta
     * @param answers Lista que contiene las respuestas del usuario
     * @param tags Lista que contiene las tags de la pregunta
     * @param title String que representa el titulo de la pregunta
     * @param content String que representa el contenido de la pregunta
     * @param questionDate Variable que contiene la fecha en cuando se hizo la pregunta
     * @param questionAuthor String que indica el nombre de usuario del autor de la pregunta
     * @param status String que representa el estado de la pregunta
     * @param reward Valor que indica el valor de recompensa de la pregunta
    */
    
    public Pregunta(int id, List<Etiquetas> tags, String title, String content, String author){
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
    public List<Etiquetas> getTags(){
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
    public int getIdLastAnswer(){
        if(this.answers.isEmpty())
            return 0;
        else
            return this.answers.size() - 1;
        
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
    public void addAnswer(Respuesta newAnswer){
        this.answers.add(newAnswer);
    }
}
