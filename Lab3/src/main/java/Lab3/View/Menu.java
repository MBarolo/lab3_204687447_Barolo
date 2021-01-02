package Lab3.View;
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
}
