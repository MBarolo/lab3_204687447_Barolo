package Lab3.Model;

import java.time.LocalDate;

public class Respuesta {
    private final int answerId;
    private final String answerAuthor;
    private final LocalDate answerDate;
    private final String content;
    private String status;
    
    /**
     * 
     * @param answerId Valor que indica el identificador de la respuesta
     * @param answerAuthor String que indica el nombre de usuario del autor de la respuesta
     * @param answerDate Variable que indica la fecha de cuando se creo la respuesta
     * @param content String que indica el contenido de la respuesta
     * @param status String que representa el estado de la respuesta
     */
    
    public Respuesta(int id, String author, String content){
        this.answerId = id;
        this.answerAuthor = author;
        this.answerDate = LocalDate.now();
        this.content = content;
        this.status = "No aceptada";
    }
    
    public int getId(){
        return answerId;
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
    
    public void setStatus(String status){
        this.status = status;
    }
}
