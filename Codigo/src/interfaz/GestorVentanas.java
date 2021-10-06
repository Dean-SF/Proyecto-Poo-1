package interfaz;



import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaz.sismos.AdminSismos;
import interfaz.sismos.MenuSismos;
import interfaz.sismos.MapaSismos;
import interfaz.estadisticas.MenuGraficos;
import interfaz.estadisticas.GraficoBarras;
import interfaz.estadisticas.GraficoHistograma;
import interfaz.estadisticas.GraficoPastel;
import interfaz.estadisticas.GraficoTabular;
import InterfazPersonas.MenuRegister;
import interfaz.estadisticas.GraficoTabularFechas;


/** 
 * Clase AdministradorVentanas: Esta clase
 * Se encarga de administrar las ventanas (JPanel) de
 * toda la interfaz, cada ventana de la interfaz herada
 * de JPanel y se coloca en el JFrame de esta clase.
 * Las ventanas se quedan invisibles y solo es visible
 * la actual. Cada vez que se quiera interactuar con una,
 * se activa su visibilidad y se desactiva la otra.
 * Esta clase se encarga de eso ultimo.
*/

public class GestorVentanas{

    private static JFrame frame = new JFrame(); // Este objeto es el frame principal donde van a ir las ventanas
    
    private ImageIcon icono = new ImageIcon(getClass().getResource("imagenes/earthquake.png")); // Icono del programa

    // Todas las ventanas disponibles de la interfaz:
    private static AdminSismos adminSismos = new AdminSismos();
    private static MenuSismos menuSismos = new MenuSismos();
    private static Menu menu = new Menu();
    private static MenuGraficos menuGraficos = new MenuGraficos();
    private static GraficoBarras barras = new GraficoBarras();
    private static GraficoTabular tabular = new GraficoTabular();
    private static GraficoHistograma histograma = new GraficoHistograma();
    private static GraficoPastel pastel = new GraficoPastel();
    private static MenuRegister registro = new MenuRegister();
    private static GraficoTabularFechas tabularFechas = new GraficoTabularFechas();

    // Historial
    private static Stack<JPanel> pilaVentanas = new Stack<JPanel>();  // Esta pila se llena con las ventanas 
                                                                      // a las que ha ido ingresando el usuario
                                                                      // la que esta por salir es la actual

    // Constructor de la clase:
    public GestorVentanas() {
        // Inicializacion del historial de ventanas
        pilaVentanas.push(menu); // Se guarda menu de primero porque es la ventana actual
        
        // Setup del frame principal
        frame.setTitle("Proyecto - Programación Orientada a Objetos"); // Titulo del frame
        frame.setIconImage(icono.getImage());   // Asignacion del icono del programa
        frame.setSize(640,512);   // tamaño INICIAL del programa
        frame.setResizable(false);   // Imposibilita el poder cambiar su tamaño
        frame.setLayout(null);      // quita el layout manager (todo debe hacerse manual)

        frame.add(menu);    // Agrega la ventana menu
        frame.add(menuSismos); // Agrega la ventana menu de sismos 
        frame.add(adminSismos);
        frame.add(menuGraficos);
        frame.add(barras);
        frame.add(tabular);
        frame.add(histograma);
        frame.add(pastel);
        frame.add(registro);
        frame.add(tabularFechas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hace que cuando se intente cerrar la ventana se 
                                                              // cierre todo el programa
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // la hace visible
    }
    static public void cambiarDimensiones(int x,int y) {
        frame.setSize(x,y);
    }

    // Hace que se pueda volver atras
    static public void volverAtras() {
        JPanel ventanaActual = pilaVentanas.pop();
        ventanaActual.setVisible(false);
        ventanaActual = pilaVentanas.peek();
        frame.setSize(ventanaActual.getSize());
        ventanaActual.setVisible(true);
        
    }
    
    // hace que se pueda abrir el menu de sismos
    static public void abrirMenuSismos() {
        pilaVentanas.push(menuSismos);
        menuSismos.setVisible(true);
        menu.setVisible(false);
        frame.setSize(800,512);
    }

    static public void abrirAgregarSismos(){
        pilaVentanas.push(adminSismos);
        adminSismos.setVisible(true);
        menuSismos.setVisible(false);
        frame.setSize(1280,512);
    }
    static public void verMapaSismos(){
        String url="https://www.google.com/maps/place/9%C2%B003'19.8%22N+84%C2%B001'33.6%22W/";
        MapaSismos.openURL(url);
    }
    
    static public void abrirMenuGraficos(){
        pilaVentanas.push(menuGraficos);
        menuGraficos.setVisible(true);
        menu.setVisible(false);
        frame.setSize(800,512);
    }
    
    static public void abrirGraficoBarras(){
        pilaVentanas.push(barras);
        barras.setVisible(true);
        menuGraficos.setVisible(false);
        frame.setSize(712,650);
    }
    
    static public void abrirGraficoTabular(){
        pilaVentanas.push(tabular);
        tabular.setVisible(true);
        menuGraficos.setVisible(false);
        frame.setSize(700,300);
    }
    
    static public void abrirGraficoHistograma(){
        pilaVentanas.push(histograma);
        histograma.setVisible(true);
        menuGraficos.setVisible(false);
        frame.setSize(512,650);
    }
    
    static public void abrirGraficoPastel(){
        pilaVentanas.push(pastel);
        pastel.setVisible(true);
        menuGraficos.setVisible(false);
        frame.setSize(515,600);
    }
    
    static public void abrirGraficoTabularFechas(){
        pilaVentanas.push(tabularFechas);
        tabularFechas.setVisible(true);
        menuGraficos.setVisible(false);
        frame.setSize(700,300);
    }
    
    static public void abrirMenuRegistro(){
        pilaVentanas.push(registro);
        registro.setVisible(true);
        menu.setVisible(false);
        frame.setSize(800,512);
    }
}