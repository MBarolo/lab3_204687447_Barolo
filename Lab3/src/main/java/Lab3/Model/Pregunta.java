package Lab3.Model;
import java.time.LocalDate;
import java.util.*;

public class Pregunta {
    private final int questionId;
    private int votes;
    private List<Respuesta> answers;
    private final List<String> tags;
    private final String title;
    private final String content;
    private final LocalDate questionDate;
    private final String questionAuthor;
    private String status;
    private int reward;
    
    public Pregunta(int id, ArrayList<String> tags, String title, String content, String author){
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
    public List<String> getTags(){
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
    
    public void setVotes(int votes){
        this.votes = votes;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setReward(int reward){
        this.reward = reward;
    }
}
