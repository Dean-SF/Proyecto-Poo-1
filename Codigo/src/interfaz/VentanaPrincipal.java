package interfaz;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
    static Menu menu = new Menu();
    public VentanaPrincipal() {
        this.setSize(640,512);
        this.setResizable(false);
        this.setLayout(null);
        this.add(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}