/*
 */
package networthcalculator.api_connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author MP
 */
public class JsonRetriever {
    
    private String jsonString;
    
    public JsonRetriever() throws IOException, FileNotFoundException, ParseException {
        
        setConnection();
    }
    
    private void setConnection() throws FileNotFoundException, IOException, ParseException {
        
        CurrencyAPIController controller = new CurrencyAPIController();
        controller.initialize(null, null);
        
        // Test connection
        jsonString = controller.connection();
        System.out.println("Test connection: " + jsonString);
        
        
        // Parse string
        Object obj = new JSONParser().parse(jsonString);
        
    }
}
