package interfaz.estadisticas;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;
import datos.Sismo;
import static principal.Inicializador.adminDatos;
import datos.TProvincia;

/**
 *
 * @author Esteban
 */
public class GraficoHistograma extends JPanel implements ActionListener{
    private JLabel titulo = new JLabel("Histograma");
    private JButton volver = new JButton("Volver");
    private JLabel provincia = new JLabel("Origen:");
    private JComboBox<String> cajaProvincia = new JComboBox<String>();
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos;
    private String lugar;
    
    private CategoryDataset createDataset() {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      sismos = adminDatos.getSismos();
      int A = 0, C = 0, L = 0, SJ = 0, P = 0, H = 0, G = 0;
      for(Sismo actual : sismos){
          TProvincia sitio = actual.getLocalizacion().getProvincia();
          System.out.println(sitio);
          if("Alajuela".equals(lugar) && sitio==TProvincia.ALAJUELA){
              A+=1;
              System.out.println("A");
          }else if("Cartago".equals(lugar) && sitio==TProvincia.CARTAGO){
              C+=1;
              System.out.println("C");
          }else if("Limon".equals(lugar) && sitio==TProvincia.LIMON){
              L+=1;
          }else if("San Jose".equals(lugar) && sitio==TProvincia.SAN_JOSE){
              SJ+=1;
          }else if("Puntarenas".equals(lugar) && sitio==TProvincia.PUNTARENAS){
              P+=1;
          }else if("Heredia".equals(lugar) && sitio==TProvincia.HEREDIA){
              H+=1;
          }else if("Guanacaste".equals(lugar) && sitio==TProvincia.GUANACASTE){
              G+=1;
          }
          System.out.println("Listo");
      }
      dataset.setValue(A,"", "Alajuela");
      dataset.setValue(C,"", "Cartago");
      dataset.setValue(L,"", "Limon");
      dataset.setValue(SJ,"", "San Jose");
      dataset.setValue(P,"", "Puntarenas");
      dataset.setValue(H,"", "Heredia");
      dataset.setValue(G,"", "Guanacaste");
      return dataset;
   }
    
    private JFreeChart modelo(){
        JFreeChart bar = ChartFactory.createBarChart("Provincias", "", "Cantidad sismos", createDataset());
        //JFreeChart bar = ChartFactory.createHistogram("Provincias", "", "Cantidad sismos", createDataset(), PlotOrientation.VERTICAL, true, true, true);
        return bar;
    }
    
    private JPanel panel(){
        JFreeChart bar = modelo();
        return new ChartPanel(bar);
    }
        
    private void graficar(){
        lugar = String.valueOf(cajaProvincia.getSelectedItem());
        JPanel bar = panel();
        bar.setSize(500,500);
        bar.setVisible(true);
        this.add(bar);
    }
    
    public GraficoHistograma(){
        this.setBounds(0, 0, 500, 600);
        this.setLayout(null);
        
        provincia.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        provincia.setBounds(190,520,130,30);
        this.add(provincia);
        
        cajaProvincia.setBounds(190,550,130,30);
        cajaProvincia.setFont(new Font("SimSun",Font.PLAIN,18));
        cajaProvincia.addItem("Alajuela");
        cajaProvincia.addItem("Cartago");
        cajaProvincia.addItem("Limon");
        cajaProvincia.addItem("San Jose");
        cajaProvincia.addItem("Puntarenas");
        cajaProvincia.addItem("Heredia");
        cajaProvincia.addItem("Guanacaste");
        this.add(cajaProvincia);
        
        graficar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficar.setBounds(10,520,130,30);
        graficar.addActionListener(this);
        this.add(graficar);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(350,520,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            graficar();
        }
    }
}
