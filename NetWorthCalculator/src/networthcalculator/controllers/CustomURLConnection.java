/*
 */
package networthcalculator.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MP
 */
public class CustomURLConnection {
    
    public HttpURLConnection connectToURL() {
        
        try {
            
            URL object = new URL("https://api.exchangeratesapi.io/latest");
            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            return connection;
        }
        catch(IOException ioe) {
            
            
        }
        return null;
    }
}
