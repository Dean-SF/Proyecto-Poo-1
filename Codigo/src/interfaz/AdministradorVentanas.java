package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaz.sismos.MenuSismos;


public class AdministradorVentanas{
    private static JFrame frame = new JFrame();
    private static JPanel ultimaVentanaAbierta;

    private static MenuSismos menuSismos = new MenuSismos();
    private static Menu menu = new Menu();
    public AdministradorVentanas() {
        frame.setTitle("Proyecto - Programación Orientada A Objetos");
        frame.setIconImage(new ImageIcon("earthquake3.png").getImage());
        frame.setSize(640,512);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(menu);
        frame.add(menuSismos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    static public void cambiarDimensiones(int x,int y) {
        frame.setSize(x,y);
    }

    static public void volverMenu() {
        menu.setVisible(true);
        ultimaVentanaAbierta.setVisible(false);
        frame.setSize(640,512);
    }
    
    static public void abrirMenuSismos() {
        ultimaVentanaAbierta = menuSismos;
        menuSismos.setVisible(true);
        menu.setVisible(false);
        frame.setSize(800,512);
    }
}