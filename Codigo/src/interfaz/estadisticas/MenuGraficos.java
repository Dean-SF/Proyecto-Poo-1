//Importaciones
package interfaz.estadisticas;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase
/**
 * Ventana con las opciones para crear diferentes graficos
 * se encarga de llamar a los metodos correspondientes de gestorVentanas
 * @author Esteban
 */
public class MenuGraficos extends JPanel implements ActionListener{
    private JLabel titulo = new JLabel("Estadisticas de sismos");
    private JButton provincia = new JButton("Por provincia");
    private JButton origen = new JButton("Por tipo de origen");
    private JButton fechas = new JButton("Rango de fechas");
    private JButton mes = new JButton("Por mes");
    private JButton magnitud = new JButton("Por magnitud");
    private JButton volver = new JButton("Volver");
    
    /**
     * Contructor para el panel con las opciones a todos los graficos
     */
    public MenuGraficos(){
        this.setBounds(0, 0, 800, 512);
        this.setLayout(null);
        
        titulo.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        titulo.setBounds(170,50,700,25);
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
    
    /**
     * Contiene los actionListeners de los botones del panel
     * que llaman a las funciones del gestorVentanas.
     * @param e Tipo {@code ActionEvent} con el evento detectado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == provincia) {
                GestorVentanas.abrirGraficoHistograma();
        }else if(e.getSource() == origen){
                GestorVentanas.abrirGraficoPastel();
        }else if(e.getSource() == fechas){
                GestorVentanas.abrirGraficoTabularFechas();
        }else if(e.getSource() == mes){
               GestorVentanas.abrirGraficoBarras();
        }else if(e.getSource() == magnitud){
                GestorVentanas.abrirGraficoTabular();
        }else if(e.getSource() == volver){
            GestorVentanas.volverAtras();
        }
    }
}
