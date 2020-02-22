/*
 */
package networthcalculator.utilities;

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
public class NumberReformatterTest {
    
    public NumberReformatterTest() {
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
     * Test of reformat method, of class NumberReformatter.
     */
    @Test
    public void testReformat() {
        System.out.println("reformat");
        String inputAmount = "2.0000";
        String expResult = "2.00";
        String result = NumberReformatter.reformat(inputAmount);
        assertEquals(expResult, result);
        
        inputAmount = "242423.3"; expResult = "242423.30";
        result = NumberReformatter.reformat(inputAmount);
        assertEquals(expResult, result);
        
        inputAmount = "242"; expResult = "242.00";
        result = NumberReformatter.reformat(inputAmount);
        assertEquals(expResult, result);
    }
    
}
