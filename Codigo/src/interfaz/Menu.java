package interfaz;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel implements ActionListener {
    // Elementos de la ventana menu
    private JLabel bienvenida = new JLabel("BIENVENIDO AL MENU PRINCIPAL");
    private JButton sismos = new JButton("ADMINISTRAR SISMOS");
    private JButton personas = new JButton("ADMINISTRAR PERSONAS");
    public Menu() {
        bienvenida.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        bienvenida.setBounds(20,50,590,25);

        sismos.setFont(new Font("Segoe UI",Font.PLAIN,18));
        sismos.setBounds(180, 100, 260, 80);
        sismos.addActionListener(this);;

        personas.setFont(new Font("Segoe UI",Font.PLAIN,18));
        personas.setBounds(180, 200, 260, 80);
        
        this.setBounds(0, 0, 1280, 720);
        this.setLayout(null);
        this.add(bienvenida);
        this.add(sismos);
        this.add(personas);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sismos) {
            AdministradorVentanas.abrirMenuSismos();
        }
    }
}
