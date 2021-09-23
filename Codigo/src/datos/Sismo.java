//Importaciones
package datos;
import java.util.Calendar;

//Clase
/**
 * Clase sobre los sismo y sus diferentes datos.
 * @author Esteban
 */
public class Sismo {
   private Calendar fechaHora;
   private float profundidad;
   private TOrigen origen;
   private Magnitud magnitud;
   private Localizacion localizacion;

    public Sismo() {
        //Default
    }
    public Sismo(Calendar fechaHora, float profundidad, TOrigen origen, Magnitud magnitud, Localizacion localizacion) {
        this.fechaHora = fechaHora;
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }

    public void setOrigen(TOrigen origen) {
        this.origen = origen;
    }

    public void setMagnitud(Magnitud magnitud) {
        this.magnitud = magnitud;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public TOrigen getOrigen() {
        return origen;
    }

    public Magnitud getMagnitud() {
        return magnitud;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public double obtenerLatitud() {
        return localizacion.getLatitud();
    }

    public double obtenerLongitud() {
        return localizacion.getLongitud();
    }

    //Hacer la sobrecarga del equals!!
    
    @Override
    public String toString() {
        return "Sismo{" + "fechaHora=" + fechaHora + ", profundidad=" +
                profundidad + ", origen=" + origen + ", magnitud=" +
                magnitud + ", localizacion=" + localizacion + '}';
    }
}
