/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.personas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import interfaz.GestorVentanas;
import datos.TProvincia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static principal.Inicializador.adminDatos;
import static principal.Inicializador.excel;

/**
 * Ventana creada para el registro de las personas a las cuales se les enviara un correo a la hora de
 * registrar un sismo
 * @author DMV
 */
public class AdminPersonas extends JPanel implements ActionListener {
    private JLabel presentacion = new JLabel("REGISTRARSE");
    
    private JLabel labelNombre = new JLabel("Nombre:");
    private JTextField nombre = new JTextField();
    
    private JLabel labelNumero = new JLabel("Numero:");
    private JTextField numero = new JTextField();
    
    private JLabel labelCorreo = new JLabel("Correo Electronico:");
    private JTextField correo = new JTextField();
    
    private JLabel labelID = new JLabel("ID:");
    private JTextField id = new JTextField();
    
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
    
    public AdminPersonas(){
        presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,25));
        presentacion.setBounds(310,25,250,25);
        //Nombre
        labelNombre.setFont(new Font("Segoe UI",Font.PLAIN,18));
        labelNombre.setBounds(10,70,100,25);
        nombre.setFont(new Font("Segoe UI",Font.PLAIN,18));
        nombre.setBounds(25,100,150,25);
        //id
        labelID.setFont(new Font("Segoe UI",Font.PLAIN,18));
        labelID.setBounds(10,130,100,25);
        id.setFont(new Font("Segoe UI",Font.PLAIN,18));
        id.setBounds(25,160,150,25);
        //Numero
        labelNumero.setFont(new Font("Segoe UI",Font.PLAIN,18));
        labelNumero.setBounds(10,190,100,25);
        numero.setFont(new Font("Segoe UI",Font.PLAIN,18));
        numero.setBounds(25,220,100,25);
        //Correo
        labelCorreo.setFont(new Font("Segoe UI",Font.PLAIN,18));
        labelCorreo.setBounds(10,255,150,25);
        correo.setFont(new Font("Segoe UI",Font.PLAIN,18));
        correo.setBounds(25,285,250,25);
        
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
        this.add(labelID);
        this.add(id);
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
            GestorVentanas.volverAtras();
        }
        if(e.getSource()== aceptar){
            agregarPersona();
            
        }
    }
    private void clear() {
        id.setText("");
        nombre.setText("");
        numero.setText("");
        correo.setText("");
        sanjose.setSelected(false);
        cartago.setSelected(false);
        alajuela.setSelected(false);
        heredia.setSelected(false);
        limon.setSelected(false);
        puntarenas.setSelected(false);
        guanacaste.setSelected(false);
    }

    public void agregarPersona(){
        if(verificarNombre() == -1){
            JOptionPane.showMessageDialog(this, "FAVOR INTRODUZCA UN NOMBRE","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(verificarid() == -1){//verifica que el id no esté vacio y sean numeros enteros
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(verificarNumero() == -1){
            JOptionPane.showMessageDialog(this, "EL NÚMERO INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(verificarCorreo()=="-1"){//verifica que el correo no esté vacio y sea formato valido
            JOptionPane.showMessageDialog(this, "EL CORREO INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(verificarProvincias()) {
            JOptionPane.showMessageDialog(this, "SELECCIONE AL MENOS UNA PROVINCIA","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int id = Integer.parseInt(this.id.getText());
        int celular;
        if(numero.getText().equals("")){
            celular = -1;
        } else {
            celular = Integer.parseInt(numero.getText());
        }
        String correo = this.correo.getText();
        if(correo.equals("")) {
            correo = "N/A";
        }
        if(correo.equals("N/A") && celular == -1) {
            JOptionPane.showMessageDialog(this, "COLOQUE EL NUMERO O EL CORREO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<TProvincia> provincias = crearListaProvincias();
        boolean resultado = adminDatos.agregarPersona(id, nombre.getText(), correo, celular, provincias);
        if(!resultado) {
            JOptionPane.showMessageDialog(this, "EL ID YA SE ENCUENTRA REGISTRADO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            excel.agregarUltimaPersona();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "OCURRIO EL ERROR '" + e.getMessage() + 
                "' A LA HORA DE GUARDAR EN EL EXCEL","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this, "SE AGREGO LA PERSONA","ENHORABUENA",JOptionPane.INFORMATION_MESSAGE);
        clear();
    }
    private int verificarNombre(){
        String string = nombre.getText();
        if(string.isBlank())
            return -1;
        return 1;
    }
    private int verificarNumero(){
        String string = numero.getText();
        if(string.isBlank()){
            return 0;
        }
        if(string.length() != 8) {
            return -1;
        }
        try { // try_catch verifica si este string es valido para ser un entero
            int number = Integer.parseInt(string);
            if(number <= 0) {
                return -1;
            }
            return number;

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int verificarid(){
        String string = id.getText();
        try { // try_catch verifica si este string es valido para ser un entero
            int id = Integer.parseInt(string);
            if(id <= 0 || string.length() != 9) {
                return -1;
            }
            return id;

        } catch (NumberFormatException e) {
            return -1;
        }
    }
    private String verificarCorreo(){
        if(correo.getText().matches("^[\\w.\\-]+\\@[\\w.\\-]+\\.[a-zA-z]{2,6}$") || correo.getText().isBlank()){    
            return correo.getText();
        }else{
            return "-1";
        }
    }

    private boolean verificarProvincias() {
        if(!sanjose.isSelected() && !cartago.isSelected() && !alajuela.isSelected() && !heredia.isSelected() && 
        !limon.isSelected() && !puntarenas.isSelected() && !guanacaste.isSelected()) {
            return true;
        }
        return false;
    }

    private List<TProvincia> crearListaProvincias(){
        List<TProvincia> provincias = new ArrayList<TProvincia>();
        if(sanjose.isSelected())
            provincias.add(TProvincia.SAN_JOSE);
        if(cartago.isSelected())
            provincias.add(TProvincia.CARTAGO);
        if(alajuela.isSelected())
            provincias.add(TProvincia.ALAJUELA);
        if(heredia.isSelected())
            provincias.add(TProvincia.HEREDIA);
        if(limon.isSelected())
            provincias.add(TProvincia.LIMON);
        if(puntarenas.isSelected())
            provincias.add(TProvincia.PUNTARENAS);
        if(guanacaste.isSelected())
            provincias.add(TProvincia.GUANACASTE);
        return provincias;
    }
}
