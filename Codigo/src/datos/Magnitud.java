//Importaciones
package datos;

//Clase
/**
 * Clase sobre la magnitud de los sismos, con su magnitud y escala.
 * @author Esteban
 */
public class Magnitud {
    private float magnitud;;
    private TEscala escala;

    public Magnitud() {
        //Default
    }
    public Magnitud(float magnitud, TEscala escala) {
        this.magnitud = magnitud;
        this.escala = escala;
    }

    public void setMagnitud(float magnitud) {
        this.magnitud = magnitud;
    }
    public void setEscala(TEscala escala) {
        this.escala = escala;
    }
    
    public float getMagnitud() {
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
