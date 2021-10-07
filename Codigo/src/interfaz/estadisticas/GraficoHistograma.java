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
    private JButton volver = new JButton("Volver");
    //private JLabel provincia = new JLabel("Origen:");
    //private JComboBox<String> cajaProvincia = new JComboBox<String>();
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos;
    //private String lugar;
    private JPanel bar1;
    private boolean siGrafico = false;
    
    private CategoryDataset createDataset() {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      sismos = adminDatos.getSismos();
      int A = 0, C = 0, L = 0, SJ = 0, P = 0, H = 0, G = 0;
      for(Sismo actual : sismos){
          TProvincia sitio = actual.getLocalizacion().getProvincia();
          System.out.println(sitio);
          if(sitio==TProvincia.ALAJUELA){
              A+=1;
              System.out.println("A");
          }else if(sitio==TProvincia.CARTAGO){
              C+=1;
              System.out.println("C");
          }else if(sitio==TProvincia.LIMON){
              L+=1;
          }else if(sitio==TProvincia.SAN_JOSE){
              SJ+=1;
          }else if(sitio==TProvincia.PUNTARENAS){
              P+=1;
          }else if(sitio==TProvincia.HEREDIA){
              H+=1;
          }else if(sitio==TProvincia.GUANACASTE){
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
        return bar;
    }
    
    private JPanel panel(){
        JFreeChart bar = modelo();
        return new ChartPanel(bar);
    }
        
    private void graficar(){
        if(siGrafico){
            this.remove(bar1);
        }
        //lugar = String.valueOf(cajaProvincia.getSelectedItem());
        bar1 = panel();
        bar1.setSize(500,500);
        bar1.setVisible(true);
        this.add(bar1);
        this.updateUI();
        siGrafico=true;
    }
    
    public GraficoHistograma(){
        this.setBounds(0, 0, 500, 600);
        this.setLayout(null);
        
        /*provincia.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        provincia.setBounds(190,520,130,30);
        this.add(provincia);
        
        /*cajaProvincia.setBounds(190,550,130,30);
        cajaProvincia.setFont(new Font("SimSun",Font.PLAIN,18));
        cajaProvincia.addItem("Alajuela");
        cajaProvincia.addItem("Cartago");
        cajaProvincia.addItem("Limon");
        cajaProvincia.addItem("San Jose");
        cajaProvincia.addItem("Puntarenas");
        cajaProvincia.addItem("Heredia");
        cajaProvincia.addItem("Guanacaste");
        this.add(cajaProvincia);*/
        
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
            if(siGrafico){
                bar1.setVisible(false);
                this.remove(bar1);
                siGrafico=false;
            }
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            graficar();
        }
    }
}
