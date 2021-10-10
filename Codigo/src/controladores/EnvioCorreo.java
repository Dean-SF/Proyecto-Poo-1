/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Esta es la base para enviar correo, la agrego para tenerla ahi y luego seguir con el resto de mi parte
package controladores;

import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import datos.Persona;
import datos.Sismo;

import static principal.Inicializador.adminDatos;
/**
 *
 * @author DMV
 */
public class EnvioCorreo {

    private static String user = "ovsicoriuna@gmail.com";
    private static String password = "CorreoPOO";
    private static String subject;
    private static String text;
    private static String destino;

    /**
     * Metodo para enviar un correo dado un nombre, correo y sismo
     * @param nombre
     * @param correo
     * @param sismo
     */
    public static void enviar(String nombre, String correo, Sismo sismo) {

        text = "Hola, " + nombre + " le informamos que ha temblado en " + sismo.stringProvincia() + 
        " aqui le compartimos los datos:\n" + sismo;
        destino = correo;
        subject = "Nuevo temblor registrado en " + sismo.stringProvincia();

        // String us;
        try {

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", user);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            BodyPart texto = new MimeBodyPart();
            texto.setText(text);

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject(subject);
            message.setText(text);

            Transport t = session.getTransport("smtp");
            t.connect(user, password);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Metodo para enviarCorreos segun el ultimo sismo agregado y las personas con la provincia correspondiente
     */
    public static void envioCorreos() {
        List<Sismo> lista = adminDatos.getSismos();
        List<Persona> personas = adminDatos.getPersonas();
        Sismo sismo = lista.get(lista.size()-1);

        for(Persona actual : personas) {
            if(actual.getProvincias().contains(sismo.getProvincia()) && !(actual.getCorreo().equals("N/A"))) {
                enviar(actual.getNombre(), actual.getCorreo(), sismo);
            }
        }
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String aUser) {
        user = aUser;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String aSubject) {
        subject = aSubject;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String aText) {
        text = aText;
    }

    public static String getDestino() {
        return destino;
    }

    public static void setDestino(String aDestino) {
        destino = aDestino;
    }
}
