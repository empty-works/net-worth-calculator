/*
 */
package networthcalculator;

/**
 *
 * @author MP
 */
public class AmountsSingleton {
  
    private double totalCash = 0.0;
    private double totalInvestedAssets = 0.0;
    private double totalUseAssets = 0.0;
    private double totalAssets = 0.0;
    private double totalLiabilities = 0.0;
    private double netWorth = 0.0;
    
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

    
    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public double getTotalInvestedAssets() {
        return totalInvestedAssets;
    }

    public void setTotalInvestedAssets(double totalInvestedAssets) {
        this.totalInvestedAssets = totalInvestedAssets;
    }

    public double getTotalUseAssets() {
        return totalUseAssets;
    }

    public void setTotalUseAssets(double totalUseAssets) {
        this.totalUseAssets = totalUseAssets;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }
}
