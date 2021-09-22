//Importaciones
package controladores;
import datos.TProvincia;
import datos.Sismo;
import datos.Persona;
import java.util.ArrayList;

//Clase
/**
 * 
 * @author Esteban
 */
public class Administrador {
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private ArrayList<Persona> personas = new ArrayList<Persona>();

    public Administrador() {
        //Default
    }
    
    public boolean agregarSismo(){
        return true;
    }
    public boolean consultarSismo(){
        return true;
    }
    public boolean modificarSismo(){
        return true;
    }
    public boolean eliminarSismo(){
        return true;
    }
    
    public boolean agregarPersona(String ID, String nombre, String correo,
            String celular, TProvincia provincia){
        for(Persona persona : personas){
            if(persona.getID().equals(ID)){
                return false;
            }
        }
        Persona nueva = new Persona(nombre,correo,celular,provincia,ID);
        personas.add(nueva);
        return true;
    }
    public boolean consultarPersona(String ID){
        return true;
    }
    public boolean modificarPersona(String ID){
        return true;
    }
    public boolean eliminarPersona(String ID){
        return true;
    }
}
