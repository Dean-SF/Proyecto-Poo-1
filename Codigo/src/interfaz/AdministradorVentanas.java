package interfaz;

import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaz.sismos.MenuSismos;

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

public class AdministradorVentanas{
    private static JFrame frame = new JFrame(); // Este objeto es el frame principal donde van a ir las ventanas
    
    private ImageIcon icono = new ImageIcon(getClass().getResource("imagenes/earthquake.png")); // Icono del programa

    // Todas las ventanas disponibles de la interfaz:
    private static MenuSismos menuSismos = new MenuSismos();
    private static Menu menu = new Menu();

    // Historial
    private static Stack<JPanel> pilaVentanas = new Stack<JPanel>();  // Esta pila se llena con las ventanas 
                                                                      // a las que ha ido ingresando el usuario
                                                                      // la que esta por salir es la actual

    // Constructor de la clase:
    public AdministradorVentanas() {
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hace que cuando se intente cerrar la ventana se 
                                                              // cierre todo el programa
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
        ventanaActual.setVisible(true);
        frame.setSize(ventanaActual.getSize());
    }
    
    // hace que se pueda abrir el menu de sismos
    static public void abrirMenuSismos() {
        pilaVentanas.push(menuSismos);
        menuSismos.setVisible(true);
        menu.setVisible(false);
        frame.setSize(800,512);
    }
}