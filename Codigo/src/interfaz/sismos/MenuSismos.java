package interfaz.sismos;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.AdministradorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSismos extends JPanel implements ActionListener{
    private JLabel presentacion = new JLabel("SELECCIONE LA OPCION QUE DESEA:");
    private JButton agregar = new JButton("Agregar un sismo");
    private JButton consultar = new JButton("Consultar un sismo");
    private JButton modificar = new JButton("Modificar un sismo");
    private JButton eliminar = new JButton("Eliminar un sismo");

    // Boton para volver al menu principal
    private JButton volver = new JButton("Volver");
    public MenuSismos(){
        
        presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        presentacion.setBounds(70,50,700,25);

        agregar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        agregar.setBounds(300, 100, 190, 40);

        consultar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        consultar.setBounds(300, 150, 190, 40);

        modificar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        modificar.setBounds(300, 200, 190, 40);

        eliminar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        eliminar.setBounds(300, 250, 190, 40);


        volver.setFont(new Font("OCR A Extended",Font.PLAIN,20));
        volver.setBounds(650,440,130,30);
        volver.addActionListener(this);

        this.setBounds(0, 0, 1280, 720);
        this.setLayout(null);
        this.add(presentacion);

        this.add(agregar);
        this.add(consultar);
        this.add(modificar);
        this.add(eliminar);

        this.add(volver);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver) {
            AdministradorVentanas.volverMenu();
        }
        
    }
}
