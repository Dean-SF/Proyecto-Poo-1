//Importaciones
package datos;
import java.util.Calendar;

//Clase
/**
 * Clase sobre los sismo y sus diferentes datos.
 * @author Esteban
 */
public class Sismo {
   private Calendar fehcaHora;
   private float profundidad;
   private TOrigen origen;
   private Magnitud magnitud;
   private Localizacion localizacion;

    public Sismo() {
        //Default
    }
    public Sismo(Calendar fehcaHora, float profundidad, TOrigen origen, Magnitud magnitud, Localizacion localizacion) {
        this.fehcaHora = fehcaHora;
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
    }

    public void setFehcaHora(Calendar fehcaHora) {
        this.fehcaHora = fehcaHora;
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

    public Calendar getFehcaHora() {
        return fehcaHora;
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

    //Hacer la sobrecarga del equals!!
    
    @Override
    public String toString() {
        return "Sismo{" + "fehcaHora=" + fehcaHora + ", profundidad=" +
                profundidad + ", origen=" + origen + ", magnitud=" +
                magnitud + ", localizacion=" + localizacion + '}';
    }
}
