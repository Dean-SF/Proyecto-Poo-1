//Importaciones
package controladores;
import datos.TProvincia;
import datos.Sismo;
import datos.Persona;
import java.util.ArrayList;
import java.util.Calendar;

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
    
    //Dialogar como buscar los sismos
    public boolean agregarSismo(){
        return true;
    }
    public Sismo consultarSismo(Calendar fechaHora, double latitud, double longitud){
        for(Sismo actual : sismos){
            if(actual.getFechaHora().equals(fechaHora)){
                
            }
        }
        return null;
    }
    public boolean modificarSismo(){
        return true;
    }
    public boolean eliminarSismo(){
        return false;
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
    public Persona consultarPersona(String ID){
        for(Persona persona : personas){
            if(persona.getID().equals(ID)){
                return persona;
            }
        }
        return null;
    }
    public boolean modificarPersona(String ID){
        for(Persona persona : personas){
            if(persona.getID().equals(ID)){
                //Falta saber que modificar
                return true;
            }
        }
        return false;
    }
    public boolean eliminarPersona(String ID){
        for(Persona persona : personas){
            if(persona.getID().equals(ID)){
                personas.remove(persona);
                return true;
            }
        }
        return false;
    }
}
