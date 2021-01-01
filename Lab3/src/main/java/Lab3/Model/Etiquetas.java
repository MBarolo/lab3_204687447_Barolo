package Lab3.Model;
public class Etiquetas{
    private final String tagTitle;
    private final String tagContent;
    
    public Etiquetas(String tagTitle, String tagContent){
        this.tagTitle = tagTitle;
        this.tagContent = tagContent;
    }
    
    public String getTagTitle(){
        return tagTitle;
    }
    public String getTagContent(){
        return tagContent;
    }
}
