/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.sismos;

/**
 *
 * @author DMV
 */
import chrriis.dj.nativeswing.swtimpl.*;
import chrriis.dj.nativeswing.swtimpl.components.*;
import interfaz.GestorVentanas;

import java.awt.BorderLayout;
import javax.swing.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
//Esta clase crea el mapa de sismos en un ventana de navegador dentro del mismo java

public class MapaSismos extends JFrame{

    private ImageIcon icono = new ImageIcon(getClass().getResource("imagenes/earthquake.png")); // Icono del programa

    //este metodo crea el navegador recibiendo una url
    public MapaSismos(String url){
        JPanel panelBrowser = new JPanel();
        panelBrowser.setLayout(new BorderLayout());
        final JWebBrowser browser = new JWebBrowser();
        browser.setBarsVisible(false);
        browser.navigate(url);
        panelBrowser.add(browser);
        setTitle("Proyecto - Mapa");
        setIconImage(icono.getImage());
        add(panelBrowser);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                GestorVentanas.setVisibilidad(false);
        
            }

            @Override
            public void windowClosed(WindowEvent e) {
                GestorVentanas.setVisibilidad(true);
        
            }
        });
    }

    //este metodo invoca al navegador 
    public static void abrirNavegador(String url){
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MapaSismos nav = new MapaSismos(url);
                nav.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nav.setVisible(true);
                nav.setSize(980, 700); 
                nav.setLocationRelativeTo(null);
            }
        });
    }

    


}