/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import controladores.EnvioCorreo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
/**
 *
 * @author DMV
 */
public class DatosPersonas {
    //Aqui creaba el excel con las personas registradas 
    /*public static void CrearExcel(String nombre,String Correo,String numero,String ID, List provincias){
        
        List<Persona> personas = new ArrayList<Persona>();
        String provincii = "";
         personas = LeerExcel2();
         
         personas.add(new Persona(ID,nombre, Correo, numero, provincias));
         for(int e = 0; e < personas.size(); e++){
                System.out.println(personas.get(e));
                provincii = personas.get(e).getProvincias().toString();
                System.out.println(provincii);
            }
         String[] header = {"Nombre","Número","Correo","San José","Cartago","Alajuela","Heredia","Limón","Puntarenas","Guanacaste"};
         XSSFWorkbook libro = new XSSFWorkbook();
         XSSFSheet hoja = libro.createSheet("Personas");
         CellStyle style = libro.createCellStyle();
         
         XSSFRow row = hoja.createRow(0);//se crea las filas
         
         for (int i = 0; i < header.length; i++) {
            XSSFCell cell = row.createCell(i);//se crea las celdas para la cabecera, junto con la posicion
            cell.setCellStyle(style);
            
            cell.setCellValue(header[i]);//se añade el contenido	

        }
        for(int i = 0; i < personas.size(); i++){
            //------------------------------------------------------
            String sanjose = "no";
            String alajuela = "no";
            String cartago = "no";
            String heredia = "no";
            String limon = "no";
            String puntarenas = "no";
            String guanacaste = "no";
            
            if(provincias.contains(TProvincia.SAN_JOSE)){
                sanjose = "si";
                provincias.remove(TProvincia.SAN_JOSE);
            }
            if(provincias.contains(TProvincia.CARTAGO)){
                cartago = "si";
                provincias.remove(TProvincia.CARTAGO);
            }
            if(provincias.contains(TProvincia.ALAJUELA)){
                alajuela = "si";
                provincias.remove(TProvincia.ALAJUELA);
            }
            if(provincias.contains(TProvincia.HEREDIA)){
                heredia = "si";
                provincias.remove(TProvincia.HEREDIA);
            }
            if(provincias.contains(TProvincia.LIMON)){
                limon = "si";
                provincias.remove(TProvincia.LIMON);
            }
            if(provincias.contains(TProvincia.PUNTARENAS)){
                puntarenas = "si";
                provincias.remove(TProvincia.PUNTARENAS);
            }
            if(provincias.contains(TProvincia.GUANACASTE)){
                guanacaste = "si";
                provincias.remove(TProvincia.GUANACASTE);
            }
            //-------------------------------------------------------------------
            row = hoja.createRow(i+1);//se crea las filas
            for (int j = 0; j < header.length; j++) {
            XSSFCell cell = row.createCell(j);//se vuelven a crear las celdas para la cabecera, despues de leer los datos dentro del excel
            switch(j){//switch para agregar el nombre,numero y correo
            case 0:
                
                cell.setCellValue(personas.get(i).getNombre());//se añade el contenido
                break;
            case 1:
                
                cell.setCellValue(personas.get(i).getCelular());//se añade el contenido
                break;
            case 2:
               
                cell.setCellValue(personas.get(i).getCorreo());//se añade el contenido
                break;
            case 3:
                cell.setCellValue(provincii);
                break;
            case 4:
                cell.setCellValue(cartago);
                break;
            case 5:
                cell.setCellValue(alajuela);
                break;
            case 6:
                cell.setCellValue(heredia);
                break;
            case 7:
                cell.setCellValue(limon);
                break;
            case 8:
                cell.setCellValue(puntarenas);
                break;
            case 9:
                cell.setCellValue(guanacaste);
                break;
            
            default:
                break;
            }
            }
        } 
         //XSSFCell celda = fila.createCell(0);
         //celda.setCellValue(nombre.getText());
         String file = "PersonasRegistradas2.xlsx";
         try (FileOutputStream out = new FileOutputStream(file)){
             libro.write(out);
         }
         catch(IOException e)
         {
             System.err.println(e.getMessage());
         }
    
    }*/
    //Este era el excel de prueba donde se guardaban las personas registradas, todo funcionaba menos poder traer las provincias interesadas
    /*public static List<Persona> LeerExcel2(){
            List personas = new ArrayList();
            List provincias = new ArrayList();
            String nombreArchivo = "PersonasRegistradas.xlsx";
		String rutaArchivo = nombreArchivo;
		String hoja = "personas";
                String nombre = "";
                String correo = "";
                String provinciaLeida;
                String numero = "";
                
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
                        
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
                        
			Row row;
                        row = rowIterator.next();
                        
                        List<String> index = new ArrayList<>();
                        
                        
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell cellInd;
                        while (cellIterator.hasNext()) {
                            cellInd = cellIterator.next();
                            index.add(cellInd.getStringCellValue());
                        }
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				cellIterator = row.cellIterator();
                                Cell cell;
                                
				//se recorre cada celda
                                int numInd = 0;
				while (cellIterator.hasNext()) {
                                    
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
                                        switch (index.get(numInd)) {
                                            case "Nombre":
                                                nombre = (cell.getStringCellValue());
                                                
                                                break;
                                            case "Numero":
                                                numero = (cell.getStringCellValue());
                                                break;
                                            case "Correo":
                                                correo = (cell.getStringCellValue());
                                                break;
                                            case "San José":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.SAN_JOSE);
                                                }
                                                break;
                                            case "Cartago":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.CARTAGO);
                                                }
                                                break;
                                            case "Alajuela":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.ALAJUELA);
                                                }
                                                break;
                                            case "Heredia":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.HEREDIA);
                                                }
                                                break;
                                            case "Limón":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.LIMON);
                                                }
                                                break;
                                            case "Puntarenas":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.PUNTARENAS);
                                                }
                                                break;
                                            case "Guanacaste":
                                                provinciaLeida = (cell.getStringCellValue());
                                               
                                                if (provinciaLeida.equals("si")){
                                                    provincias.add(TProvincia.GUANACASTE);
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        numInd++;
					System.out.println("1 " + provincias);
                                        
				}
				personas.add(new Persona("",nombre, correo, numero,provincias));
                                System.out.println(personas);
                                System.out.println("2 " +provincias);
                                provincias.clear();
			}
                        
                        
		} catch (Exception e) {
			e.getMessage();
		}
            return personas;
    }*/
    //Este metodo lee el excel que tiene a nosotros y a la profe registrados y envia el correo a cada interesado, se ejecuta automaticamente al agregar un sismo
    public static void LeerExcel(TProvincia provincia){
        String provinciaSismo = "";
        switch(provincia){
            case SAN_JOSE:
                provinciaSismo = "San José";
                break;
            case CARTAGO:
                provinciaSismo = "Cartago";
                break;
            case HEREDIA:
                provinciaSismo = "Heredia";
                break;
            case ALAJUELA:
                provinciaSismo = "Alajuela";
                break;
            case PUNTARENAS:
                provinciaSismo = "Puntarenas";
                break;
            case LIMON:
                provinciaSismo = "Limón";
                break;
            case GUANACASTE:
                provinciaSismo = "Guanacaste";
                break;
            default:
                break;
        }
        
        String nombreArchivo = "PersonasRegistradas.xlsx";
		String rutaArchivo = nombreArchivo;
		String hoja = "personas";
                String nombre = "";
                String correo = "";
                String provinciaLeida;
                String numero = "";
                
		try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
			// leer archivo excel
                        
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
                        
			Row row;
                        row = rowIterator.next();
                        
                        List<String> index = new ArrayList<>();
                        
                        
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell cellInd;
                        while (cellIterator.hasNext()) {
                            cellInd = cellIterator.next();
                            index.add(cellInd.getStringCellValue());
                        }
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				cellIterator = row.cellIterator();
                                Cell cell;
                                
				//se recorre cada celda
                                int numInd = 0;
				while (cellIterator.hasNext()) {
					// se obtiene la celda en específico y se la imprime
					cell = cellIterator.next();
                                        switch (index.get(numInd)) {
                                            case "Nombre":
                                                nombre = (cell.getStringCellValue());
                                                break;
                                            case "Numero":
                                                numero = (cell.getStringCellValue());
                                                break;
                                            case "Correo":
                                                correo = (cell.getStringCellValue());
                                                break;
                                            case "San José":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "San José"){
                                                    EnvioCorreo.enviar(nombre,correo,"San José");
                                                }
                                                break;
                                            case "Cartago":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Cartago"){
                                                    EnvioCorreo.enviar(nombre,correo,"Cartago");
                                                }
                                                break;
                                            case "Alajuela":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Alajuela"){
                                                    EnvioCorreo.enviar(nombre,correo,"Alajuela");
                                                }
                                                break;
                                            case "Heredia":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Heredia"){
                                                    EnvioCorreo.enviar(nombre,correo,"Heredia");
                                                }
                                                break;
                                            case "Limón":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Limón"){
                                                    EnvioCorreo.enviar(nombre,correo,"Limón");
                                                }
                                                break;
                                            case "Puntarenas":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Puntarenas"){
                                                    EnvioCorreo.enviar(nombre,correo,"Puntarenas");
                                                }
                                                break;
                                            case "Guanacaste":
                                                provinciaLeida = (cell.getStringCellValue());
                                                if (provinciaLeida.equals("Sí")&& provinciaSismo == "Guanacaste"){   
                                                    EnvioCorreo.enviar(nombre,correo,"Guanacaste");
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        numInd++;  
				}	
			}   
		} catch (Exception e) {
			e.getMessage();
		}
    }
}
