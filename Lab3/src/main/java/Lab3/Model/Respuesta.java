package Lab3.Model;

import java.time.LocalDate;

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
    
    public int getId(){
        return answerId;
    }
    public int getVotes(){
        return this.votes;
    }
    public String getAuthor(){
        return answerAuthor;
    }
    
    public LocalDate getDate(){
        return answerDate;
    }
    
    public String getContent(){
        return content;
    }
    
    public String getStatus(){
        return status;
    }
    /**
     * 
     * @param status String que representa el estado de la respuesta, puede ser Aceptada o No aceptada
     */
    public void setStatus(String status){
        this.status = status;
    }
    public void setVotes(int newVotes){
        this.votes = newVotes;
    }
}
