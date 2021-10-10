//Importaciones
package controladores;
import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;
import datos.Localizacion;
import datos.Magnitud;
import datos.Persona;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//Clase
/**
 * Clase que contiene los datos de todos los sismos y personas del programa
 * @author Esteban
 */
public class Administrador {
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    private int numeroSismo = 1;

    public Administrador() {
        //Default
    }
    public void setNumeroSismo() {
        for(Sismo actual : sismos) {
            if(numeroSismo < actual.getId()) {
                numeroSismo = actual.getId();
            }
        }
        numeroSismo++;
    }

    public int getNumeroSismo() {
        return numeroSismo;
    }

    public ArrayList<Sismo> getSismos() {
        return sismos;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * Metodo para agregar sismos a la lista de sismos
     * @param fechaHora Tipo {@code Calendar} con la fecha y la hora
     * @param profundidad Tipo {@code double} con la profundidad del sismo
     * @param origen Tipo {@code TOrigen} con el origen del sismo
     * @param magnitud Tipo {@code double} con la magnitud del sismo
     * @param latitud Tipo {@code double} con la latidud del sismo
     * @param longitud Tipo {@code longitud} con la longitud del sismo
     * @param provincia Tipo {@code TProvincia} con la provincia del sismo
     * @param descripcion Tipo {@code String} con la descripcion de la localizacion del sismo
     * @return {@code true} si este logro agregar, {@code false} si no
     */
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
        return true;
    }

    /**
     *  Metodo para agregar sismos a la lista de sismos, esta sobrecarga incluye ID
     * @param fechaHora Tipo {@code Calendar} con la fecha y la hora
     * @param profundidad Tipo {@code double} con la profundidad del sismo
     * @param origen Tipo {@code TOrigen} con el origen del sismo
     * @param magnitud Tipo {@code double} con la magnitud del sismo
     * @param latitud Tipo {@code double} con la latidud del sismo
     * @param longitud Tipo {@code longitud} con la longitud del sismo
     * @param provincia Tipo {@code TProvincia} con la provincia del sismo
     * @param descripcion Tipo {@code String} con la descripcion de la localizacion del sismo
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @return {@code true} si este logro agregar, {@code false} si no
     */
    public boolean agregarSismo(Calendar fechaHora, double profundidad, TOrigen origen, double magnitud, double latitud,
    double longitud, TProvincia provincia, String descripcion, int id){
        Localizacion localizacion = new Localizacion(latitud, longitud, descripcion, provincia);
        Magnitud objetoMagnitud = new Magnitud(magnitud);
        Sismo sismo = new Sismo(id, fechaHora, profundidad, origen, objetoMagnitud, localizacion);
        for(Sismo actual : sismos) {
            if(actual.equals(sismo)){
                return false;
            }
        }
        sismos.add(sismo);
        return true;
    }

    /**
     * Busca un sismo dado un ID
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @return El sismo encontrado, si no, {@code null}
     */
    public Sismo consultarSismo(int id){
        for(Sismo actual : sismos){
            if(actual.getId() == id){
                return actual;
            }
        }
        return null;
    }

    /**
     * Modifica un sismo dado su ID, tipo de modificacion y el valor a asignar segun la modificacion
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @param modificacion Tipo {@code TModificacion} segun la modificacion que se quiere realizar
     * @param valor Tipo {@code int} con el valor que se quiere asignar
     * @return {@code booleano} segun se haya podido modificar o no
     */
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

    /**
     * Sobre carga modifica un sismo dado su ID, tipo de modificacion y el valor a asignar segun la modificacion
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @param modificacion Tipo {@code TModificacion} segun la modificacion que se quiere realizar
     * @param valor Tipo {@code double} con el valor que se quiere asignar
     * @return {@code booleano} segun se haya podido modificar o no
     */
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

    /**
     * Sobre carga modifica la provincia de un sismo dado su ID y TProvincia
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @param provincia Tipo {@code TProvincia} con la provincia que se quiere cambiar
     * @return {@code booleano} segun se haya podido modificar o no
     */
    public boolean modificarSismo(int id, TProvincia provincia) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setProvincia(provincia);
        return true;
    }

    /**
     * Sobre carga modifica el origen de un sismo dado su ID y TOrigen
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @param origen Tipo {@code TOrigen} con el origen que se quiere cambiar
     * @return {@code booleano} segun se haya podido modificar o no
     */
    public boolean modificarSismo(int id, TOrigen origen) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setOrigen(origen);
        return true;
    }

    /**
     * Sobre carga, modifica la descripcion de la localizacion del sismo segun el ID y la descrpcion dada
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @param descripcion Tipo {@code String} con la nueva descripcion
     * @return {@code booleano} segun se haya podido modificar o no
     */
    public boolean modificarSismo(int id, String descripcion) {
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismo.setDescripcion(descripcion);
        return true;
    }

    /**
     * Elimina un sismo segun el ID dado
     * @param id Tipo {@code int} con el ID correspondiente al sismo
     * @return {@code booleano} segun se haya podido eliminar o no
    */
    public boolean eliminarSismo(int id){
        Sismo sismo = consultarSismo(id);
        if(sismo == null) {
            return false;
        }
        sismos.remove(sismo);
        return true;
    }
    
    /**
     * Metodo para agregar personas a la lista de personas
     * @param id Tipo {@code int} con la identificacion de la persona
     * @param nombre Tipo {@code String} con el nombre de la persona
     * @param correo Tipo {@code String} con el correo de la persona
     * @param celular Tipo {@code String} con el numero de la persona
     * @param provincias Tipo {@code List<TProvincia>} con las provincias de interes de la persona
     * @return {@code booleano} segun se haya podido agregar o no
     */
    public boolean agregarPersona(int id, String nombre, String correo,
    int celular, List<TProvincia> provincias){
        for(Persona persona : personas){
            if(persona.getID() == id){
                return false;
            }
        }
        Persona nueva = new Persona(id,nombre,correo,celular,provincias);
        personas.add(nueva);
        return true;
    }

    /**
     * Metodo para consultar personas de la lista de personas
     * @param id Tipo {@code int} con la identificacion de la persona
     * @return Una {@code Persona} si la encontro, {@code null} si no
     */
    public Persona consultarPersona(int id){
        for(Persona persona : personas){
            if(persona.getID() == id){
                return persona;
            }
        }
        return null;
    }

    
}
