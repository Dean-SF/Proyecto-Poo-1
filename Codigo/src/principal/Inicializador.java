package principal;
import interfaz.GestorVentanas;
import controladores.Administrador;
import controladores.ExcelCreator;

public class Inicializador {
    public static Administrador adminDatos = new Administrador();
    public static ExcelCreator excel = new ExcelCreator();
    public static void main(String[] args) {
        new GestorVentanas();
    }
}
