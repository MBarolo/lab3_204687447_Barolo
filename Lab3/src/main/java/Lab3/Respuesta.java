package Lab3;
public class Respuesta {
    private int answerId;
    private String answerAuthor;
    private Date answerDate;
    private String content;
    
    public Respuesta(int id, String author, Date date, String content){
        this.answerId = id;
        this.author = author;
        this.answerDate = date;
        this.content = content;
    }
    
    public int getId(){
        return answerId;
    }
    
    public String getAuthor(){
        return answerAuthor;
    }
    
    public Date getDate(){
        return answerDate;
    }
    
    public String getContent(){
        return content;
    }
}
