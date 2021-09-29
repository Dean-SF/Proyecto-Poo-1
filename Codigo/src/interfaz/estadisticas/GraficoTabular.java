package interfaz.estadisticas;
   
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import interfaz.AdministradorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

/**
 *
 * @author Esteban
 */
public class GraficoTabular extends JPanel implements ActionListener {
    private JLabel titulo = new JLabel("Grafico tabular");
    private JButton volver = new JButton("Volver");
    private String [] titulos = {"Magnitud", "Tipo"};
    private Object [][] datos = {{1,"1"},{2,"2"},{3,"3"},{3,"3"},{3,"3"},{3,"3"}
    ,{3,"3"},{3,"3"},{3,"3"},{3,"3"},{3,"3"},{3,"3"},{3,"3"}};
    
    /*private DefaultTableModel modelo(){
        DefaultTableModel tabla = new DefaultTableModel(datos,titulos);
        return tabla;
    }
    
    private DefaultTableModel frame(){
        DefaultTableModel tabla = new DefaultTableModel(datos,titulos);
        return tabla;
    }
    
    private JTable panel(){
        DefaultTableModel tabla = frame();
        return new JTable(tabla);
    }*/
    
    public GraficoTabular(){
        this.setBounds(0, 0, 800, 512);
        this.setLayout(null);
           
        /*JTable tabla = new JTable(datos,titulos);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,50));
        tabla.setFillsViewportHeight(true);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
        this.add(tabla);*/
        
        JTable tabla = new JTable(datos,titulos);
        //tabla.setValueAt("Hola", 0, 0);
        JScrollPane pane = new JScrollPane(tabla);
        pane.setBounds(20, 70, 300, 200);
        add(pane);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(650,440,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            AdministradorVentanas.volverAtras();
        }
    }
}
