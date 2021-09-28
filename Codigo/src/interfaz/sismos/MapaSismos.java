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
import java.lang.reflect.Method;
import javax.swing.JOptionPane;

public class MapaSismos {
    private static final String errMsg = "Error attempting to launch web browser";
    public static void openURL(String url) {
    
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("Mac OS")) {
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                new Class[] {String.class});
                openURL.invoke(null, new Object[] {url});
            }
            else if (osName.startsWith("Windows"))
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                    else { //assume Unix or Linux
                        String[] browsers = {
                        "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
                        String browser1 = null;
                        for (int count = 0; count < browsers.length ; count++)
                            if (Runtime.getRuntime().exec(
                                new String[] {"which", browsers[count]}).waitFor() == 0)
                                browser1 = browsers[count];
                                if (browser1 == null)
                                    throw new Exception("Could not find web browser");
                                else
                                    Runtime.getRuntime().exec(new String[] {browser1, url});
                          }
                        }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, errMsg + ":\n" + e.getLocalizedMessage());
            }
          }
    

}