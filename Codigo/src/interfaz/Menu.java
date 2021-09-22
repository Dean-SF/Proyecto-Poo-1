package interfaz;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * Clase Menu: esta contiene el menu principal del programa
 * contiene las opciones y es la primer ventana disponible
*/
public class Menu extends JPanel implements ActionListener {
    // Elementos de la ventana menu
    private JLabel bienvenida = new JLabel("BIENVENIDO AL MENU PRINCIPAL");
    private JButton sismos = new JButton("ADMINISTRAR SISMOS");
    private JButton personas = new JButton("ADMINISTRAR PERSONAS");
    private JButton graficos = new JButton("ESTADISTICAS DE SISMOS");
    
    public Menu() {

        // Letra y ubicacion del Label de bienvenida
        bienvenida.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        bienvenida.setBounds(20,50,590,25);

        // Letra, ubicacion y ActionListener del boton sismos
        sismos.setFont(new Font("Segoe UI",Font.PLAIN,18));
        sismos.setBounds(180, 100, 260, 80);
        sismos.addActionListener(this); // Un ActionListener es una clase abstracta que al crearse recibe un evento y
                                        // ejecuta una accion

        // Letra, ubicacion y ActionListener del boton sismos
        personas.setFont(new Font("Segoe UI",Font.PLAIN,18));
        personas.setBounds(180, 200, 260, 80);
        personas.addActionListener(this);
        
        // Letra, ubicacion y ActionListener del boton de graficos
        graficos.setFont(new Font("Segoe UI",Font.PLAIN,18));
        graficos.setBounds(180, 300, 260, 80);
        graficos.addActionListener(this);  
        
        // Setup de la ventana
        this.setBounds(0, 0, 640, 512);
        this.setLayout(null);

        // Se añaden los elementos de la ventan
        this.add(bienvenida);
        this.add(sismos);
        this.add(personas);
        this.add(graficos);

        // Se hace visible puesto a que es la primera ventana que se visualiza
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sismos) {
            AdministradorVentanas.abrirMenuSismos();
        }else if(e.getSource()==graficos){
            AdministradorVentanas.abrirMenuGraficos();
        }
    }
}
