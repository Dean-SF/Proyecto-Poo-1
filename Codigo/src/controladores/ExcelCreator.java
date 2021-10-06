package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;

import static principal.Inicializador.adminDatos;

public class ExcelCreator {
    private File archivo = new File("src/principal/datos.xlsx");
    private XSSFWorkbook excel;
    private XSSFSheet sismos;
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
        formatoFecha = excel.createCellStyle();
        formatoFecha.setDataFormat((short) 22);
        cargarCabeza();
        
        
    }

    private void cargarCabeza() {
        nuevaFila = sismos.createRow(0);
        String[] cabeza = {"ID","Fecha","Magnitud","Profundidad","Origen","Provincia",
                           "Descripcion","Latitud","Longitud"};

        for(int i = 0; i < 9; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            nuevaCelda.setCellValue(cabeza[i]);
        }
    }

    private void guardarExcel() throws IOException {
        for(int i = 0; i < 9; i++) {
            sismos.autoSizeColumn(i);
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

    private void cargarExcel() throws InvalidFormatException, IOException {
        excel = new XSSFWorkbook(new FileInputStream(archivo));
        formatoFecha = excel.createCellStyle();
        formatoFecha.setDataFormat((short) 22);
        sismos = excel.getSheet("Sismos");
        nuevaFila = sismos.getRow(1);

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
        adminDatos.setNumeroSismo();
    }
}
