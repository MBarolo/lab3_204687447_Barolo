package Lab3.View;
public class Menu {
    public void menuChooseStack(){
        System.out.println("Ingrese el Stack a utilizar: \n");
    }
    public void menuRegister(){
        System.out.println("Ingrese su nombre de usuario y contraseña (Separados por un 'enter'): \n");
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
    public void mainMenu(){
        System.out.println("#####################\nStackOverflow\n#####################");
        System.out.println("    -Ingrese 1 para iniciar sesión\n    -Ingrese 2 para registrarse\n   -Ingrese 3 para salir");
    }
}
