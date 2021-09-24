/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazPersonas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import interfaz.AdministradorVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author DMV
 */
public class MenuRegister extends JPanel implements ActionListener {
    private JLabel presentacion = new JLabel("REGISTRARSE");
    
    private JLabel labelNombre = new JLabel("Nombre:");
    private JTextField nombre = new JTextField();
    
    private JLabel labelNumero = new JLabel("Numero:");
    private JTextField numero = new JTextField();
    
    private JLabel labelCorreo = new JLabel("Correo Electronico:");
    private JTextField correo = new JTextField();
    
    //Lista de provincias para suscribirse
    private JLabel labelProvincias = new JLabel("Provincias de Interes:");
    private JCheckBox sanjose = new JCheckBox("San José");
    private JCheckBox cartago = new JCheckBox("Cartago");
    private JCheckBox alajuela = new JCheckBox("Alajuela");
    private JCheckBox heredia = new JCheckBox("Heredia");
    private JCheckBox limon = new JCheckBox("Limón");
    private JCheckBox puntarenas = new JCheckBox("Puntarenas");
    private JCheckBox guanacaste =new  JCheckBox("Guanacaste");
    //botones aceptar y volver
    private JButton aceptar = new JButton("Aceptar");
    private JButton volver = new JButton("Volver");
    
    public MenuRegister(){
    presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,25));
    presentacion.setBounds(320,25,250,25);
    //Nombre
    labelNombre.setFont(new Font("Segoe UI",Font.PLAIN,18));
    labelNombre.setBounds(10,70,100,25);
    nombre.setFont(new Font("Segoe UI",Font.PLAIN,18));
    nombre.setBounds(25,100,150,25);
    //Numero
    labelNumero.setFont(new Font("Segoe UI",Font.PLAIN,18));
    labelNumero.setBounds(10,130,100,25);
    numero.setFont(new Font("Segoe UI",Font.PLAIN,18));
    numero.setBounds(25,160,100,25);
    //Correo
    labelCorreo.setFont(new Font("Segoe UI",Font.PLAIN,18));
    labelCorreo.setBounds(10,195,150,25);
    correo.setFont(new Font("Segoe UI",Font.PLAIN,18));
    correo.setBounds(25,225,150,25);
    //Provincias
    labelProvincias.setFont(new Font("Segoe UI",Font.PLAIN,18));
    labelProvincias.setBounds(400,70,200,25);
    sanjose.setFont(new Font("Segoe UI",Font.PLAIN,18));
    sanjose.setBounds(400,100,200,25);
    cartago.setFont(new Font("Segoe UI",Font.PLAIN,18));
    cartago.setBounds(400,130,200,25);
    alajuela.setFont(new Font("Segoe UI",Font.PLAIN,18));
    alajuela.setBounds(400,160,200,25);
    heredia.setFont(new Font("Segoe UI",Font.PLAIN,18));
    heredia.setBounds(400,190,200,25);
    limon.setFont(new Font("Segoe UI",Font.PLAIN,18));
    limon.setBounds(400,220,200,25);
    puntarenas.setFont(new Font("Segoe UI",Font.PLAIN,18));
    puntarenas.setBounds(400,250,200,25);
    guanacaste.setFont(new Font("Segoe UI",Font.PLAIN,18));
    guanacaste.setBounds(400,280,200,25);
    // Boton de volver
    aceptar.setFont(new Font("OCR A Extended",Font.PLAIN,20));
    aceptar.setBounds(405,440,130,30);
    aceptar.addActionListener(this);
    // Boton de volver
    volver.setFont(new Font("OCR A Extended",Font.PLAIN,20));
    volver.setBounds(605,440,130,30);
    volver.addActionListener(this);
    // Tamaño de la ventana y Layout manager
    this.setBounds(0, 0, 765, 512);
    this.setLayout(null);
    //Agrega todo a la ventana
    this.add(presentacion);
    this.add(labelNombre);
    this.add(nombre);
    this.add(labelNumero);
    this.add(numero);
    this.add(labelCorreo);
    this.add(correo);
    this.add(labelProvincias);
    this.add(sanjose);
    this.add(cartago);
    this.add(alajuela);
    this.add(heredia);
    this.add(limon);
    this.add(puntarenas);
    this.add(guanacaste);
    this.add(volver);
    this.add(aceptar);
    this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver) {
            AdministradorVentanas.volverAtras();
        }
    }
    
}
