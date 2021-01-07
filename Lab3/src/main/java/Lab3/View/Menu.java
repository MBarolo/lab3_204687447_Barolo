package Lab3.View;
import Lab3.Model.*;
import java.util.*;
public class Menu {
    public void menuChooseStack(){
        System.out.println("Ingrese el Stack a utilizar: \n");
    }
    public void menuRegister(){
        System.out.println("Ingrese su nombre de usuario y contraseña (Separados por un 'enter'):");
    }
    public void userAlreadyExists(){
        System.out.println("El nombre de usuario escogido ya existe.");
    }
    public void zeroUsersRegistered(){
        System.out.println("No hay usuarios registrados en el stack");
    }
    public void succesfullyLogged(){
        System.out.println("Sesion iniciada");
    }
    public void wrongUserOrPass(){
        System.out.println("Nombre de usuario o contraseña erroneos");
    }
    public void noUserToLogOff(){
        System.out.println("No hay usuario activo");
    }
    public void loggingOff(){
        System.out.println("Sesion cerrada");
    }
    public void mainMenu(){
        System.out.println("#####################\nStackOverflow\n#####################");
        System.out.println("\t-Ingrese 1 para iniciar sesión\n\t-Ingrese 2 para registrarse\n\t-Ingrese 3 para salir");
    }
    public void invalidOption(){
        System.out.println("Opcion no valida");
    }
    public void loggecMainMenu(){
        System.out.println("Ingrese la accion que desee realizar:\n\t1. Agregar nueva pregunta\n\t2. Responder pregunta\n\t3. Dar recompensa\n\t4. Aceptar respuesta\n\t5.Cerrar sesion\n\t6.Salir del programa");
    }
    public void showTags(List<Etiquetas> tags){
       System.out.println("Existen las siguientes etiquetas:");
       for(int i = 0; i < tags.size(); i++){
           System.out.println(i + tags.get(i).getTagTitle()+ tags.get(i).getTagContent());
       }
       System.out.println("Elija las etiquetas deseadas ingresando su numero separados por enter.\nEscriba -1 para dejar de elegir etiquetas.");
    }
    public void showQuestions(List<Pregunta> questions){
        System.out.println("######################");
        System.out.println("Preguntas del Stack:");
        System.out.println("######################");
        for(int i = 0; i < questions.size(); i++){
            System.out.println("Pregunta " + questions.get(i).getId()+"hecha por: "+questions.get(i).getQuestionAuthor()+" en: " +questions.get(i).getQuestionDate() + "\nTitulo: "+questions.get(i).getTitle()+"\nDescripcion: "+questions.get(i).getContent()+"\nRecompensa: "+questions.get(i).getReward()+"\nRespuestas:");
            for(int j = 0; j <questions.get(i).getAnswers().size(); j++){
                System.out.println("\tRespuesta "+questions.get(i).getAnswers().get(j).getId() + " hecha por: " + questions.get(i).getAnswers().get(j).getAuthor() + " en: " + questions.get(i).getAnswers().get(j).getDate() + "\n\t"+questions.get(i).getAnswers().get(j).getContent()+ "\n\tEstado: "+ questions.get(i).getAnswers().get(j).getStatus());
            }
        }
    }
    public void inputTitleAndContent(){
        System.out.println("Ingrese el titulo y contenido de su pregunta separados por un enter");
    }
}
