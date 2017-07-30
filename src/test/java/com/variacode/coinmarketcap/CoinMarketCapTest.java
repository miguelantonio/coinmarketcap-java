package com.variacode.coinmarketcap;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Copyright (c) 2017 Miguel Fuentes Buchholtz. http://variacode.com
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
    public void testGetGlobalConvert() throws Exception {
        System.out.println("getGlobal Convert");
        CoinMarketCap.Global result = instance.getGlobal(CoinMarketCap.CurrencyConvert.CNY);
        assertNotNull(result);
        assertNotNull(result.getActiveAssets());
    }
    
    @Test
    public void testGetGlobal() throws Exception {
        System.out.println("getGlobal "+new Date());
        CoinMarketCap.Global result = instance.getGlobal(null);
        assertNotNull(result);
        assertNotNull(result.getActiveAssets());
    }
    
    @Test
    public void testGetGlobal2() throws Exception {
        System.out.println("getGlobal 2 testing throttle "+new Date());
        CoinMarketCap.Global result = instance.getGlobal(null);
        assertNotNull(result);
        assertNotNull(result.getActiveAssets());
        System.out.println("getGlobal 2 testing throttle "+new Date());
        instance.getGlobal(null);
        System.out.println("getGlobal 2 testing throttle "+new Date());
        instance.getGlobal(null);
    }

}
