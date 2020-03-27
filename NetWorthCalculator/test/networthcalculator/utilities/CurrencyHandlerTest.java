/*
 */
package networthcalculator.utilities;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MP
 */
public class CurrencyHandlerTest {
    
    public CurrencyHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO finish tests
    @Test
    public void testConvertToNonUSD() {
        System.out.println("convertToNonUSD");
        String amount = "";
        String result = "";
        String expectedResult = "";
        CurrencyHandler instance = new CurrencyHandler();
        
        amount = "0.00";
        instance.setCurrency("CAD"); // Canada
        result = instance.convertToNonUSD(amount, 1.43525);
        expectedResult = "0.00";
        assertEquals(expectedResult, result);
        
        amount = "100.00";
        instance.setCurrency("CAD"); // Canada
        result = instance.convertToNonUSD(amount, 1.43525);
        System.out.println("Result: " + result);
        expectedResult = "143.52";
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testConvertBackToUSD() {
        System.out.println("convertBackToUSD");
        String amount = "";
        String result = "";
        String expectedResult = "";
        CurrencyHandler instance = new CurrencyHandler();
        
        amount = "0.00";
        result = instance.convertBackToUSD(amount, 1.43525);
        expectedResult = "0.00";
        assertEquals(expectedResult, result);
        
        amount = "143.52";
        result = instance.convertBackToUSD(amount, 1.43525);
        System.out.println("Result: " + result);
        expectedResult = "99.99651628636127";
        assertEquals(expectedResult, result);
    } 
}
