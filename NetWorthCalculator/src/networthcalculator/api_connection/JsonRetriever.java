/*
 */
package networthcalculator.api_connection;

import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author MP
 */
public class JsonRetriever {
    
    private String jsonString;
    private Logger logger;
    
    public JsonRetriever() {
        
        setConnection();
    }
    
    private void setConnection() {
        
        CurrencyAPIController controller = new CurrencyAPIController();
        controller.initialize(null, null);
        
        // Test connection
        jsonString = controller.connection();
        //System.out.println("Test connection: " + jsonString);
    }
    
    public JSONObject getJsonObject() {
        
        JSONObject jObject = null;
        
        try {
            
            // Parse string
            Object obj = new JSONParser().parse(jsonString);
            
            // Typecast to JSONObject
            jObject = (JSONObject) obj;
            System.out.println("JSON Object: " + jObject);
        }
        catch(ParseException pe) {
            
            
        }
                
        return jObject;
    } 
}
