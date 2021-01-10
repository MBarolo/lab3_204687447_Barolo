package Lab3.View;
import Lab3.Model.*;
import java.util.*;
public class Menu {
    public void showMessage(String msg){
        System.out.println(msg);
    }
    public void mainMenu(){
        System.out.println("#####################\nStackOverflow\n#####################");
        System.out.println("\t-Ingrese 1 para iniciar sesión\n\t-Ingrese 2 para registrarse\n\t-Ingrese 3 para salir");
    }
    public void showTags(List<Etiquetas> tags){
       System.out.println("Existen las siguientes etiquetas:");
       for(int i = 0; i < tags.size(); i++){
           System.out.println(i + tags.get(i).getTagTitle()+ tags.get(i).getTagContent());
       }
       System.out.println("Elija las etiquetas deseadas ingresando su numero separados por enter.\nEscriba -1 para dejar de elegir etiquetas.");
    }
    public void showQuestions(List<Pregunta> questions){
        if(questions.isEmpty() == false){
            System.out.println("######################");
            System.out.println("Preguntas del Stack:");
            System.out.println("######################");
            for(int i = 0; i < questions.size(); i++){
                System.out.println("Pregunta " + questions.get(i).getId()+" hecha por: "+questions.get(i).getQuestionAuthor()+" en: " +questions.get(i).getQuestionDate() + "\nTitulo: "+questions.get(i).getTitle()+"\nDescripcion: "+questions.get(i).getContent()+"\nRecompensa: "+questions.get(i).getReward()+"\nRespuestas:");
                for(int j = 0; j <questions.get(i).getAnswers().size(); j++){
                    System.out.println("\tRespuesta "+questions.get(i).getAnswers().get(j).getId() + " hecha por: " + questions.get(i).getAnswers().get(j).getAuthor() + " en: " + questions.get(i).getAnswers().get(j).getDate() + "\n\t"+questions.get(i).getAnswers().get(j).getContent()+ "\n\tEstado: "+ questions.get(i).getAnswers().get(j).getStatus());
                    System.out.println("--------------------------------------");
                }
                System.out.println("===========================================");
            }
        }
        else
            System.out.println("No hay preguntas en el stack");
    }
    public void showQuestionsAnswer(List<Pregunta> questions){
        if(questions.isEmpty() == false){
            System.out.println("######################");
            System.out.println("Preguntas del Stack:");
            System.out.println("######################");
            for(int i = 0; i < questions.size(); i++){
                System.out.println("Pregunta (ID) " + questions.get(i).getId()+" hecha por: "+questions.get(i).getQuestionAuthor()+" en: " +questions.get(i).getQuestionDate() + "\nTitulo: "+questions.get(i).getTitle()+"\nDescripcion: "+questions.get(i).getContent()+"\nRecompensa: "+questions.get(i).getReward()+"\nRespuestas:");
                System.out.println("===========================================");
            }
        }
        else
            System.out.println("No hay preguntas en el stack");
    }
    public void showUsers(List<Usuario> users){
        if(users.isEmpty()==false){
            System.out.println("######################");
            System.out.println("Usuarios del Stack:");
            System.out.println("######################");
            for(int i = 0; i< users.size(); i++){
                System.out.println("Usuario: "+users.get(i).getUsername()+ ", Reputacion: "+users.get(i).getReputation());
            }
        }
        else
            System.out.println("No hay usuarios en el stack");
    }
    public void showQuestionsAccept(List<Pregunta> questions, String activeUser){
        System.out.println("######################");
        System.out.println("Preguntas del Stack:");
        System.out.println("######################");
        for(int i = 0; i < questions.size(); i++){
            if(activeUser.equals(questions.get(i).getQuestionAuthor())){
                System.out.println("Pregunta " + questions.get(i).getId()+" hecha por: "+questions.get(i).getQuestionAuthor()+" en: " +questions.get(i).getQuestionDate() + "\nTitulo: "+questions.get(i).getTitle()+"\nDescripcion: "+questions.get(i).getContent()+"\nRecompensa: "+questions.get(i).getReward()+"\nRespuestas:");
                for(int j = 0; j <questions.get(i).getAnswers().size(); j++){
                    System.out.println("\tRespuesta "+questions.get(i).getAnswers().get(j).getId() + " hecha por: " + questions.get(i).getAnswers().get(j).getAuthor() + " en: " + questions.get(i).getAnswers().get(j).getDate() + "\n\t"+questions.get(i).getAnswers().get(j).getContent()+ "\n\tEstado: "+ questions.get(i).getAnswers().get(j).getStatus());
                    System.out.println("--------------------------------------");
                }
                System.out.println("===========================================");
            }
        }
    }
}
