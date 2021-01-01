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
            m1.mainMenu();
            String opcion = scanner.nextLine();
            if(opcion.equals("1")){
                String newUsername = scanner.nextLine();
                String newPass = scanner.nextLine();
                c1.login(newUsername, newPass);
            }
            else if(opcion.equals("2")){
                m1.menuRegister();
                String newUsername = scanner.nextLine();
                String newPass = scanner.nextLine();
                c1.register(newUsername, newPass);
            }
            else if(opcion.equals("3"))
                exitCondition = false;
            
        }
        
        
    }
}
