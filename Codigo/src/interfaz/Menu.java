package interfaz;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
    private JLabel bienvenida = new JLabel("BIENVENIDO AL MENU PRINCIPAL");
    private JButton sismos = new JButton("ADMINISTRAR SISMOS");
    private JButton personas = new JButton("ADMINISTRAR PERSONAS");
    public Menu() {
        bienvenida.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        bienvenida.setBounds(20,50,590,25);

        sismos.setFont(new Font("Segoe UI",Font.PLAIN,18));
        sismos.setBounds(180, 100, 260, 80);

        personas.setFont(new Font("Segoe UI",Font.PLAIN,18));
        personas.setBounds(180, 200, 260, 80);

        this.setBounds(0, 0, 1280, 720);
        this.setLayout(null);
        this.add(bienvenida);
        this.add(sismos);
        this.add(personas);
    }   
}
