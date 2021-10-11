package interfaz.estadisticas;

import datos.Sismo;
import datos.TOrigen;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import interfaz.GestorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import static principal.Inicializador.adminDatos;


/**
 * Crea una ventana para mostrar en grafico pastel segun el origen de los sismos.
 * @author Esteban
 */
public class GraficoPastel extends JPanel implements ActionListener {
    private JButton volver = new JButton("Volver");
    private JButton graficar = new JButton("Graficar");
    private ArrayList<Sismo> sismos = new ArrayList<Sismo>();
    private JPanel pie1;
    private boolean siGrafico = false;
    
    /**
     * Saca el porcentaje de un numero segun el total
     * @param dato Tipo {@code int} numero a sacar el porcentaje
     * @param total Tipo {@code int}
     * @return double
     */
    private double por(int dato, int total){
        double por = (100*dato)/total;
        return por;
    }
    
    /**
     * Crea el dataset a ser utilizado por el grafico en base a el origen de los sismos.
     * @return PieDataset
     */
    private PieDataset createDataset( ) {
        try{
            sismos = adminDatos.getSismos();
            int S = 0, C = 0, T = 0, I = 0, D = 0;
            for(Sismo actual : sismos){
                if(actual.getOrigen()==TOrigen.SUBDUCION){
                    S+=1;
                }else if(actual.getOrigen()==TOrigen.CHOQUE_DE_PLACAS){
                    C+=1;
                }else if(actual.getOrigen()==TOrigen.TECTONICO_POR_FALLA_LOCAL){
                    T+=1;
                }else if(actual.getOrigen()==TOrigen.INTRA_PLACA){
                    I+=1;
                }else{
                    D+=1;
                }
            }
            int total = S+C+T+I+D;
            DefaultPieDataset dataset = new DefaultPieDataset( );
            dataset.setValue( "Subduccion "+por(S,total)+"%" , S);
            dataset.setValue( "Coque de placas "+por(C,total)+"%" , C);
            dataset.setValue( "Tectonico por falla local "+por(T,total)+"%" , T);
            dataset.setValue( "Intra placa "+por(I,total)+"%" , I);
            dataset.setValue( "Deformacion interna "+por(D,total)+"%" , D);
            return dataset;
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Esto no deberia de estar aqui","Error",
            JOptionPane.ERROR_MESSAGE);
            return null;
        }
   }
    
    /**
     * Crea un pieChart con el dataset.
     * @return JFreeChart
     */
    private JFreeChart modelo(){
        JFreeChart pie = ChartFactory.createPieChart("Provincias", createDataset(), true, true, true);
        return pie;
    }
    
    /**
     * Crea un JPanel con el modelo del grafico pastel.
     * @return JPanel 
     */
    private JPanel panel(){
        JFreeChart pie = modelo();
        return new ChartPanel(pie);
    }
    
    /**
     * Agrega el panel de grafico al panel principal.
     */
    private void graficar(){
        if(siGrafico){
            this.remove(pie1);
        }
        pie1 = panel();
        pie1.setSize(500,500);
        pie1.setVisible(true);
        this.add(pie1);
        this.updateUI();
        siGrafico=true;
    }
    
    /**
     * Contructor del panel con los diferentes botones.
     */
    public GraficoPastel(){
        this.setBounds(0, 0, 800, 600);
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
     * @param e Tipo {@code ActionEvent} con el evento detectado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver){
            if(siGrafico){
                pie1.setVisible(false);
                this.remove(pie1);
                siGrafico=false;
            }
            GestorVentanas.volverAtras();
        }else if(e.getSource() == graficar){
            graficar();
        }
    }
}
