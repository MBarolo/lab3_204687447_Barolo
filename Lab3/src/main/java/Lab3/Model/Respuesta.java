package Lab3.Model;
import java.time.LocalDate;
/**
 * Clase Respuesta, formada por 2 int answerId y votes, que representan el identificador de la respuesta y los votos, respectivamente,
 * dos string answerAuthor y content, que representan el autor de la respuesta y el contenido de esta, respectivamente y
 * un LocalDate answerDate, que representa la fecha de la respuesta
 */
public class Respuesta {
    private final int answerId;
    private int votes;
    private final String answerAuthor;
    private final LocalDate answerDate;
    private final String content;
    private String status;
    
    /**
     * 
     * @param id, Id de la respuesta
     * @param author, String que representa al autor de la respuesta
     * @param content, String que contiene al contenido de la respuesta
     */
    
    public Respuesta(int id, String author, String content){
        this.answerId = id;
        this.votes = 0;
        this.answerAuthor = author;
        this.answerDate = LocalDate.now();
        this.content = content;
        this.status = "No aceptada";
    }
    /**
     * Getter de Id de la respuesta
     * @return El id de la respuesta
     */
    public int getId(){
        return answerId;
    }
    /**
     * Getter de votos de la respuesta
     * @return Los votos de la respuesta
     */
    public int getVotes(){
        return this.votes;
    }
    /**
     * Getter de autor de la respuesta
     * @return El autor de la respuesta
     */
    public String getAuthor(){
        return answerAuthor;
    }
    /**
     * Getter de la fecha de la respuesta
     * @return Fecha de la respuesta
     */
    public LocalDate getDate(){
        return answerDate;
    }
    /**
     * Getter del contenido de la respuesta
     * @return Contenido de la respuesta
     */
    public String getContent(){
        return content;
    }
    /**
     * Getter del estado de la respuesta
     * @return Estado de la respuesta
     */
    public String getStatus(){
        return status;
    }
    /**
     * Setter del estado de la respuesta
     * @param status String que representa el estado de la respuesta, puede ser Aceptada o No aceptada
     */
    public void setStatus(String status){
        this.status = status;
    }
    /**
     * Setter de los votos de la respuesta
     * @param newVotes Int que representa los nuevos votos de la respuesta
     */
    public void setVotes(int newVotes){
        this.votes = newVotes;
    }
}
