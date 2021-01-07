package Lab3;
import Lab3.View.*;
import Lab3.Model.*;
import Lab3.Controller.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        List<Etiquetas> tags = new ArrayList();
        tags.add(new Etiquetas("C",": Dedicado para preguntas relacionadas con el lenguaje C."));
        tags.add(new Etiquetas("C++,",": Dedicado para preguntas relacionadas con el lenguaje C++."));
        tags.add(new Etiquetas("C#,",": Dedicado para preguntas relacionadas con el lenguaje C#."));
        tags.add(new Etiquetas("Java,",": Dedicado para preguntas relacionadas con el lenguaje Java."));
        tags.add(new Etiquetas("Python,",": Dedicado para preguntas relacionadas con el lenguaje Python."));
        
        //List<Stack> listaStack = new ArrayList();
        //listaStack.add(new Stack());
        //listaStack.add(new Stack());
        //System.out.println("Existen actualmente "+ listaStack.size()+"Stacks");
        Stack stackOverflow = new Stack();
        Menu m1 = new Menu();
        Controller c1 = new Controller(m1, stackOverflow);
        Scanner scanner = new Scanner(System.in);
        boolean exitCondition = true;
        while(exitCondition){
            if(stackOverflow.getActiveUser().equals("")){
                m1.mainMenu();
                String option = scanner.nextLine();
                if(option.equals("1")){
                    m1.menuRegister();
                    String newUsername = scanner.nextLine();
                    String newPass = scanner.nextLine();
                    c1.login(newUsername, newPass);
                }
                else if(option.equals("2")){
                    m1.menuRegister();
                    String username = scanner.nextLine();
                    String pass = scanner.nextLine();
                    c1.register(username, pass);
                }
                else if(option.equals("3"))
                    exitCondition = false;
                else
                    m1.invalidOption();
            }
            else{
                m1.loggecMainMenu();
                String option = scanner.nextLine();
                switch(option){
                    case "1":
                        m1.showTags(tags);
                        boolean condition = true;
                        int tagOption;
                        List<Etiquetas> selectedTags = new ArrayList();
                        while (condition){
                            tagOption = Integer.parseInt(scanner.nextLine());
                            if(tagOption == -1){
                                condition = false;
                            }
                            else{
                                selectedTags.add(tags.get(tagOption));
                            }
                        }
                        m1.inputTitleAndContent();
                        String newTitle = scanner.nextLine();
                        String newContent = scanner.nextLine();
                        c1.ask(newTitle,newContent,selectedTags);
                        break;
                    case "2":
                        //answer
                    case "3":
                        //reward
                    case "4":
                        //accept
                    case "5":
                        c1.logout();
                        break;
                    case "6":
                        exitCondition = false;
                        break;
                }
            }
        }
        
        
    }
}
