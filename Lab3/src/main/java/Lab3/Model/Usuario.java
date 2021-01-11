package Lab3.Model;
/**
 * Clase Usuario, representa al usuario en el stack
 * Cada usuario tiene 3 elementos, su username, su password y su reputation
*/
public class Usuario {
    private final String username;
    private final String password;
    private int reputation;
    /**
     * @param username El nombre de usuario del usuario
     * @param password La contraseña del usuario
    */
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
        this.reputation = 0;
    }
    /**
     * Getter de nombre de usuario
     * @return Nombre de usuario
     */
    public String getUsername(){
        return username;
    }
    /**
     * Getter de la contraseña del usuario
     * @return Contraseñña de usuario
     */
    public String getPassword(){
        return password;
    }
    /**
     * Getter de la reputacion
     * @return reputacion del usuario
     */
    public int getReputation(){
        return reputation;
    }
    /**
     * Setter de la reputacion del usuario
     * @param newReputation Valor que representa la nueva reputacion del usuario
     */
    public void setReputation(int newReputation){
        this.reputation = newReputation;
    }
}