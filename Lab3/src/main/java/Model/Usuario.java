package Model;
/**
 * Clase Usuario, representa al usuario en el stack
 * Cada usuario tiene 3 elementos, su username, su password y su reputation
*/
public class Usuario {
    private final String username;
    private final String password;
    private int reputation;
    
    /**
     * Clase usuario
     * @param username El nombre de usuario del usuario
     * @param password La contraseña del usuario
     * @param reputation La reputacion del usuario
    */
    
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
        this.reputation = 0;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getReputation(){
        return reputation;
    }
    
    public void setReputation(int newReputation){
        this.reputation = newReputation;
    }
}