//Importaciones
package interfaz.sismos;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaz.AdministradorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase
/**
 *
 * @author Esteban
 */
public class MenuGraficos extends JPanel implements ActionListener{
    private JLabel titulo = new JLabel("Estadicas");
    private JButton provincia = new JButton("Por provincia");
    private JButton origen = new JButton("Por tipo de origen");
    private JButton fechas = new JButton("Rango de fechas");
    private JButton mes = new JButton("Por mes");
    private JButton magnitud = new JButton("Por magnitud");
    private JButton volver = new JButton("Volver");
    
    public MenuGraficos(){
        this.setBounds(0, 0, 800, 512);
        this.setLayout(null);
        
        titulo.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        titulo.setBounds(300,50,700,25);
        this.add(titulo);
        
        provincia.setFont(new Font("Segoe UI",Font.PLAIN,18));
        provincia.setBounds(300, 100, 190, 40);
        provincia.addActionListener(this);
        this.add(provincia);
        
        origen.setFont(new Font("Segoe UI",Font.PLAIN,18));
        origen.setBounds(300, 150, 190, 40);
        origen.addActionListener(this);
        this.add(origen);
        
        fechas.setFont(new Font("Segoe UI",Font.PLAIN,18));
        fechas.setBounds(300, 200, 190, 40);
        fechas.addActionListener(this);
        this.add(fechas);
        
        mes.setFont(new Font("Segoe UI",Font.PLAIN,18));
        mes.setBounds(300, 250, 190, 40);
        mes.addActionListener(this);
        this.add(mes);
        
        magnitud.setFont(new Font("Segoe UI",Font.PLAIN,18));
        magnitud.setBounds(300, 300, 190, 40);
        magnitud.addActionListener(this);
        this.add(magnitud);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(650,440,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == provincia) {
 
        }else if(e.getSource() == origen){
  
        }else if(e.getSource() == fechas){

        }else if(e.getSource() == mes){

        }else if(e.getSource() == magnitud){

        }else if(e.getSource() == volver){
            AdministradorVentanas.volverAtras();
        }
    }
}
