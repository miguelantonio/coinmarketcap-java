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

    //To test delay capabilities
    CoinMarketCap instance = new CoinMarketCap();

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
        List<CoinMarketCap.Ticker> result = instance.getTicker(limit, convert);
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }

    @Test
    public void testGetTickerLimit() throws Exception {
        System.out.println("getTicker Limit");
        Integer limit = 1;
        CoinMarketCap.CurrencyConvert convert = null;
        List<CoinMarketCap.Ticker> result = instance.getTicker(limit, convert);
        assertNotNull(result);
        assertTrue(result.size() == 1);
    }

    @Test
    public void testGetTickerConvert() throws Exception {
        System.out.println("getTicker Convert");
        Integer limit = null;
        CoinMarketCap.CurrencyConvert convert = CoinMarketCap.CurrencyConvert.EUR;
        List<CoinMarketCap.Ticker> result = instance.getTicker(limit, convert);
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }

    @Test
    public void testGetTickerLimitAndConvert() throws Exception {
        System.out.println("getTicker Limit Convert");
        Integer limit = 1;
        CoinMarketCap.CurrencyConvert convert = CoinMarketCap.CurrencyConvert.EUR;
        List<CoinMarketCap.Ticker> result = instance.getTicker(limit, convert);
        assertNotNull(result);
        assertTrue(result.size() == 1);
    }

    /**
     * Test of getTickerById method, of class CoinMarketCap.
     */
    @Test
    public void testGetTickerById() throws Exception {
        System.out.println("getTickerById");
        CoinMarketCap.Ticker result = instance.getTickerById("bitcoin", null);
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void testGetTickerByIdConvert() throws Exception {
        System.out.println("getTickerById Convert");
        CoinMarketCap.Ticker result = instance.getTickerById("bitcoin", CoinMarketCap.CurrencyConvert.CNY);
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void testGetTickerByIdError() throws Exception {
        System.out.println("getTickerById Error");
        try {
            instance.getTickerById(null, CoinMarketCap.CurrencyConvert.CNY);
        } catch (CoinMarketCap.CoinMarketCapException e) {
            assertEquals(400, e.getStatus());
            return;
        }
        fail("Should have generated exception");
    }

    @Test
    public void testGetTickerByIdErrorApi() throws Exception {
        System.out.println("getTickerById Error Api");
        try {
            instance.getTickerById("asdfasdfr43323r", null);
        } catch (CoinMarketCap.CoinMarketCapException e) {
            assertEquals("id not found", e.getMessage());
            return;
        }
        fail("Should have generated exception");
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
