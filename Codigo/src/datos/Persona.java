//Importaciones
package datos;

//Clase

import java.util.List;
import java.util.Objects;

/**
 * Clase para crear una persona con sus datos de contacto.
 * @author Esteban
 */
public class Persona {
    private String nombre;
    private String correo;
    private int celular;
    private List<TProvincia> provincias;
    private int id;

    public Persona() {
        //Default
    }
    public Persona(int id, String nombre, String correo, int celular, List<TProvincia> provincias) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.provincias = provincias;
        this.id = id;
    }

    public List<TProvincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<TProvincia> provincias) {
        this.provincias = provincias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setCelular(int celular) {
        this.celular = celular;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public int getCelular() {
        return celular;
    }
    public int getID() {
        return id;
    }

    /**
     * Override del metodo equals, compara si dos personas son iguales segun su ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Override del metodo toString, converte la persona y sus datos a una representacion de string
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", correo=" +
                correo + ", celular=" + celular + ", provincias=" +
                provincias + ", id=" + id + '}';
    }
}
