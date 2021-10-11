//Importaciones
//Default
package interfaz.estadisticas;
//Interfaz
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
//Otros
import java.util.ArrayList;
import datos.Sismo;
import datos.TEscala;
import javax.swing.JOptionPane;
import static principal.Inicializador.adminDatos;

/**
 * Crea una ventana con un grafco tabular que muestra los datos de los sismos segun su magnitud.
 * @author Esteban
 */
public class GraficoTabular extends JPanel implements ActionListener {
    private JButton volver = new JButton("Volver");
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private String [] titulos = {"Escala", "Magnitud","Tipo magnitud","ID","Descipcion","Ubicacion"};
    private Object [][] datos = {{null,null,null,null,null,null}};
    private JTable tabla = new JTable(datos,titulos);
    private JScrollPane pane = new JScrollPane(tabla);
    
    /**
     * Carga un JTable con los datos de los sismos y los etiqueta.
     */
     private void cargarTabla(){
        try{
            tabla.setVisible(true);
            sismos = adminDatos.getSismos();
            DefaultTableModel modeloTabla = new DefaultTableModel(titulos, sismos.size());
            for(int  i = 0; i<sismos.size(); i++){
                String texto = "";
                String tEscala = "";
                Sismo actual = sismos.get(i);
                double numMagnitud = actual.getMagnitud().getMagnitud();
                TEscala escalaActual = actual.getMagnitud().getEscala();
                if(escalaActual==TEscala.MAGNITUD_DE_MOMENTO){
                    texto = "Magnitud momento";
                }else{
                    texto = "Magnitud Richter";
                }
                
                if(numMagnitud<2){
                    tEscala = "Micro";
                }else if(numMagnitud<4){
                    tEscala = "Menor";
                }else if(numMagnitud<5){
                    tEscala =  "Ligero";
                }else if(numMagnitud<6){
                    tEscala = "Moderado";
                }else if(numMagnitud<7){
                    tEscala = "Fuerte";
                }else if(numMagnitud<8){
                    tEscala = "Mayor";
                }else if(numMagnitud<10){
                    tEscala = "Gran";
                }else{
                    tEscala = "Epico";
                }
                modeloTabla.setValueAt(texto, i, 0);
                modeloTabla.setValueAt(actual.getMagnitud().getMagnitud(), i, 1); 
                modeloTabla.setValueAt(tEscala,i,2);
                modeloTabla.setValueAt(actual.getId(), i, 3);
                modeloTabla.setValueAt(actual.getDescripcion(), i, 4);
                modeloTabla.setValueAt(actual.getLocalizacion().getProvincia(), i, 5);
            }
            tabla.setModel(modeloTabla);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Esto no deberia de estar aqui","Error",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
     /**
      * Constructoder de la ventana con los botones y el JTable.
      */
    public GraficoTabular(){
        this.setBounds(0, 0, 700, 300);
        this.setLayout(null);
        
        pane.setBounds(50, 0, 600, 200);
        tabla.setEnabled(false);
        tabla.setFont(new Font("Copperplate Gothic Light",Font.PLAIN,12));
        tabla.setRowHeight(30);
        this.add(pane);
        
        graficar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficar.setBounds(200,210,130,30);
        graficar.addActionListener(this);
        this.add(graficar);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(350,210,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    /**
     * Contiene los actionListeners de los botones del panel.
     * @param e Tipo {@code ActionEvent} con el evento detectado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            tabla.setVisible(false);
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            cargarTabla();
        }
    }
}
