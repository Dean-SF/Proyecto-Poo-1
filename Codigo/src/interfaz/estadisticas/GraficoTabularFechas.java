//Importaciones
package interfaz.estadisticas;
import datos.Sismo;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static principal.Inicializador.adminDatos;

/**
 * Ventana que crea un panel con un grafico tabular segun los datos de
 * los sismos en un rango de fechas dada por el usuario.
 * @author Esteban
 */
public class GraficoTabularFechas extends JPanel implements ActionListener {
    private JButton volver = new JButton("Volver");
    private JButton graficar = new JButton("Graficar");
    private JLabel anioText = new JLabel("Inicio:");
    private JTextField anio = new JTextField();
    private JLabel anioText2 = new JLabel("Fin:");
    private JTextField anio2 = new JTextField();
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private String [] titulos = {"ID", "Descipcion","Localizacion","Magnitud"};
    private Object [][] datos = {{null,null,null,null}};
    private JTable tabla = new JTable(datos,titulos);
    private JScrollPane pane = new JScrollPane(tabla);
    
    /**
     * Obtioene la priemra fecha del textField
     * @return Calendar con un gregorianCalendar
     */
    private Calendar obtenerFecha1(){
        try{
            int anioF = Integer.parseInt(anio.getText());
            if(anioF<0){
                return null;
            }
            Calendar fecha = new GregorianCalendar(anioF,1,1);
            return fecha;
        } catch (Exception e){
            return null;
        }
    }
    
    /**
     * Obtiene la segunda fecha del textField
     * @return Calendar con un gregorianCalendar
     */
    private Calendar obtenerFecha2(){
        try{
            int anioF = Integer.parseInt(anio2.getText());
            if(anioF<0){
                return null;
            }
            Calendar fecha = new GregorianCalendar(anioF,1,1);
            return fecha;
        } catch (Exception e){
            return null;
        }
    }
    
    /**
     * Carga la tabla con los datos de los sismos ocurridos entre las dos
     * fechas dadas por el usuario
     */
    private void cargarTabla(){
        if(tabla.isVisible()){
            tabla.setVisible(false);
        }
        Calendar anioF = obtenerFecha1();
        Calendar anioF2 = obtenerFecha2();
        if(anioF==null||anioF2==null||(anioF.get(Calendar.YEAR)>anioF2.get(Calendar.YEAR))){
            JOptionPane.showMessageDialog(this, "Debe de ingresar una fecha mayor a cero"
                    + " y inicio debe de ser menor a final","Error",
            JOptionPane.ERROR_MESSAGE);
            return;
      }
        tabla.setVisible(true);
        sismos = adminDatos.getSismos();
        DefaultTableModel modeloTabla = new DefaultTableModel(titulos, sismos.size());
        int j = 0;
        for(int  i = 0; i<sismos.size(); i++){
            //String texto = "";
            Sismo actual = sismos.get(i);
            Calendar actualF = actual.getFechaHora();
            if(actualF.get(Calendar.YEAR)>=anioF.get(Calendar.YEAR)&&
               actualF.get(Calendar.YEAR)<=anioF2.get(Calendar.YEAR)){
                modeloTabla.setValueAt(actual.getId(), j, 0);
                modeloTabla.setValueAt(actual.getDescripcion(), j, 1);
                modeloTabla.setValueAt(actual.getLocalizacion().getProvincia(), j, 2);
                modeloTabla.setValueAt(actual.getMagnitud().getMagnitud(), j, 3);
                j+=1;
            }
        }
        tabla.setModel(modeloTabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(10);
    }
    
    /**
     * Contrucor del panel con los diferentes botones y textFields
     * mas un JTable para agregrar los datos de los sismos.
     */
    public GraficoTabularFechas(){
        this.setBounds(0, 0, 700, 350);
        this.setLayout(null);
               
        pane.setBounds(50, 0, 600, 200);
        tabla.setEnabled(false);
        tabla.setFont(new Font("Copperplate Gothic Light",Font.PLAIN,12));
        tabla.setRowHeight(30);
        this.add(pane);
         
        graficar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficar.setBounds(50,210,130,30);
        graficar.addActionListener(this);
        this.add(graficar);
        
        anioText.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        anioText.setBounds(200,210,130,30);
        this.add(anioText);
        anio.setBounds(200,250,130,30);
        anio.setFont(new Font("SimSun",Font.PLAIN,18));
        this.add(anio);
        
        anioText2.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        anioText2.setBounds(350,210,130,30);
        this.add(anioText2);
        anio2.setBounds(350,250,130,30);
        anio2.setFont(new Font("SimSun",Font.PLAIN,18));
        this.add(anio2);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(500,210,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    /**
     * Contiene los actionListeners de los botones del panel.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            tabla.setVisible(false);
            anio.setText("");
            anio2.setText("");
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            cargarTabla();
        }
    }
}