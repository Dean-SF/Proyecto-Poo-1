package principal;
import interfaz.GestorVentanas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import controladores.Administrador;
import controladores.ExcelCreator;

public class Inicializador {
    public static Administrador adminDatos = new Administrador();
    public static ExcelCreator excel;
    public static void main(String[] args) throws InvalidFormatException, IOException {
        excel = new ExcelCreator();
        new GestorVentanas();
    }
}
