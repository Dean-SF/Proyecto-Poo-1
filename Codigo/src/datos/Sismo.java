//Importaciones
package datos;
import java.text.DecimalFormat;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;


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
    private int id;

    public Sismo() {
        //Default
    }
    public Sismo(int id, Calendar fechaHora, double profundidad, TOrigen origen, Magnitud magnitud, 
    Localizacion localizacion) {
        this.fechaHora = fechaHora;
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public double getLatitud() {
        return localizacion.getLatitud();
    }

    public double getLongitud() {
        return localizacion.getLongitud();
    }

    public String stringFecha(){
        return fechaHora.get(DAY_OF_MONTH) + "/" + (fechaHora.get(MONTH)+1) + "/" + fechaHora.get(YEAR);
    }

    public String stringHora(){
        DecimalFormat formato = new DecimalFormat("00");
        return formato.format(fechaHora.get(HOUR_OF_DAY)) + ":" + formato.format(fechaHora.get(MINUTE)) + ":" + 
        formato.format(fechaHora.get(SECOND));
    }

    public String stringMagnitud(){
            TEscala escala = magnitud.getEscala();
            switch (escala) {
                case MAGNITUD_LOCAL:
                    return magnitud.getMagnitud() + " Ml";
                case MAGNITUD_DE_MOMENTO:
                    return magnitud.getMagnitud() + " Mw";
                default:
                    return "N/A";
            }
    }

    public String stringLocalizacion() {
        TProvincia provincia = localizacion.getProvincia();
        String descripcion = localizacion.getDescripcion();
        switch (provincia) {
            case ALAJUELA:
                return "Alajuela" + ", " + descripcion;
            case CARTAGO:
                return "Cartago" + ", " + descripcion;
            case GUANACASTE:
                return "Guanacaste" + ", " + descripcion;
            case HEREDIA:
                return "Heredia" + ", " + descripcion;
            case LIMON:
                return "Limon" + ", " + descripcion;
            case PUNTARENAS:
                return "Puntarenas" + ", " + descripcion;
            case SAN_JOSE:
                return "San Jose" + ", " + descripcion;
            default:
                return "N/A";
            
        }
    }

    public String stringProfundidad() {
        return profundidad + " Km";
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
