package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import datos.Persona;
import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;

import static principal.Inicializador.adminDatos;

public class ExcelCreator {
    private File archivo = new File("src/principal/datos.xlsx");
    private XSSFWorkbook excel;
    private XSSFSheet sismos;
    private XSSFSheet personas;
    private CellStyle formatoFecha;
    private Row nuevaFila;
    private Cell nuevaCelda;

    public ExcelCreator() throws InvalidFormatException, IOException{
        if(archivo.exists()) {
            cargarExcel();
            return;
        }
        excel = new XSSFWorkbook();
        sismos = excel.createSheet("Sismos");
        personas = excel.createSheet("Personas");
        formatoFecha = excel.createCellStyle();
        formatoFecha.setDataFormat((short) 22);
        cargarCabezaSismos();
        cargarCabezaPersonas();
        
        
    }

    private void cargarCabezaSismos() {
        nuevaFila = sismos.createRow(0);
        String[] cabeza = {"ID","Fecha","Magnitud","Profundidad","Origen","Provincia",
                           "Descripcion","Latitud","Longitud"};

        for(int i = 0; i < 9; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            nuevaCelda.setCellValue(cabeza[i]);
        }
    }

    private void cargarCabezaPersonas() {
        nuevaFila = personas.createRow(0);
        String[] cabeza = {"ID","Nombre","Correo","Celular","Provincias"};

        for(int i = 0; i < 5; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            nuevaCelda.setCellValue(cabeza[i]);
        }
    }

    private void guardarExcel() throws IOException {
        for(int i = 0; i < 9; i++) {
            sismos.autoSizeColumn(i);
            if(i < 5) {
                personas.autoSizeColumn(i);
            }
        }
        FileOutputStream salida = new FileOutputStream(archivo);
        excel.write(salida);
        salida.close();
    }

    private void agregarSismo(Sismo actual) {
        Object[] sismoElementos = new Object[9];
        sismoElementos[0] = actual.getId();
        sismoElementos[1] = actual.getFechaHora();
        sismoElementos[2] = actual.getMagnitudNumerica();
        sismoElementos[3] = actual.getProfundidad();
        sismoElementos[4] = actual.stringOrigen();
        sismoElementos[5] = actual.stringProvincia();
        sismoElementos[6] = actual.getDescripcion();
        sismoElementos[7] = actual.getLatitud();
        sismoElementos[8] = actual.getLongitud();

        for(int i = 0; i < 9; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            if(sismoElementos[i] instanceof Integer) {
                nuevaCelda.setCellValue((Integer) sismoElementos[i]);
            } else if(sismoElementos[i] instanceof Calendar) {
                nuevaCelda.setCellValue((Calendar) sismoElementos[i]);
                nuevaCelda.setCellStyle(formatoFecha);
            } else if(sismoElementos[i] instanceof Double) {
                nuevaCelda.setCellValue((Double) sismoElementos[i]);
            } else if(sismoElementos[i] instanceof String) {
                nuevaCelda.setCellValue((String) sismoElementos[i]);
            }
        }

    }

    private void agregarPersona(Persona actual) {
        Object[] personaElementos = new Object[5];
        personaElementos[0] = actual.getID();
        personaElementos[1] = actual.getNombre();
        personaElementos[2] = actual.getCorreo();
        personaElementos[3] = actual.getCelular();
        String provincias = "";
        List<TProvincia> listaProvincias = actual.getProvincias();
        for(TProvincia activo : listaProvincias) {
            provincias += "," + Sismo.tprovinciaToString(activo);
        }
        provincias = provincias.substring(1);
        personaElementos[4] = provincias;

        for(int i = 0; i < 5; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            if(personaElementos[i] instanceof Integer) {
                nuevaCelda.setCellValue((Integer) personaElementos[i]);
            } else if(personaElementos[i] instanceof String) {
                nuevaCelda.setCellValue((String) personaElementos[i]);
            }
        }
    }


    public void actualizarHojaSismos() throws IOException {
        int fila = 1;
        ArrayList<Sismo> listaSismos = adminDatos.getSismos();

        for(Sismo actual : listaSismos) {
            nuevaFila = sismos.createRow(fila++);
            agregarSismo(actual);
        }
        guardarExcel();
    }

    public void agregarUltimoSismo() throws IOException { 
        ArrayList<Sismo> listaSismos = adminDatos.getSismos();
        Sismo sismo = listaSismos.get((listaSismos.size()-1));
        nuevaFila = sismos.createRow(listaSismos.size());
        agregarSismo(sismo);
        guardarExcel();
    }

    public void agregarUltimaPersona() throws IOException {
        ArrayList<Persona> listaPeronas = adminDatos.getPersonas();
        Persona persona = listaPeronas.get((listaPeronas.size()-1));
        nuevaFila = personas.createRow(listaPeronas.size());
        agregarPersona(persona);
        guardarExcel();
    }

    private void cargarSismos() {
        for(int i = 1; nuevaFila != null; i++) {
            
            nuevaCelda = nuevaFila.getCell(0);
            int id = (int) nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(1);
            Calendar fecha = new GregorianCalendar();
            fecha.setTimeInMillis(nuevaCelda.getDateCellValue().getTime());

            nuevaCelda = nuevaFila.getCell(2);
            double mag = nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(3);
            double prof = nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(4);
            TOrigen origen = Sismo.stringToTOrigen(nuevaCelda.getStringCellValue());

            nuevaCelda = nuevaFila.getCell(5);
            TProvincia provincia = Sismo.stringToTProvincia(nuevaCelda.getStringCellValue());

            nuevaCelda = nuevaFila.getCell(6);
            String descripcion = nuevaCelda.getStringCellValue();
            
            nuevaCelda = nuevaFila.getCell(7);
            double lat = nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(8);
            double lon = nuevaCelda.getNumericCellValue();

            nuevaFila = sismos.getRow(i+1);

            adminDatos.agregarSismo(fecha, prof, origen, mag, lat, lon, provincia, descripcion, id);
        }
    }

    private void cargarPersonas() {
        for(int i = 1; nuevaFila != null; i++) {
            
            nuevaCelda = nuevaFila.getCell(0);
            int id = (int) nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(1);
            String nombre = nuevaCelda.getStringCellValue();

            nuevaCelda = nuevaFila.getCell(2);
            String correo = nuevaCelda.getStringCellValue();

            nuevaCelda = nuevaFila.getCell(3);
            int celular = (int) nuevaCelda.getNumericCellValue();

            nuevaCelda = nuevaFila.getCell(4);
            String provincias = nuevaCelda.getStringCellValue();
            String[] arregloProvincias = provincias.split(",", 0);
            List<TProvincia> listaProvincias = new ArrayList<TProvincia>();
            for(String actual : arregloProvincias) {
                listaProvincias.add(Sismo.stringToTProvincia(actual));
            }

            nuevaFila = personas.getRow(i+1);

            adminDatos.agregarPersona(id, nombre, correo, celular, listaProvincias);
        }
    }

    private void cargarExcel() throws InvalidFormatException, IOException {
        excel = new XSSFWorkbook(new FileInputStream(archivo));
        formatoFecha = excel.createCellStyle();
        formatoFecha.setDataFormat((short) 22);
        sismos = excel.getSheet("Sismos");
        personas = excel.getSheet("Personas");
        nuevaFila = sismos.getRow(1);
        cargarSismos();
        adminDatos.setNumeroSismo();
        nuevaFila = personas.getRow(1);
        cargarPersonas();

    }
}
