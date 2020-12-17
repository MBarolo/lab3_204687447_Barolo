package Lab3;
public class Respuesta {
    private int id;
    private String author;
    private Date date;
    private String content;
    
    public Respuesta(int id, String author, Date date, String content){
        this.id = id;
        this.author = author;
        this.date = date;
        this.content = content;
    }
    
    public int getId(){
        return id;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getContent(){
        return content;
    }
}
