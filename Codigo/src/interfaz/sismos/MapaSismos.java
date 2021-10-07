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
import java.awt.BorderLayout;
import javax.swing.*;
//Esta clase crea el mapa de sismos en un ventana de navegador dentro del mismo java

public class MapaSismos extends JFrame{
    private String url;
    //este metodo crea el navegador recibiendo una url
    public MapaSismos(String url){
        this.url = url;
        JPanel panelBrowser = new JPanel();
        panelBrowser.setLayout(new BorderLayout());
        final JWebBrowser browser = new JWebBrowser();
        browser.navigate(url);
        panelBrowser.add(browser);
        add(panelBrowser);
    }
    public void setUrl(String url) {
        this.url = url;
    }
    //este metodo invoca al navegador 
    public static void abrirNavegador(String url){
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MapaSismos nav = new MapaSismos(url);
                nav.setUrl(url);
                nav.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                nav.setVisible(true);
                nav.setSize(900, 900);
                
            }
    });
    }


}   