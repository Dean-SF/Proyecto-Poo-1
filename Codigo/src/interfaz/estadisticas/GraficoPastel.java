package interfaz.estadisticas;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
 *
 * @author Esteban
 */
public class GraficoPastel extends JPanel implements ActionListener {
    private JLabel titulo = new JLabel("Pastel");
    private JButton volver = new JButton("Volver");
    
    private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Subduccion 18.18%" , 20);
      dataset.setValue( "coque de placas 22,72%" , 25);
      dataset.setValue( "Tectonico por falla local 36.36%" , 40);
      dataset.setValue( "Intra placa 13.63%" , 15);
      dataset.setValue( "Deformacion interna 9.09%" , 10);
      return dataset;
   }
    
    private JFreeChart modelo(){
        JFreeChart pie = ChartFactory.createPieChart("Provincias", createDataset(), true, true, true);
        return pie;
    }
    
    private JPanel panel(){
        JFreeChart pie = modelo();
        return new ChartPanel(pie);
    }
    
    public GraficoPastel(){
        this.setBounds(0, 0, 800, 600);
        this.setLayout(null);
        
        titulo.setBounds(300,50,700,25);
        /*titulo.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        this.add(titulo);*/
        
        JPanel pie = panel();
        pie.setSize(500,500);
        pie.setVisible(true);
        this.add(pie);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(200,520,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            GestorVentanas.volverAtras();
        }
    }
}
