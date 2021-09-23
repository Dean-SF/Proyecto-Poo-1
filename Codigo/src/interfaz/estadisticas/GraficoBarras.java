package interfaz.estadisticas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaz.AdministradorVentanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Esteban
 */
public class GraficoBarras extends JPanel implements ActionListener {
    private JLabel titulo = new JLabel("Grafico de barras");
    private JButton volver = new JButton("Volver");
    
    
    public GraficoBarras(){
        this.setBounds(0, 0, 800, 512);
        this.setLayout(null);
        
        titulo.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        titulo.setBounds(300,50,700,25);
        this.add(titulo);
        
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
