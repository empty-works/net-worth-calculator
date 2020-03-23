/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    /**
     * Test of setCurrencyRate method, of class CurrencyHandler.
     */
    @Test
    public void testSetCurrencyRate() {
        System.out.println("setCurrencyRate");
        String currencyRate = "";
        CurrencyHandler instance = new CurrencyHandler();
        instance.setCurrencyRate(currencyRate);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testConvertToNonUSD() {
        System.out.println("convertToNonUSD");
        CurrencyHandler instance = new CurrencyHandler();
        
    }
    
    @Test
    public void testConvertBackToUSD() {
        System.out.println("convertBackToUSD");
        CurrencyHandler instance = new CurrencyHandler();
        
    } 
}
