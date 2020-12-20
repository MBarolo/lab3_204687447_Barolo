package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private final int questionId;
    private int votes;
    private List<Respuesta> answers;
    private List<String> tags;
    private String title;
    private String content;
    private Date questionDate;
    private String questionAuthor;
    private String status;
    private int reward;
    
    public Pregunta(int id, List<String> tags, String title, String content, Date questionDate, String author){
        this.questionId = id;
        this.votes = 0;
        this.answers = new ArrayList();
        this.tags = tags;
        this.title = title;
        this.content = content;
        this.questionDate = questionDate;
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
    public Date getQuestionDate(){
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
    
    public void modifyVotes(int votes){
        this.votes = votes;
    }
}
