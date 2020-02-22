/*
 */
package networthcalculator.containers;

import networthcalculator.utilities.SubCatConCalc;
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
public class SubCatConCalcTest {
    
    public SubCatConCalcTest() {
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

    /**
     * Test of getSubTotal method, of class SubCatConCalc.
     */
    @Test
    public void testGetSubTotal() {
        System.out.println("getSubTotal");
        
        double result = SubCatConCalc.getSubTotal(0.0, "10.0", "0.0");
        assertEquals(10.0, result, 10.0);
        
        result = SubCatConCalc.getSubTotal(10.0, "10.0", "10.0");
        assertEquals(10.0, result, 0.0);
        
        result = SubCatConCalc.getSubTotal(10.0, "20.0", "10.0");
        assertEquals(20.0, result, 10.0);
        
        result = SubCatConCalc.getSubTotal(20.0, "10.0", "20.0");
        assertEquals(10.0, result, 10.0);
        
        result = SubCatConCalc.getSubTotal(10.0, "0.0", "10.0");
        assertEquals(0.0, result, 10.0);
        
        result = SubCatConCalc.getSubTotal(0.0, "100.0", "0.0");
        assertEquals(100.0, result, 100.0);
    }

    /**
     * Test of getAmountDifference method, of class SubCatConCalc.
     */
    @Test
    public void testGetAmountDifference() {
        System.out.println("getAmountDifference");
        
        double result = SubCatConCalc.getAmountDifference("15.0", "5.5");
        assertEquals(9.5, result, 5.5);
        
        result = SubCatConCalc.getAmountDifference("25.5", "5.5");
        assertEquals(20.0, result, 5.5);
        
        result = SubCatConCalc.getAmountDifference("15.5", "6.5");
        assertEquals(9.0, result, 6.5);
    }
}
