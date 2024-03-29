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
        this.fechaHora.set(Calendar.HOUR_OF_DAY, hora);
        this.fechaHora.set(Calendar.MINUTE, minutos);
        this.fechaHora.set(Calendar.SECOND, segundos);
    }

    public void setHoraHoras(int hora) {
        this.fechaHora.set(Calendar.HOUR_OF_DAY, hora);
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
        this.magnitud.setMagnitud(magnitud);
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

    public double getMagnitudNumerica() {
        return magnitud.getMagnitud();
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public String getDescripcion() {
        return localizacion.getDescripcion();
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
     
    public TProvincia getProvincia() {
        return localizacion.getProvincia();
    }

    
    
    /**
     * Devuelve un string con la fecha del sismo
     * @return String con mes, dias y annio
     */
    public String stringFecha(){
        return fechaHora.get(DAY_OF_MONTH) + "/" + (fechaHora.get(MONTH)+1) + "/" + fechaHora.get(YEAR);
    }
    
    /**
     * Devuelve un string con la hora del sismo
     * @return String con hora, minuto y segundo
     */
    public String stringHora(){
        DecimalFormat formato = new DecimalFormat("00");
        return formato.format(fechaHora.get(HOUR_OF_DAY)) + ":" + formato.format(fechaHora.get(MINUTE)) + ":" + 
        formato.format(fechaHora.get(SECOND));
    }

    /**
     * Convierte la magnitud en un string mas el tipo de magnitud
     * @return String con magnitud + (Ml o Mw)
     */
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

    /**
     * Devualve un string con la provincia y la descripcion
     * @return Sring de provincia + descripcion
     */
    public String stringLocalizacion() {
        return stringProvincia() + ", " + getDescripcion();
    }
    
    /**
     * Convierte el TProvincia en un string
     * @return String con la provincia
     */
    public String stringProvincia() {
        return tprovinciaToString(localizacion.getProvincia());
    }
    
    /**
     * Convierte el TOrigen en un string
     * @return String con origen
     */
    public String stringOrigen() {
        return torigenToString(origen);
    }

    /**
     * Devuelve un string con la profundidad mas el simbolo de Km
     * @return String profundidad + Km
     */
    public String stringProfundidad() {
        return profundidad + " Km";
    }

    /**
     * Metodo que convierte un string ya sea: {@code "Choque de placas"}, {@code "Tectonico Por falla Local"}, 
     * {@code "Subduccion"}, {@code "Intra placa"} y {@code "Deformacion Interna"} a su TOrigen correspondiente
     * @param origen cualquier tipo de string
     * @return {@code TOrigen} dependiendo del string de entrada, si este no coincide con ningun caso retorna
     * {@code null}
     */
    public static TOrigen stringToTOrigen(String origen) {
        switch (origen) {
            case "Subduccion":
                return TOrigen.SUBDUCION;
            case "Choque de placas":
                return TOrigen.CHOQUE_DE_PLACAS;
            case "Deformacion interna":
                return TOrigen.DEFORMACION_INTERNA;
            case "Intra placa":
                return TOrigen.INTRA_PLACA;
            case "Tectonico por falla local":
                return TOrigen.TECTONICO_POR_FALLA_LOCAL;
            default:
                return null;
        }
    }

    /**
     *  Metodo que convierte un string ya sea: {@code "San José"}, {@code "Alajuela"}, {@code "Cartago"}, 
     * {@code "Heredia"}, {@code "Guanacaste"}, {@code "Puntarenas"} y {@code "Limón"} a su TProvincia correspondiente
     * @param provincia cualquier tipo de string
     * @return {@code TProvincia} dependiendo del string de entrada, si este no coincide con ningun caso retorna
     * {@code null}
    */
    public static TProvincia stringToTProvincia(String provincia) {
        switch (provincia) {
            case "Alajuela":
                return TProvincia.ALAJUELA;
            case "Cartago":
                return TProvincia.CARTAGO;
            case "Guanacaste":
                return TProvincia.GUANACASTE;
            case "Heredia":
                return TProvincia.HEREDIA;
            case "Limon":
                return TProvincia.LIMON;
            case "Puntarenas":
                return TProvincia.PUNTARENAS;
            case "San Jose":
                return TProvincia.SAN_JOSE;
            case "Sin asignar":
                return TProvincia.SIN_ASIGNAR;
            default:
                return null;
        }
    }

    /**
     * Metodo para convertir de {@code TProvincia} a su equivalente string
     * @param provincia tipo {@code TProvincia}
     * @return un string con su equivalente en string
     */
    public static String tprovinciaToString(TProvincia provincia) {
        switch (provincia) {
            case ALAJUELA:
                return "Alajuela";
            case CARTAGO:
                return "Cartago";
            case GUANACASTE:
                return "Guanacaste";
            case HEREDIA:
                return "Heredia";
            case LIMON:
                return "Limon";
            case PUNTARENAS:
                return "Puntarenas";
            case SAN_JOSE:
                return "San Jose";
            case SIN_ASIGNAR:
                return "Sin asignar";
            default:
                return "N/A";
        }
    }

    /**
     * Metodo para convertir de {@code TOrigen} a su equivalente string
     * @param origen tipo {@code TOrigen}
     * @return un string con su equivalente en string
     */
    public static String torigenToString(TOrigen origen) {
        switch (origen) {
            case SUBDUCION:
                return "Subduccion";
            case CHOQUE_DE_PLACAS:
                return "Choque de placas";
            case DEFORMACION_INTERNA:
                return "Deformacion interna";    
            case INTRA_PLACA:
                return "Intra placa";
            case TECTONICO_POR_FALLA_LOCAL:
                return "Tectonico por falla local";
            default:
                return "N/A";
        }
    }

    /**
     * Override del metodo equals, compara si dos sismos son iguales segun su ID
     */
    @Override
    public boolean equals(Object obj) {
        final Sismo other = (Sismo) obj;
        if(this == obj){
            return true;
        } 
        if(obj.getClass() != getClass()) {
            return false;
        } 
        if(this.id != other.id) {
            return false;
        }
        return true;
    }
    
    /**
     * Override del metodo toString, converte el sismo y sus datos a una representacion de string
     */
    @Override
    public String toString() {
        return "Fecha: " + stringFecha() + "\n" + "Hora: " + stringHora() + "\n" + "Magnitud: " + stringMagnitud() + 
               "\n" + "Profundidad: " + stringProfundidad() + "\n" + "Origen: " + stringOrigen() + "\n" +
               "Localizacion: " + stringLocalizacion() + "\n" + "Latitud: " + localizacion.getLatitud() + "\n" +
               "Longitud: " + localizacion.getLongitud();
    }
}
