package interfaz.sismos;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.AdministradorVentanas;

public class AgregarSismos extends JPanel implements ActionListener{
    private JLabel presentacion = new JLabel("AGREGAR SISMO");
    // Elementos de la ventana
    private JLabel fecha = new JLabel("Fecha:");

    private JLabel dia = new JLabel("Dia:");
    private JTextField campoDia = new JTextField();

    private JLabel mes = new JLabel("Mes:");
    private JTextField campoMes = new JTextField();

    private JLabel año = new JLabel("Año:");
    private JTextField campoAño = new JTextField();

    private JLabel profundidad = new JLabel("Profundidad:");
    private JTextField campoProfundidad = new JTextField();

    private JLabel origen = new JLabel("Origen:");
    private JComboBox<String> campoOrigen = new JComboBox<String>();

    private JLabel magnitud = new JLabel("magnitud:");
    private JTextField campoMagnitud = new JTextField();


    // Boton para volver al menu principal
    private JButton volver = new JButton("Volver");
    public AgregarSismos() {

        presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        presentacion.setBounds(180,25,290,25);

        fecha.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        fecha.setBounds(10,50,100,25);

        dia.setFont(new Font("SimSun",Font.PLAIN,20));
        dia.setBounds(25,80,100,25);
        campoDia.setBounds(70,80,25,25);
        campoDia.setFont(new Font("SimSun",Font.PLAIN,18));

        mes.setFont(new Font("SimSun",Font.PLAIN,20));
        mes.setBounds(100,80,100,25);
        campoMes.setBounds(145,80,25,25);
        campoMes.setFont(new Font("SimSun",Font.PLAIN,18));

        año.setFont(new Font("SimSun",Font.PLAIN,20));
        año.setBounds(175,80,100,25);
        campoAño.setBounds(220,80,43,25);
        campoAño.setFont(new Font("SimSun",Font.PLAIN,18));

        profundidad.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        profundidad.setBounds(10,120,150,25);
        campoProfundidad.setFont(new Font("SimSun",Font.PLAIN,18));
        campoProfundidad.setBounds(150,120,100,25);

        origen.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        origen.setBounds(10,155,100,35);
        campoOrigen.setBounds(95,162,250,25);
        campoOrigen.setFont(new Font("SimSun",Font.PLAIN,18));
        campoOrigen.addItem("Subduccion");
        campoOrigen.addItem("Choque de placas");
        campoOrigen.addItem("Tectonico Por falla Local");
        campoOrigen.addItem("Intra placa");
        campoOrigen.addItem("Deformacion Interna");

        magnitud.setBounds(10,195,150,35);
        magnitud.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        campoMagnitud.setBounds(120,195,150,35);
        campoMagnitud.setFont(new Font("SimSun",Font.PLAIN,18));

        volver.setFont(new Font("OCR A Extended",Font.PLAIN,20));
        volver.setBounds(600,440,130,30);
        volver.addActionListener(this);

        this.setBounds(0, 0, 640, 512);
        this.setLayout(null);
        this.add(presentacion);

        this.add(fecha);
        this.add(dia);
        this.add(campoDia);
        this.add(mes);
        this.add(campoMes);
        this.add(año);
        this.add(campoAño);

        this.add(profundidad);
        this.add(campoProfundidad);

        this.add(origen);
        this.add(campoOrigen);

        this.add(magnitud);
        this.add(campoMagnitud);

        this.add(volver);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == volver) {
            AdministradorVentanas.volverAtras();
        }
    }
}
