/*
 */
package networthcalculator.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author MP
 */
public class CurrencyAPIController implements Initializable {
    
    private CustomURLConnection urlCon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        urlCon = new CustomURLConnection();
    }
    
    public String connection() {
        
        HttpURLConnection connection = urlCon.connectToURL();
        String thisString = "";
        
        try {
            
            int responseCode = connection.getResponseCode();
            System.out.println("API Controller response code: " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                
                response.append(inputLine);
                System.out.println(response.toString());
            }
            in.close();
            thisString = response.toString();
        }
        catch(IOException ioe) {
            
            
        }
        connection();
        return thisString;
    }
}
