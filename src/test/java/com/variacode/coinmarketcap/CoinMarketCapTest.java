
package com.variacode.coinmarketcap;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguel@variacode.com
 */
public class CoinMarketCapTest {
    
    public CoinMarketCapTest() {
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
     * Test of getTicker method, of class CoinMarketCap.
     */
    @Test
    public void testGetTicker() throws Exception {
        System.out.println("getTicker");
        Integer limit = null;
        CoinMarketCap.CurrencyConvert convert = null;
        CoinMarketCap instance = new CoinMarketCap();
        List<CoinMarketCap.Ticker> expResult = null;
        List<CoinMarketCap.Ticker> result = instance.getTicker(limit, convert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTickerById method, of class CoinMarketCap.
     */
    @Test
    public void testGetTickerById() throws Exception {
        System.out.println("getTickerById");
        CoinMarketCap instance = new CoinMarketCap();
        CoinMarketCap.Ticker expResult = null;
        CoinMarketCap.Ticker result = instance.getTickerById();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGlobal method, of class CoinMarketCap.
     */
    @Test
    public void testGetGlobal() throws Exception {
        System.out.println("getGlobal");
        CoinMarketCap instance = new CoinMarketCap();
        CoinMarketCap.Global expResult = null;
        CoinMarketCap.Global result = instance.getGlobal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
