package Lab3.Model;
/**
 * Clase etiqueta, formada por un String tagTitle, titulo de la etiqueta y un String tagContent, contenido de la etiqueta
 */
public class Etiqueta{
    private final String tagTitle;
    private final String tagContent;
    
    /**
     * @param tagTitle String que representa el nombre de la etiquetas
     * @param tagContent String que representa el contenido de la etiqueta
     */
    
    public Etiqueta(String tagTitle, String tagContent){
        this.tagTitle = tagTitle;
        this.tagContent = tagContent;
    }
    /**
     * Getter titulo de la etiqueta
     * @return titulo de la etiqueta
     */
    public String getTagTitle(){
        return tagTitle;
    }
    /**
     * Getter contenido de la etiqueta
     * @return Contenido de la etiqueta
     */
    public String getTagContent(){
        return tagContent;
    }
}
