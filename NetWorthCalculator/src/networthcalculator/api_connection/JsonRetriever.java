/*
 */
package networthcalculator.api_connection;

/**
 *
 * @author MP
 */
public class JsonRetriever {
    
    public JsonRetriever() {
        
        setConnection();
    }
    
    private void setConnection() {
        
        CurrencyAPIController controller = new CurrencyAPIController();
        controller.initialize(null, null);
        
        // Test connection
        String test = controller.connection();
        System.out.println("Test connection: " + test);
    }
}
