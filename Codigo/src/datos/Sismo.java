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
   private double profundidad;
   private TOrigen origen;
   private Magnitud magnitud;
   private Localizacion localizacion;

    public Sismo() {
        //Default
    }
    public Sismo(Calendar fechaHora, double profundidad, TOrigen origen, Magnitud magnitud, Localizacion localizacion) {
        this.fechaHora = fechaHora;
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
    }

    public void setFecha(int dia, int mes, int annio) {
        this.fechaHora.set(Calendar.DAY_OF_MONTH,dia);
        this.fechaHora.set(Calendar.MONTH,mes);
        this.fechaHora.set(Calendar.YEAR,annio);
    }

    public void setFechaDia(int dia) {
        this.fechaHora.set(Calendar.DAY_OF_MONTH,dia);
    }
    
    public void setFechaMes(int mes) {
        this.fechaHora.set(Calendar.MONTH,mes);
    }

    public void setFechaAnnio(int annio) {
        this.fechaHora.set(Calendar.YEAR,annio);
    }

    public void setHora(int hora, int minutos, int segundos) {
        this.fechaHora.set(Calendar.HOUR, hora);
        this.fechaHora.set(Calendar.MINUTE, minutos);
        this.fechaHora.set(Calendar.SECOND, segundos);
    }

    public void setHoraHoras(int hora) {
        this.fechaHora.set(Calendar.HOUR, hora);
    }

    public void setHoraMinutos(int minutos) {
        this.fechaHora.set(Calendar.MINUTE, minutos);
    }

    public void setHorasSegundos(int segundos) {
        this.fechaHora.set(Calendar.SECOND, segundos);
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setOrigen(TOrigen origen) {
        this.origen = origen;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud.setMagnitud(magnitud);;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public void setLatitud(double latitud) {
        this.localizacion.setLatitud(latitud);
    }
    
    public void setLongitud(double longitud) {
        this.localizacion.setLongitud(longitud);
    }

    public void setProvincia(TProvincia provincia) {
        this.localizacion.setProvincia(provincia);
    }

    public void setDescripcion(String descripcion) {
        this.localizacion.setDescripcion(descripcion);
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public double getProfundidad() {
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

    @Override
    public boolean equals(Object obj) {
        final Sismo other = (Sismo) obj;
        if(this == obj){
            return true;
        } 
        if(obj.getClass() != getClass()) {
            return false;
        } 
        if(!(this.fechaHora.equals(other.fechaHora))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Sismo{" + "fechaHora=" + fechaHora + ", profundidad=" +
                profundidad + ", origen=" + origen + ", magnitud=" +
                magnitud + ", localizacion=" + localizacion + '}';
    }
}
