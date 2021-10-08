//Importaciones
//Default
package interfaz.estadisticas;
//Interfaz
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
//Otros
import java.util.ArrayList;
import datos.Sismo;
import static principal.Inicializador.adminDatos;
import datos.TProvincia;
import javax.swing.JOptionPane;

/**
 * Ventana que crea un grafico histograma segun los sismos por provincia en adminDatos. 
 * @author Esteban
 */
public class GraficoHistograma extends JPanel implements ActionListener{
    private JButton volver = new JButton("Volver");
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos;
    private JPanel bar1;
    private boolean siGrafico = false;
    
    /**
     * Crea un dataset con los sismos por privincia para agregarlos al panel
     * @return CategoryDataset
     */
    private CategoryDataset createDataset() {
        try{
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            sismos = adminDatos.getSismos();
            int A = 0, C = 0, L = 0, SJ = 0, P = 0, H = 0, G = 0;
            for(Sismo actual : sismos){
                TProvincia sitio = actual.getLocalizacion().getProvincia();
                if(sitio==TProvincia.ALAJUELA){
                    A+=1;
                }else if(sitio==TProvincia.CARTAGO){
                    C+=1;
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
            }
            dataset.setValue(A,"", "Alajuela");
            dataset.setValue(C,"", "Cartago");
            dataset.setValue(L,"", "Limon");
            dataset.setValue(SJ,"", "San Jose");
            dataset.setValue(P,"", "Puntarenas");
            dataset.setValue(H,"", "Heredia");
            dataset.setValue(G,"", "Guanacaste");
            return dataset;
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Esto no deberia de estar aqui","Error",
            JOptionPane.ERROR_MESSAGE);
            return null;
        }
   }
    
    /**
     * Crea un barChart con ChartFactoy y toma los datos de un dataset.
     * @return JFreeChart
     */
    private JFreeChart modelo(){
        JFreeChart bar = ChartFactory.createBarChart("Provincias", "", "Cantidad sismos", createDataset());
        return bar;
    }
    
    /**
     * Crea un panel con el modelo del grafico.
     * @return JPanel
     */
    private JPanel panel(){
        JFreeChart bar = modelo();
        return new ChartPanel(bar);
    }
    
    /**
     * Annade el panel de grafico al JPanel principal.
     */
    private void graficar(){
        if(siGrafico){
            this.remove(bar1);
        }
        bar1 = panel();
        bar1.setSize(500,500);
        bar1.setVisible(true);
        this.add(bar1);
        this.updateUI();
        siGrafico=true;
    }
    
    /**
     * Contructor del JPanel principal con dos botones y el espacio para el grafico.
     */
    public GraficoHistograma(){
        this.setBounds(0, 0, 500, 600);
        this.setLayout(null);
        
        graficar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficar.setBounds(100,520,130,30);
        graficar.addActionListener(this);
        this.add(graficar);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(250,520,130,30);
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
