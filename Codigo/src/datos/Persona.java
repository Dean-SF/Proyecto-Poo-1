//Importaciones
package datos;

//Clase

import java.util.Objects;

/**
 * Clase para crear una persona con sus datos de contacto.
 * @author Esteban
 */
public class Persona {
    private String nombre;
    private String correo;
    private String celular;
    private TProvincia provincia;
    private String ID;

    public Persona() {
        //Default
    }
    public Persona(String nombre, String correo, String celular, TProvincia provincia, String ID) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.provincia = provincia;
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setProvincia(TProvincia provincia) {
        this.provincia = provincia;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getCelular() {
        return celular;
    }
    public TProvincia getProvincia() {
        return provincia;
    }
    public String getID() {
        return ID;
    }

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
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", correo=" +
                correo + ", celular=" + celular + ", provincia=" +
                provincia + ", ID=" + ID + '}';
    }
}
