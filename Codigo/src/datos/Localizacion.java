//Importaciones
package datos;

//Clase
/**
 * Clase para la localizacion de un sismo y su descripcion.
 * @author Esteban
 */
public class Localizacion {
    private double latitud;
    private double longitud;
    private String descripcion;
    private TProvincia provincia;

    public Localizacion() {
        //Default
    }
    public Localizacion(double latitud, double longitud, String descripcion, TProvincia provincia) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.provincia = provincia;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setProvincia(TProvincia provincia) {
        this.provincia = provincia;
    }

    public double getLatitud() {
        return latitud;
    }
    public double getLongitud() {
        return longitud;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public TProvincia getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return "Localizacion{" + "latitud=" + latitud + ", longitud=" +
                longitud + ", descripcion=" + descripcion +
                ", provincia=" + provincia + '}';
    } 
}
