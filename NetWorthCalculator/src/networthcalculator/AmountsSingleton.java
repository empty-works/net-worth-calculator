/*
 */
package networthcalculator;

/**
 *
 * @author MP
 */
public class AmountsSingleton {
  
    private volatile static AmountsSingleton obj;
    
    private AmountsSingleton() {}
    
    public static AmountsSingleton getInstance() {
        
        if(obj == null) {
            
            // To make thread safe
            synchronized (AmountsSingleton.class) {
                
                if(obj == null) {
                    
                    obj = new AmountsSingleton();
                }
            }
        }
        return obj;
    }
}
