//Importaciones
package controladores;
import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;
import datos.Localizacion;
import datos.Magnitud;
import datos.Persona;
import datos.DatosPersonas;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//Clase
/**
 * 
 * @author Esteban
 */
public class Administrador {
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    private int numeroSismo = 1;

    public Administrador() {
        //Default
    }
    
    public ArrayList<Sismo> getSismos() {
        return sismos;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    //Dialogar como buscar los sismos
    public boolean agregarSismo(Calendar fechaHora, double profundidad, TOrigen origen, double magnitud, double latitud,
    double longitud, TProvincia provincia, String descripcion){
        Localizacion localizacion = new Localizacion(latitud, longitud, descripcion, provincia);
        Magnitud objetoMagnitud = new Magnitud(magnitud);
        Sismo sismo = new Sismo(numeroSismo, fechaHora, profundidad, origen, objetoMagnitud, localizacion);
        for(Sismo actual : sismos) {
            if(actual.equals(sismo)){
                return false;
            }
        }
        sismos.add(sismo);
        numeroSismo++;
        DatosPersonas.LeerExcel(provincia);
        return true;
    }
    public Sismo consultarSismo(int id){
        for(Sismo actual : sismos){
            if(actual.getId() == id){
                return actual;
            }
        }
        return null;
    }

    public boolean modificarSismo(int id,TModificacion modificacion,int valor){
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        switch(modificacion) {
            case ANNIO:
                sismo.setFechaAnnio(valor);
                return true;
            case DIA:
                sismo.setFechaDia(valor);
                return true;
            case MES:
                sismo.setFechaMes(valor);
                return true;
            case HORA:
                sismo.setHoraHoras(valor);
                return true;
            case MINUTOS:
                sismo.setHoraMinutos(valor);
                return true;
            case SEGUNDOS:
                sismo.setHorasSegundos(valor);
                return true;
            default:
                break;
        }
        return false;
    }

    public boolean modificarSismo(int id,TModificacion modificacion, double valor){
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        switch(modificacion) {
            case LATITUD:
                sismo.setLatitud(valor);
                return true;
            case LONGITUD:
                sismo.setLongitud(valor);
                return true;
            case MAGNITUD:
                sismo.setMagnitud(valor);
                return true;
            case PROFUNDIDAD:
                sismo.setProfundidad(valor);
                return true;
            default:
                break;
        }
        return false;
    }

    public boolean modificarSismo(int id, TProvincia provincia) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setProvincia(provincia);
        return true;
    }

    public boolean modificarSismo(int id, TOrigen origen) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setOrigen(origen);
        return true;
    }

    public boolean modificarSismo(int id, String descripcion) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setDescripcion(descripcion);
        return true;
    }

    public boolean eliminarSismo(int id){
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismos.remove(sismo);
        return true;
    }
    
    public boolean agregarPersona(String ID, String nombre, String correo,
            String celular, List provincias){
        for(Persona persona : personas){
            if(persona.getID().equals(ID)){
                return false;
            }
        }
        Persona nueva = new Persona(ID,nombre,correo,celular,provincias);
        //Persona nueva = new Persona(nombre,correo,celular,provincia,ID);
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
