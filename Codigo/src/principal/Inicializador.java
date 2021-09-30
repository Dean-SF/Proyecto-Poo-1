package principal;
import interfaz.GestorVentanas;
import controladores.Administrador;

public class Inicializador {
    public static Administrador adminDatos = new Administrador();
    public static void main(String[] args) {
        new GestorVentanas();
    }
}
