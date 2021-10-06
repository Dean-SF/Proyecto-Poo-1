package interfaz.sismos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.TModificacion;
import interfaz.GestorVentanas;
import datos.Sismo;
import datos.TOrigen;
import datos.TProvincia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static principal.Inicializador.adminDatos;

/** 
 * @author Deyan Sanabria
 * Clase que contiene la ventana de administrar sismos, esta ventana provee la funcionalidad e informacion
 * suficiente para poder agregar, eliminar y modificar sismos, ademas de presentar una lista de todos los
 * sismos que hay hasta el momento
*/
public class AdminSismos extends JPanel implements ActionListener{
    private JLabel presentacion = new JLabel("AGREGAR SISMO");

    // Elementos de la ventana
    // Parte de registro:
    private JLabel fecha = new JLabel("Fecha:");

    private JLabel dia = new JLabel("Dia:");
    private JTextField campoDia = new JTextField();

    private JLabel mes = new JLabel("Mes:");
    private JTextField campoMes = new JTextField();

    private JLabel año = new JLabel("Año:");
    private JTextField campoAnnio = new JTextField();

    private JLabel hora = new JLabel("Hora:");

    private JLabel horas = new JLabel("Hora:");
    private JTextField campoHoras = new JTextField();

    private JLabel minutos = new JLabel("Minuto:");
    private JTextField campoMinutos = new JTextField();

    private JLabel segundos = new JLabel("Segundo:");
    private JTextField campoSegundos = new JTextField();

    private JLabel profundidad = new JLabel("Profundidad:");
    private JTextField campoProfundidad = new JTextField();

    private JLabel origen = new JLabel("Origen:");
    private JComboBox<String> campoOrigen = new JComboBox<String>();

    private JLabel magnitud = new JLabel("Magnitud:");
    private JTextField campoMagnitud = new JTextField();

    private JLabel localizacion = new JLabel("Localizacion:");

    private JLabel latitud = new JLabel("Latitud:");
    private JTextField campoLatitud = new JTextField();

    private JLabel longitud = new JLabel("Longitud:");
    private JTextField campoLongitud = new JTextField();

    private JLabel provincia = new JLabel("Provincia:");
    private JComboBox<String> campoProvincia = new JComboBox<String>();

    private JLabel descripcion = new JLabel("Descripcion:");
    private JTextArea campoDescripcion = new JTextArea();
    private JScrollPane scrollDescripcion = new JScrollPane(campoDescripcion);

    // Parte de visualizacion
    private String [] nombreColumnas = {"ID","Fecha","Hora","Mag.","Prof.","Localizacion","Lat.","Long."};
    private Object [][] vacio = {{null,null,null,null,null,null,null,null}};
    private JTable tabla = new JTable(vacio,nombreColumnas);
    private JScrollPane panelScroll = new JScrollPane(tabla);

    // Botones de agregar, modificar y eliminar
    private JButton agregar = new JButton("Agregar");
    private JButton eliminar = new JButton("Eliminar");
    private JButton modificar = new JButton("Modificar");
    private JButton ver = new JButton("Ver Sismo");
    private JLabel id = new JLabel("ID:");
    private JTextField idCampo = new JTextField();


    // Boton para volver al menu principal
    private JButton volver = new JButton("Volver");
    public AdminSismos() {

        /*
        Registro de datos del sismo: Esta parte incluye todo lo relacionado al registro de un sismo
        con espacios de todos sus datos
        */

        // Titulo de la ventana
        presentacion.setFont(new Font("OCR A Extended",Font.PLAIN,34));
        presentacion.setBounds(235,25,290,25);

        // Fecha
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
        campoAnnio.setBounds(220,80,43,25);
        campoAnnio.setFont(new Font("SimSun",Font.PLAIN,18));

        // Hora
        hora.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        hora.setBounds(10,110,100,25);

        horas.setFont(new Font("SimSun",Font.PLAIN,20));
        horas.setBounds(25,140,100,25);
        campoHoras.setBounds(75,140,25,25);
        campoHoras.setFont(new Font("SimSun",Font.PLAIN,18));

        minutos.setFont(new Font("SimSun",Font.PLAIN,20));
        minutos.setBounds(105,140,100,25);
        campoMinutos.setBounds(175,140,25,25);
        campoMinutos.setFont(new Font("SimSun",Font.PLAIN,18));

        segundos.setFont(new Font("SimSun",Font.PLAIN,20));
        segundos.setBounds(205,140,100,25);
        campoSegundos.setBounds(285,140,25,25);
        campoSegundos.setFont(new Font("SimSun",Font.PLAIN,18));

        // Profundidad
        profundidad.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        profundidad.setBounds(10,175,150,25);
        campoProfundidad.setFont(new Font("SimSun",Font.PLAIN,18));
        campoProfundidad.setBounds(150,175,100,25);

        // Origen
        origen.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        origen.setBounds(10,207,100,35);
        campoOrigen.setBounds(95,214,250,25);
        campoOrigen.setFont(new Font("SimSun",Font.PLAIN,18));
        campoOrigen.addItem("Subduccion");
        campoOrigen.addItem("Choque de placas");
        campoOrigen.addItem("Tectonico Por falla Local");
        campoOrigen.addItem("Intra placa");
        campoOrigen.addItem("Deformacion Interna");

        // Magnitud
        magnitud.setBounds(10,250,150,35);
        magnitud.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        campoMagnitud.setBounds(120,250,150,35);
        campoMagnitud.setFont(new Font("SimSun",Font.PLAIN,18));

        // Localizacion
        localizacion.setBounds(10,290,150,35);
        localizacion.setFont(new Font("Segoe UI Light",Font.PLAIN,25));

        latitud.setBounds(25,325,100,25);
        latitud.setFont(new Font("SimSun",Font.PLAIN,20));
        campoLatitud.setBounds(105,325,80,25);     
        campoLatitud.setFont(new Font("SimSun",Font.PLAIN,18));

        longitud.setBounds(190,325,100,25);
        longitud.setFont(new Font("SimSun",Font.PLAIN,20));
        campoLongitud.setBounds(280,325,80,25);  
        campoLongitud.setFont(new Font("SimSun",Font.PLAIN,18));

        provincia.setBounds(365,325,100,25);
        provincia.setFont(new Font("SimSun",Font.PLAIN,20));
        campoProvincia.setBounds(465,325,120,25);
        campoProvincia.setFont(new Font("SimSun",Font.PLAIN,18));
        campoProvincia.addItem("San José");
        campoProvincia.addItem("Alajuela");
        campoProvincia.addItem("Cartago");
        campoProvincia.addItem("Heredia");
        campoProvincia.addItem("Guanacaste");
        campoProvincia.addItem("Puntarenas");
        campoProvincia.addItem("Limón");

        descripcion.setFont(new Font("SimSun",Font.PLAIN,20));
        descripcion.setBounds(25,355,120,25);
        campoDescripcion.setFont(new Font("SimSun",Font.PLAIN,18));
        scrollDescripcion.setBounds(150,355,450,100);
        campoDescripcion.setLineWrap(true);
        campoDescripcion.setWrapStyleWord(true);

        /*
        Parte de visualizacion de sismos: Tabla tipo excel dentro del programa para visualizar
        todos los datos de los sismos
        */
        panelScroll.setBounds(650, 50, 600, 300);
        tabla.setEnabled(false);
        tabla.setFont(new Font("Copperplate Gothic Light",Font.PLAIN,12));
        tabla.setRowHeight(30);
        /*
        Parte de botones de funcionalidad: Botones de agregar, eliminar y modificar
        */
        agregar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        agregar.setBounds(610,440,130,30);
        agregar.addActionListener(this);

        eliminar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        eliminar.setBounds(750,440,130,30);
        eliminar.addActionListener(this);
        
        modificar.setFont(new Font("Segoe UI",Font.PLAIN,18));
        modificar.setBounds(890,440,130,30);
        modificar.addActionListener(this);
        //boton para ver un sismo, hay que acomodarlo mejor
        ver.setFont(new Font("Segoe UI",Font.PLAIN,18));
        ver.setBounds(800,400,150,30);
        ver.addActionListener(this);

        id.setFont(new Font("SimSun",Font.PLAIN,20));
        id.setBounds(610,400,30,30);
        idCampo.setFont(new Font("SimSun",Font.PLAIN,18));
        idCampo.setBounds(640,400,90,30);

        // Boton de volver
        volver.setFont(new Font("OCR A Extended",Font.PLAIN,20));
        volver.setBounds(1130,440,130,30);
        volver.addActionListener(this);

        // Tamaño de la ventana y Layout manager
        this.setBounds(0, 0, 1280, 512);
        this.setLayout(null);
        
        // Agregado de todos los elementos de la ventana
        this.add(presentacion);

        this.add(fecha);
        this.add(dia);
        this.add(campoDia);
        this.add(mes);
        this.add(campoMes);
        this.add(año);
        this.add(campoAnnio);

        this.add(hora);
        this.add(horas);
        this.add(campoHoras);
        this.add(minutos);
        this.add(campoMinutos);
        this.add(segundos);
        this.add(campoSegundos);

        this.add(profundidad);
        this.add(campoProfundidad);

        this.add(origen);
        this.add(campoOrigen);

        this.add(magnitud);
        this.add(campoMagnitud);

        this.add(localizacion);
        this.add(latitud);
        this.add(campoLatitud);
        this.add(longitud);
        this.add(campoLongitud);
        this.add(provincia);
        this.add(campoProvincia);
        this.add(descripcion);
        this.add(scrollDescripcion);

        this.add(panelScroll);

        this.add(agregar);
        this.add(eliminar);
        this.add(modificar);
        this.add(ver);
        this.add(id);
        this.add(idCampo);

        this.add(volver);

        // La hace invisible
        this.setVisible(false);
    }

    /** 
     * Metodo que administra la funcionalidad de los botones de la ventana
     * @return no retorna
    */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Boton para volver atras
        if(e.getSource() == volver) {
            GestorVentanas.volverAtras();
        }

        // Boton para agregar sismo
        else if(e.getSource() == agregar) {
            agregarSismo();
        }

        // Boton para eliminar sismo
        else if(e.getSource() == eliminar) {
            eliminarSismo();
        }

        // Boton para modificar sismo
        else if(e.getSource() == modificar) {
            modificarSismo();
            cargarTabla();
        }
        else if(e.getSource() == ver){
            verSismo();
            
        }

    }

    /** 
     * Metodo que carga los elementos de la tabla presente en la ventana, coloca todos
     * los sismos en una tabla
     * @param no tiene parametros
     * @return no retorna
    */
    public void cargarTabla() {
        ArrayList<Sismo> sismos = adminDatos.getSismos(); // Se obtiene la lista de sismos

        // Creacion del modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, sismos.size());

        // Ciclo que coloca los datos de cada sismo en la tabla
        for(int i = 0; i < sismos.size(); i++) {

            // Se obtiene el sismo
            Sismo actual = sismos.get(i); 
            
            // Agregados del modelo de la tabla, por cada columna se agrega un elemento distinto
            // la fila actual es decidida por el ciclo for
            modeloTabla.setValueAt(actual.getId(), i, 0);
            modeloTabla.setValueAt(actual.stringFecha(), i, 1);
            modeloTabla.setValueAt(actual.stringHora(), i, 2);
            modeloTabla.setValueAt(actual.stringMagnitud(), i, 3);
            modeloTabla.setValueAt(actual.stringProfundidad(), i, 4);
            modeloTabla.setValueAt(actual.stringLocalizacion(), i, 5);
            modeloTabla.setValueAt(actual.getLongitud(), i, 6);
            modeloTabla.setValueAt(actual.getLatitud(), i, 7);
        }
        // Se coloca el modelo a la tabla
        tabla.setModel(modeloTabla);

        // Se se cambia el tamaño de cada columna de la tabla para mejor visualizacion
        tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(95);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(65);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(58);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(58);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(55);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(55);
    }
    
    /** 
     * Metodo para agregar un sismo a la lista de sismos, esto por medio de un objeto de la clase Administrador
    */
    private void agregarSismo() {
        Calendar fechaHora = verificarFechaHora();
            if(fechaHora == null) {
                JOptionPane.showMessageDialog(this, "POR FAVOR VERIFIQUE LA FECHA Y LA HORA","ERROR",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(verificarNumeros(campoMagnitud.getText()) || verificarNumeros(campoProfundidad.getText())) {
                JOptionPane.showMessageDialog(this, "POR FAVOR VERIFIQUE LA MAGNITUD Y PROFUNDIDAD","ERROR",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(verificarCoordenadas(campoLatitud.getText()) || verificarCoordenadas(campoLongitud.getText())) {
                JOptionPane.showMessageDialog(this, "POR FAVOR VERIFIQUE LA LONGITUD Y LATITUD","ERROR",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Profundidad
            double profundidad = Double.parseDouble(campoProfundidad.getText());
    
            // Magnitud
            double magnitud = Double.parseDouble(campoMagnitud.getText());

            // Latitud Longitud
            double latitud = Double.parseDouble(campoLatitud.getText());
            double longitud = Double.parseDouble(campoLongitud.getText());

            // Descripcion
            String descripcion = campoDescripcion.getText();

            // Provincia y origen
            String provincia = String.valueOf(campoProvincia.getSelectedItem());
            String origen = String.valueOf(campoOrigen.getSelectedItem());
            TProvincia province = provinciaEnum(provincia);
            TOrigen origin = origenEnum(origen);

            boolean verificacion = adminDatos.agregarSismo(fechaHora, profundidad, origin, 
            magnitud, latitud, longitud, province, descripcion);
            if(!(verificacion)) {
                JOptionPane.showMessageDialog(this, "NO PUEDEN EXISTIR SISMOS CON MISMAS FECHAS Y HORAS","ERROR",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

            cargarTabla();
    }


    /**
     * Metodo que verifica si la fecha y hora estan en el formato correcto usando los metodos {@link #verificarFecha()}
     * y {@link #verificarHora()}
     * @return un objeto tipo {@code Calendar}, en caso de que este en un mal formato retorna {@code null}
    */
    private Calendar verificarFechaHora() {

        // Se usan los metodos para verificar las partes de la hora y la fecha
        Calendar fechaHora = verificarFecha();
        int[] hora = verificarHora();

        // se comprueba que estas sean varlidad
        if(fechaHora == null || hora == null) {
            return null;
        }

        // Se realizan los cambios y se retorna
        fechaHora.set(Calendar.HOUR_OF_DAY,hora[0]);
        fechaHora.set(Calendar.MINUTE,hora[1]);
        fechaHora.set(Calendar.SECOND,hora[2]);
        return fechaHora;
    }

    /**
     * Metodo que verifica la fecha ingresada en la ventana
     * @return objeto tipo {@code Calendar} en caso que sea correcto y {@code null} en caso de que sea incorrecto
     */
    private Calendar verificarFecha() {
        try {
            int mes = Integer.parseInt(campoMes.getText());
            int dia = Integer.parseInt(campoDia.getText());
            int annio = Integer.parseInt(campoAnnio.getText());
            Calendar fecha = new GregorianCalendar(annio, mes-1, dia);
            // Si el objeto tipo calendar no tiene los datos a como entraron, significa que este intento
            // compensar los datos que se pasaban del rango y quedo una fecha no deseada, por lo que se retorna null
            if(fecha.get(Calendar.YEAR) != annio) {
                return null;
            }
            if(fecha.get(Calendar.MONTH) != (mes-1)) {
                return null;
            }
            if(fecha.get(Calendar.DAY_OF_MONTH) != dia) {
                return null;
            }
            
            // En caso de que todo lo anterior no se cumpla, la fecha esta correcta
            return fecha;
        } catch (Exception e) {
            // Cuando se digita un caracter que no es un numero, se retorna null para avisar
            return null;
        }
    }

    /**
     * Metodo que verifica la Hora ingresada en la ventana
     * @return objeto tipo {@code int[]} en caso que sea correcto y {@code null} en caso de que sea incorrecto
     */
    private int[] verificarHora() {
        try {
            int hora = Integer.parseInt(campoHoras.getText());
            int minutos = Integer.parseInt(campoMinutos.getText());
            int segundos =  Integer.parseInt(campoSegundos.getText());
            // Verificacion de la hora
            if(!(0 <= hora && hora <= 23)) {
                return null;
            }

            if(!(0 <= minutos && minutos <= 59)){
                return null;
            }

            if(!(0 <= segundos && segundos <= 59)){
                return null;
            }

            // Se crea un array que contenga la hora en el orden comun de una hora
            int [] arr = {hora,minutos,segundos};
            return arr;

        } catch (Exception e) {
            return null;
        }
    } 

    /**
     * Este metodo comprueba si un string de entrada es un numero mayor a 0
     * @param string cualquier tipo de string
     * @return {@code boolean} en caso de que este mal retorna {@code true}, si esta bien retorna {@code false}
    */
    private boolean verificarNumeros(String string) {
        try { // try_catch para verificar que no hayan caracteres indeseados
            double valor = Double.parseDouble(string); // se transforma en double para comprobar si este es mayor a 0
            if(valor <= 0) {
                return true;
            }
            return false;

        } catch (NumberFormatException e) {
            return true;
        }
    }

    /**
     * Este metodo comprueba el string de entrada es un {@code double} (numero con decimales)
     * @param string cualquier tipo de string
     * @return {@code boolean} en caso de que este mal retorna {@code true}, si esta bien retorna {@code false}
    */
    private boolean verificarCoordenadas(String string) {
        try { // try_catch verifica si este string es valido para ser un double
            Double.parseDouble(string);
            return false;

        } catch (NumberFormatException e) {
            return true;
        }
    }


    /**
     * Metodo que convierte un string ya sea: {@code "Choque de placas"}, {@code "Tectonico Por falla Local"}, 
     * {@code "Subduccion"}, {@code "Intra placa"} y {@code "Deformacion Interna"} a su TOrigen correspondiente
     * @param string cualquier tipo de string
     * @return {@code TOrigen} dependiendo del string de entrada, si este no coincide con ningun caso retorna
     * {@code null}
     */
    private TOrigen origenEnum(String string){
        switch (string) {
            case "Choque de placas":
                return TOrigen.CHOQUE_DE_PLACAS;
            case "Tectonico Por falla Local":
                return TOrigen.TECTONICO_POR_FALLA_LOCAL;
            case "Subduccion":
                return TOrigen.SUBDUCION;
            case "Intra placa":
                return TOrigen.INTRA_PLACA;
            case "Deformacion Interna":
                return TOrigen.DEFORMACION_INTERNA;
            default:
                return null;
        }
    }

    /**
     *  Metodo que convierte un string ya sea: {@code "San José"}, {@code "Alajuela"}, {@code "Cartago"}, 
     * {@code "Heredia"}, {@code "Guanacaste"}, {@code "Puntarenas"} y {@code "Limón"} a su TProvincia correspondiente
     * @param string cualquier tipo de string
     * @return {@code TProvincia} dependiendo del string de entrada, si este no coincide con ningun caso retorna
     * {@code null}
    */
    private TProvincia provinciaEnum(String string) {
        switch (string) {
            case "San José":
                return TProvincia.SAN_JOSE;
            case "Alajuela":
                return TProvincia.ALAJUELA;
            case "Cartago":
                return TProvincia.CARTAGO;
            case "Heredia":
                return TProvincia.HEREDIA;
            case "Guanacaste":
                return TProvincia.GUANACASTE;
            case "Puntarenas":
                return TProvincia.PUNTARENAS;
            case "Limón":
                return TProvincia.LIMON;  
            default:
                return null;
        }
    }

    /**
     * Metodo para verficicar que el ID sea un numero entero positivo y no se haya ingresado otra cosa en la ventana
     * @return {@code int} el ID en caso de que este correcto, de lo contrario retorna -1
     */
    private int verificarId(){
        String string = idCampo.getText();
        try { // try_catch verifica si este string es valido para ser un entero
            int id = Integer.parseInt(string);
            if(id <= 0) {
                return -1;
            }
            return id;

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /** 
     * Metodo para eliminar un sismo dado un ID en la ventana
    */
    private void eliminarSismo() {
        int id = verificarId();
        if(id == -1){
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean resultado = adminDatos.eliminarSismo(id);
        if(!(resultado)) {
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO NO EXISTE","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }

        cargarTabla();
    }
    /*
    Metodo para ver un sismo segun su id en la tabla de sismos que se van agregando 
    
    */
    
    private void verSismo(){
        int id = verificarId();
        if(id == -1){
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Sismo actual = adminDatos.consultarSismo(id);
        if(actual == null) {
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO NO EXISTE","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        double lat = actual.getLatitud();
        double lon = actual.getLongitud();
        MapaSismos.abrirNavegador("https://www.google.com/maps/place/" + lat + "," + lon);
    
    }

    /** 
     * Metodo para modificar sismos, modifica el sismo seleccionado segun los datos ingresados en la ventana, las
     * modificaciones se realizan de arriba hacia abajo, por ende, si se encuentra algun error en algun camino de la
     * modificacion, realizara las anteriores y se avisara al usuario donde ocurrio el error
    */
    private void modificarSismo() {

        // Se verifica el ID
        int id = verificarId();
        if(id == -1){
            JOptionPane.showMessageDialog(this, "EL ID INTRODUCIDO ES INVALIDO","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mensaje extra para los errores
        String msg_extra = ", SI REALIZO MODIFICACIONES PREVIAS, ESTAS FUERON REALIZADAS";

        // Se guardan algunos campos en formato String o de su tipo de enumeracion ya que son usadas multiples
        // veces durante el metodo
        String campoProfundidad = this.campoProfundidad.getText();
        String campoMagnitud = this.campoMagnitud.getText();
        String campoLatitud = this.campoLatitud.getText();
        String campoLongitud = this.campoLongitud.getText();
        String campoDescripcion = this.campoDescripcion.getText();
        String campoProvincia = String.valueOf(this.campoProvincia.getSelectedItem());
        String campoOrigen = String.valueOf(this.campoOrigen.getSelectedItem());
        TProvincia provincia = provinciaEnum(campoProvincia);
        TOrigen origen = origenEnum(campoOrigen);


        // Se verifica si la fecha esta completa y no hay ningun espacio vacio
        if(campoDia.getText().length() != 0 && campoMes.getText().length() != 0 && campoAnnio.getText().length() != 0) {
            Calendar fecha = verificarFecha(); // se usa el metodo de verificar fecha para asegurarse que este correcta
            if(fecha == null) {
                JOptionPane.showMessageDialog(this, "FECHA INVALIDA" + msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            adminDatos.modificarSismo(id, TModificacion.DIA, fecha.get(Calendar.DAY_OF_MONTH));
            adminDatos.modificarSismo(id, TModificacion.MES, fecha.get(Calendar.MONTH));
            adminDatos.modificarSismo(id, TModificacion.ANNIO, fecha.get(Calendar.YEAR));
        }

        // Los espacios vacios y completos se revisan en cada elemento, en cada if del metodo.
        if(campoHoras.getText().length() != 0  && campoMinutos.getText().length() != 0 && 
        campoSegundos.getText().length() != 0 ) {
            int[] hora = verificarHora(); // se usa el metodo para verificar que la hora este correcta
            if(hora == null) {
                JOptionPane.showMessageDialog(this, "HORA INVALIDA" + msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            adminDatos.modificarSismo(id, TModificacion.HORA, hora[0]);
            adminDatos.modificarSismo(id, TModificacion.MINUTOS, hora[1]);
            adminDatos.modificarSismo(id, TModificacion.SEGUNDOS, hora[2]);
        }

        if(campoProfundidad.length() != 0) {
            if(verificarNumeros(campoProfundidad)) { // verificacion de datos
                JOptionPane.showMessageDialog(this, "PROFUNDIDAD INVALIDA"+msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            double profundidad = Double.parseDouble(campoProfundidad);
            adminDatos.modificarSismo(id, TModificacion.PROFUNDIDAD, profundidad);
        }

        adminDatos.modificarSismo(id, origen); // modificacion de la provincia

        if(campoMagnitud.length() != 0) {
            if(verificarNumeros(campoMagnitud)) { // verificacion de datos
                JOptionPane.showMessageDialog(this, "MAGNITUD INVALIDA" + msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            double magnitud = Double.parseDouble(campoMagnitud);
            adminDatos.modificarSismo(id, TModificacion.MAGNITUD, magnitud);
        }

        if(campoLatitud.length() != 0) { 
            if(verificarCoordenadas(campoLatitud)) { // verificacion de datos
                JOptionPane.showMessageDialog(this, "LATITUD INVALIDA" + msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            double latitud = Double.parseDouble(campoLatitud);
            adminDatos.modificarSismo(id, TModificacion.LATITUD, latitud);
        }

        if(campoLongitud.length() != 0) {
            if(verificarCoordenadas(campoLongitud)) { // verificacion de datos
                JOptionPane.showMessageDialog(this, "LONGITUD INVALIDA" + msg_extra,"ERROR",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificaciones:
            double longitud = Double.parseDouble(campoLongitud);
            adminDatos.modificarSismo(id, TModificacion.LONGITUD, longitud);
        }

        adminDatos.modificarSismo(id, provincia); // modificacion de la provincia

        if(campoDescripcion.length() != 0) {
            // Modificaciones:
            adminDatos.modificarSismo(id, campoDescripcion);
        } 
    }
}
