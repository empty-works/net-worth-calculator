/*
 */
package networthcalculator.containers;

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
        String currentAmountString = "";
        String previousAmountString = "";
        double expResult = 0.0;
        double result = SubCatConCalc.getAmountDifference(currentAmountString, previousAmountString);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
