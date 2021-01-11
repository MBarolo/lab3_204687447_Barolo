package Lab3;
import Lab3.View.*;
import Lab3.Model.*;
import Lab3.Controller.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Stack stackOverflow = new Stack();       
        Menu m1 = new Menu();
        Controller c1 = new Controller(m1, stackOverflow);
        //====================================================================
        //CREACION DEL STACK CARGADO
        stackOverflow.addUserToList("juan99", "pythonesmuyfacil");
        stackOverflow.addUserToList("daniel5", "programacion123");
        stackOverflow.addUserToList("francisco91", "123");
        stackOverflow.addUserToList("matias", "contrasenastack123");
        List<Etiqueta> t1 = new ArrayList();
        t1.add(stackOverflow.getTags().get(0));
        t1.add(stackOverflow.getTags().get(5));
        List<Etiqueta> t2 = new ArrayList();
        t2.add(stackOverflow.getTags().get(3));
        t2.add(stackOverflow.getTags().get(7));
        List<Etiqueta> t3 = new ArrayList();
        t3.add(stackOverflow.getTags().get(3));
        t3.add(stackOverflow.getTags().get(7));
        t3.add(stackOverflow.getTags().get(6));
        List<Etiqueta> t4 = new ArrayList();
        t4.add(stackOverflow.getTags().get(5));
        t4.add(stackOverflow.getTags().get(3));
        List<Etiqueta> t5 = new ArrayList();
        t5.add(stackOverflow.getTags().get(0));
        t5.add(stackOverflow.getTags().get(5));
        stackOverflow.getQuestions().add(new Pregunta(0,t1,"Ayuda con C","Como pido memoria en C?","juan99"));
        stackOverflow.getQuestions().add(new Pregunta(1,t2,"Diagramas UML", "Ayuda, no se como hacer un diagrama UML", "matias"));
        stackOverflow.getQuestions().add(new Pregunta(2,t3, "Clases en java","No se como implementar clases en java","francisco91"));
        stackOverflow.getQuestions().add(new Pregunta(3,t4,"Etiquetas","Como se usan etiquetas?","juan99"));
        stackOverflow.getQuestions().add(new Pregunta(4,t5,"Modulo en C","Que simbolo era para calcular el modulo en C?","daniel5"));
        stackOverflow.getQuestions().get(0).getAnswers().add(new Respuesta(0,"matias","con malloc()"));
        stackOverflow.getQuestions().get(0).getAnswers().add(new Respuesta(1,"francisco91","asi es"));
        stackOverflow.getQuestions().get(1).getAnswers().add(new Respuesta(0,"juan99","con draw.io"));
        stackOverflow.getQuestions().get(1).getAnswers().add(new Respuesta(1,"matias","gracias"));
        stackOverflow.getQuestions().get(2).getAnswers().add(new Respuesta(0,"francisco91","no lo se"));
        stackOverflow.getQuestions().get(2).getAnswers().add(new Respuesta(1,"daniel5","debes definirla en un archivo .java"));
        stackOverflow.getQuestions().get(3).getAnswers().add(new Respuesta(0,"matias","debes elegirlas al hacer una pregunta"));
        stackOverflow.getQuestions().get(3).getAnswers().add(new Respuesta(1,"daniel5","y poner -1 cuando termines"));
        stackOverflow.getQuestions().get(4).getAnswers().add(new Respuesta(0,"daniel5","por favor que no me acuerdo"));
        stackOverflow.getQuestions().get(4).getAnswers().add(new Respuesta(1,"francisco91","con el simbolo %"));
        //==============================================================================================================================
        Scanner scanner = new Scanner(System.in);
        boolean exitCondition = true;
        while(exitCondition){
            if(stackOverflow.getActiveUser().equals("")){
                m1.showQuestions(stackOverflow.getQuestions());
                m1.showUsers(stackOverflow.getUsers());
                m1.mainMenu();
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        m1.showMessage("Ingrese el nombre de usuario y contraseña separados por un enter:");
                        String newUsername = scanner.nextLine();
                        String newPass = scanner.nextLine();
                        c1.login(newUsername, newPass);
                        break;
                    case "2":
                        m1.showMessage("Ingrese el nombre de usuario y contraseña separados por un enter:");
                        String username = scanner.nextLine();
                        String pass = scanner.nextLine();
                        c1.register(username, pass);
                        break;
                    case "3":
                        exitCondition = false;
                        break;
                    default:
                        m1.showMessage("Opcion invalida");
                        break;
                }
            }
            else{
                m1.showMessage("Ingrese la accion que desee realizar:\n\t1. Agregar nueva pregunta\n\t2. Responder pregunta\n\t3. Dar recompensa\n\t4. Aceptar respuesta\n\t5. Votar pregunta/respuesta\n\t6.Cerrar sesion\n\t7.Salir del programa");
                String option = scanner.nextLine();
                switch(option){
                    case "1":
                        m1.showTags(stackOverflow.getTags());
                        boolean condition = true;
                        int tagOption;
                        List<Etiqueta> selectedTags = new ArrayList();
                        while (condition){
                            tagOption = Integer.parseInt(scanner.nextLine());
                            if(tagOption == -1){
                                condition = false;
                            }
                            else{
                                selectedTags.add(stackOverflow.getTags().get(tagOption));
                            }
                        }
                        m1.showMessage("Ingrese el titulo y contenido de su pregunta separados por un enter:");
                        String newTitle = scanner.nextLine();
                        String newContent = scanner.nextLine();
                        c1.ask(newTitle,newContent,selectedTags);
                        break;
                    case "2":
                        m1.showQuestions(stackOverflow.getQuestions());
                        m1.showMessage("Ingrese el id de pregunta y su respuesta separados por un enter:");
                        int idQuestionAnswered = Integer.parseInt(scanner.nextLine());
                        String stringAnswer = scanner.nextLine();
                        c1.answer(stringAnswer, idQuestionAnswered);
                        break;
                    case "3":
                        m1.showMessage("Ingrese el valor de recompensa a ofrecer:");
                        int rewardRequired = Integer.parseInt(scanner.nextLine());
                        m1.showQuestions(stackOverflow.getQuestions());
                        m1.showMessage("Ingrese el id de la pregunta para ofrecer recompensa:");
                        int idQuestion = Integer.parseInt(scanner.nextLine());
                        c1.reward(idQuestion,rewardRequired);
                        break;
                    case "4":
                        m1.showQuestionsAccept(stackOverflow.getQuestions(), stackOverflow.getActiveUser());
                        m1.showMessage("Ingrese el id de pregunta y respuesta a aceptar separados por un enter:");
                        int qIdToAccept = Integer.parseInt(scanner.nextLine());
                        int aIdToAccept = Integer.parseInt(scanner.nextLine());
                        c1.accept(qIdToAccept, aIdToAccept);
                        break;
                    case "5":
                        m1.showMessage("Ingrese el tipo de voto a realizar: 1 para votar a una pregunta, 2 para votar una respuesta");
                        int voteOption = Integer.parseInt(scanner.nextLine());
                        switch(voteOption){
                            case 1:
                                m1.showMessage("Ingrese el id de la pregunta a votar y el tipo de voto (1 para voto positivo, 0 para voto negativo) separados por un enter");
                                int questionId = Integer.parseInt(scanner.nextLine());
                                int vote = Integer.parseInt(scanner.nextLine());
                                c1.vote(questionId,vote);
                                        
                            case 2:
                                m1.showMessage("Ingrese el id de pregunta, el id de respuesta y el tipo de voto (1 para voto positivo, 0 para voto negativo) separados por un enter");
                                int questionId2 = Integer.parseInt(scanner.nextLine());
                                int answerId = Integer.parseInt(scanner.nextLine());
                                int vote2 = Integer.parseInt(scanner.nextLine());
                                c1.vote(questionId2, answerId, vote2);
                            default:
                                m1.showMessage("Opcion invalida");
                        }
                    case "6":
                        c1.logout();
                        break;
                    case "7":
                        exitCondition = false;
                        break;
                    default:
                        m1.showMessage("Opcion invalida");
                }
            }
        }
        
        
    }
}
