package interfaz.estadisticas;
   
import datos.Sismo;
import datos.TEscala;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import static principal.Inicializador.adminDatos;

/**
 *
 * @author Esteban
 */
public class GraficoTabularFechas extends JPanel implements ActionListener {
    private JButton volver = new JButton("Volver");
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private String [] titulos = {"Magnitud", "Escala","ID","Descipcion"};
    private Object [][] datos = {{null,null,null,null}};
    private JTable tabla = new JTable(datos,titulos);
    private JScrollPane pane = new JScrollPane(tabla);
    
    private void cargarTabla(){
        sismos = adminDatos.getSismos();
        DefaultTableModel modeloTabla = new DefaultTableModel(titulos, sismos.size());
        for(int  i = 0; i<sismos.size(); i++){
            String texto = "";
            Sismo actual = sismos.get(i);
            TEscala escalaActual = actual.getMagnitud().getEscala();
            if(escalaActual==TEscala.MAGNITUD_DE_MOMENTO){
                texto = "Magnitud momento";
            }else{
                texto = "Magnitud Richter";
            }
            modeloTabla.setValueAt(texto, i, 0);
            modeloTabla.setValueAt(actual.getMagnitud().getMagnitud(), i, 1); 
            modeloTabla.setValueAt(actual.getId(), i, 2);
            modeloTabla.setValueAt(actual.getDescripcion(), i, 3);
        }
        tabla.setModel(modeloTabla);
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    public GraficoTabularFechas(){
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            cargarTabla();
        }
    }
}