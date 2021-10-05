package controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import datos.Sismo;

import static principal.Inicializador.adminDatos;

public class ExcelCreator {
    private XSSFWorkbook excel = new XSSFWorkbook();
    private XSSFSheet sismos = excel.createSheet("Sismos");
    //private XSSFSheet personas = excel.createSheet("Personas");
    private File archivo = new File("src/principal/datos.xlsx");
    private CellStyle formatoFecha = excel.createCellStyle();
    private CellStyle formatoDefault = excel.createCellStyle();
    private Row nuevaFila;
    private Cell nuevaCelda;

    public ExcelCreator(){
        nuevaFila = sismos.createRow(0);
        String[] cabeza = {"ID","Fecha","Magnitud","Profundidad","Origen","Provincia",
                           "Descripcion","Latitud","Longitud"};

        for(int i = 0; i < 9; i++) {
            nuevaCelda = nuevaFila.createCell(i);
            nuevaCelda.setCellValue(cabeza[i]);
        }

        formatoFecha.setDataFormat((short) 22);
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

    
}
