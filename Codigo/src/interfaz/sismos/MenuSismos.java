package interfaz.sismos;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.GestorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * Clase MenuSismos: Contiene las opciones para realizar
 * ACME a sismos
*/
public class MenuSismos extends JPanel implements ActionListener{
    // Elementos de la ventana
    private JLabel presentacion = new JLabel("SELECCIONE LA OPCION QUE DESEA:");
    private JButton agregar = new JButton("Agregar un sismo");
    private JButton consultar = new JButton("Consultar un sismo");
    private JButton modificar = new JButton("Modificar un sismo");
    private JButton eliminar = new JButton("Eliminar un sismo");
    private JButton verMapa = new JButton("Ver Mapa");

    // Boton para volver al menu principal
    private JButton volver = new JButton("Volver");

    //Constructor
    public MenuSismos(){
        
        // Letra y ubicaciones de los elementos de la ventana, para los 
        // botones se incluye el ActionListener
        presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        presentacion.setBounds(70,50,700,25);

        agregar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        agregar.setBounds(300, 100, 190, 40);
        agregar.addActionListener(this);

        consultar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        consultar.setBounds(300, 150, 190, 40);
        consultar.addActionListener(this);

        modificar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        modificar.setBounds(300, 200, 190, 40);
        modificar.addActionListener(this);

        eliminar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        eliminar.setBounds(300, 250, 190, 40);
        eliminar.addActionListener(this);
        
        verMapa.setFont(new Font("Segoe UI",Font.PLAIN,18));
        verMapa.setBounds(300, 350, 190, 40);
        verMapa.addActionListener(this);

        volver.setFont(new Font("OCR A Extended",Font.PLAIN,20));
        volver.setBounds(650,440,130,30);
        volver.addActionListener(this);

        // Setup de la ventna
        this.setBounds(0, 0, 800, 512);
        this.setLayout(null);

        // Se agregan los elementos
        this.add(presentacion);

        this.add(agregar);
        this.add(consultar);
        this.add(modificar);
        this.add(eliminar);
        this.add(verMapa);

        this.add(volver);

        // Se hace invisible puesto a que no es necesaria su aparicion de primera
        this.setVisible(false);
    }
    /** 
     * Clase actionPerformed: Administra los eventos ocurridos en la ventana
     * @return no tiene retorno
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver) {
            GestorVentanas.volverAtras();
        } else if(e.getSource() == agregar){
            GestorVentanas.abrirAgregarSismos();
        }
        else if(e.getSource() == verMapa){
            GestorVentanas.verMapaSismos();
        }
        
    }
}
