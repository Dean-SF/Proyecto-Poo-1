package principal;
import interfaz.GestorVentanas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import controladores.Administrador;
import controladores.ExcelCreator;

/** 
 * Clase inicializadora, contiene el main e instancias de algunas clases necesarias para el funcionamiento
 * del programa, ademas que inicia la interfaz.
*/
public class Inicializador {
    public static Administrador adminDatos = new Administrador();
    public static ExcelCreator excel;
    public static void main(String[] args) throws InvalidFormatException, IOException {
        excel = new ExcelCreator();
        new GestorVentanas();
    }
}
