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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Esteban
 */
public class GraficoHistograma extends JPanel implements ActionListener{
    private JLabel titulo = new JLabel("Histograma");
    private JButton volver = new JButton("Volver");
    
    private static CategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.setValue(20,"", "Alajuela");
      dataset.setValue(25,"", "Cartago");
      dataset.setValue(40,"", "Limon");
      dataset.setValue(15,"", "San Jose");
      dataset.setValue(10,"", "Puntarenas");
      dataset.setValue(0,"", "Heredia");
      return dataset;
   }
    
    private JFreeChart modelo(){
        JFreeChart bar = ChartFactory.createBarChart("Provincias", "", "Cantidad sismos", createDataset());
        //si hay para el histograma
        return bar;
    }
    
    private JPanel panel(){
        JFreeChart bar = modelo();
        return new ChartPanel(bar);
    }
    
    public GraficoHistograma(){
        this.setBounds(0, 0, 800, 600);
        this.setLayout(null);
        
        titulo.setBounds(290,50,700,40);
        /*titulo.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        this.add(titulo);*/
        
        JPanel bar = panel();
        bar.setSize(500,500);
        bar.setVisible(true);
        this.add(bar);
        
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
