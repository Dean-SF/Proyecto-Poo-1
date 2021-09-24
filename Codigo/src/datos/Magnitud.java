//Importaciones
package datos;

//Clase
/**
 * Clase sobre la magnitud de los sismos, con su magnitud y escala.
 * @author Esteban
 */
public class Magnitud {
    private double magnitud;;
    private TEscala escala;
    
    public Magnitud() {
        //Default
    }
    public Magnitud(double magnitud) {
        this.magnitud = magnitud;
        if(magnitud > 6.9) {
            escala = TEscala.MAGNITUD_DE_MOMENTO;
        } else {
            escala = TEscala.MAGNITUD_LOCAL;
        }
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
        if(magnitud > 6.9) {
            escala = TEscala.MAGNITUD_DE_MOMENTO;
        } else {
            escala = TEscala.MAGNITUD_LOCAL;
        }
    }
    public void setEscala(TEscala escala) {
        this.escala = escala;
    }
    
    public double getMagnitud() {
        return magnitud;
    }
    public TEscala getEscala() {
        return escala;
    }

    @Override
    public String toString() {
        return "Magnitud{" + "magnitud=" + magnitud + ", escala=" + escala + '}';
    }
}
