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
import java.util.ArrayList;
import datos.Sismo;
import static principal.Inicializador.adminDatos;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;

/**
 *
 * @author Esteban
 */
public class GraficoBarras extends JPanel implements ActionListener{
    private JButton volver = new JButton("Volver");
    private JLabel anioText = new JLabel("Año:");
    private JTextField anio = new JTextField();
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos;
    private JPanel bar1;
    private boolean siGrafico = false;
    
    private Calendar obtenerFecha(){
        int anioF = Integer.parseInt(anio.getText());
        if(anioF<0||anioF>3000){
            //Hacer error.
        }
        Calendar fecha = new GregorianCalendar(anioF,1,1);
        return fecha;
    }
    
    private CategoryDataset createDataset() {
      Calendar anioF = obtenerFecha();
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      sismos = adminDatos.getSismos();
      int E = 0, F = 0, M = 0, A = 0, Ma = 0, J = 0, Ju = 0, Ag = 0, S = 0, O = 0, N = 0, D = 0;
      for(Sismo actual : sismos){
        Calendar actualF = actual.getFechaHora();
        if(anioF.get(Calendar.YEAR)==actualF.get(Calendar.YEAR)){ 
            if(actualF.get(Calendar.MONTH)==0){
                E+=1;
            }else if(actualF.get(Calendar.MONTH)==1){
                F+=1;
            }else if(actualF.get(Calendar.MONTH)==2){
                M+=1;
            }else if(actualF.get(Calendar.MONTH)==3){
                A+=1;
            }else if(actualF.get(Calendar.MONTH)==4){
                Ma+=1;
            }else if(actualF.get(Calendar.MONTH)==5){
                J+=1;
            }else if(actualF.get(Calendar.MONTH)==6){
                Ju+=1;
            }else if(actualF.get(Calendar.MONTH)==7){
                Ag+=1;
            }else if(actualF.get(Calendar.MONTH)==8){
                S+=1;
            }else if(actualF.get(Calendar.MONTH)==9){
                O+=1;
            }else if(actualF.get(Calendar.MONTH)==10){
                N+=1;
            }else if(actualF.get(Calendar.MONTH)==11){
                D+=1;
            }
        }
      }
      dataset.setValue(E,"", "Enero");
      dataset.setValue(F,"", "Febrero");
      dataset.setValue(M,"", "Marzo");
      dataset.setValue(A,"", "Abril");
      dataset.setValue(Ma,"", "Mayo");
      dataset.setValue(J,"", "Junio");
      dataset.setValue(Ju,"", "Julio");
      dataset.setValue(Ag,"", "Agosto");
      dataset.setValue(S,"", "Septiembre");
      dataset.setValue(O,"", "Octubre");
      dataset.setValue(N,"", "Noviemnbre");
      dataset.setValue(D,"", "Diciembre");
      return dataset;
   }
    
    private JFreeChart modelo(){
        JFreeChart bar = ChartFactory.createBarChart("Meces", "", "Cantidad sismos", createDataset());
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
        bar1 = panel();
        bar1.setSize(700,500);
        bar1.setVisible(true);
        this.add(bar1);
        this.updateUI();
        siGrafico=true;
    }
    
    public GraficoBarras(){
        this.setBounds(0, 0, 700, 600);
        this.setLayout(null);
        
        anioText.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        anioText.setBounds(290,520,130,30);
        this.add(anioText);
        
        anio.setBounds(290,550,130,30);
        anio.setFont(new Font("SimSun",Font.PLAIN,18));
        this.add(anio);
        
        graficar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficar.setBounds(110,520,130,30);
        graficar.addActionListener(this);
        this.add(graficar);
        
        volver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        volver.setBounds(450,520,130,30);
        volver.addActionListener(this);
        this.add(volver);
        
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            if(siGrafico){
                bar1.setVisible(false);
                anio.setText("");
                this.remove(bar1);
                siGrafico=false;
            }
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            graficar();
        }
    }
}
