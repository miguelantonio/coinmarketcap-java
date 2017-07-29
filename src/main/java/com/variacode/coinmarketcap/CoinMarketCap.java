package com.variacode.coinmarketcap;

import java.util.List;

/**
 *
 * @author miguel@variacode.com
 */
public class CoinMarketCap {
    
    //TODO: control 10 calls per minute
    //TODO: tests

    public enum CurrencyConvert {
        AUD, BRL, CAD, CHF, CNY, EUR, GBP, HKD, IDR, INR, JPY, KRW, MXN, RUB
    }

    public class Ticker {

    }

    public class Global {

    }

    public class CoinMarketCapException extends Exception {

        private final int status;

        public int getStatus() {
            return status;
        }

        public CoinMarketCapException(int status, String message) {
            super(message);
            this.status = status;
        }

    }

    public List<Ticker> getTicker(Integer limit, CurrencyConvert convert) throws CoinMarketCapException {
        return null;
    }

    public Ticker getTickerById() throws CoinMarketCapException {
        return null;
    }

    public Global getGlobal() throws CoinMarketCapException {
        return null;
    }
    /*
    Ticker
Endpoint: /ticker/
Method: GET
Optional parameters:
(int) limit - only returns the top limit results.
(string) convert - return price, 24h volume, and market cap in terms of another currency. Valid values are: 
"AUD", "BRL", "CAD", "CHF", "CNY", "EUR", "GBP", "HKD", "IDR", "INR", "JPY", "KRW", "MXN", "RUB"
Example: https://api.coinmarketcap.com/v1/ticker/
Example: https://api.coinmarketcap.com/v1/ticker/?limit=10
Example: https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=10
Sample Response:
[
	{
		"id": "bitcoin", 
		"name": "Bitcoin", 
		"symbol": "BTC", 
		"rank": "1", 
		"price_usd": "573.137", 
		"price_btc": "1.0", 
		"24h_volume_usd": "72855700.0", 
		"market_cap_usd": "9080883500.0", 
		"available_supply": "15844176.0", 
		"total_supply": "15844176.0", 
		"percent_change_1h": "0.04", 
		"percent_change_24h": "-0.3", 
		"percent_change_7d": "-0.57", 
		"last_updated": "1472762067"
	}, 
	{
		"id": "ethereum", 
		"name": "Ethereum", 
		"symbol": "ETH", 
		"rank": "2", 
		"price_usd": "12.1844", 
		"price_btc": "0.021262", 
		"24h_volume_usd": "24085900.0", 
		"market_cap_usd": "1018098455.0", 
		"available_supply": "83557537.0", 
		"total_supply": "83557537.0", 
		"percent_change_1h": "-0.58", 
		"percent_change_24h": "6.34", 
		"percent_change_7d": "8.59", 
		"last_updated": "1472762062"
	}, 
	...
]								

Ticker (Specific Currency)
Endpoint: /ticker/{id}/
Method: GET
Optional parameters:
(string) convert - return price, 24h volume, and market cap in terms of another currency. Valid values are: 
"AUD", "BRL", "CAD", "CHF", "CNY", "EUR", "GBP", "HKD", "IDR", "INR", "JPY", "KRW", "MXN", "RUB"
Example: https://api.coinmarketcap.com/v1/ticker/bitcoin/
Example: https://api.coinmarketcap.com/v1/ticker/bitcoin/?convert=EUR
Sample Response:
[
	{
		"id": "bitcoin", 
		"name": "Bitcoin", 
		"symbol": "BTC", 
		"rank": "1", 
		"price_usd": "573.137", 
		"price_btc": "1.0", 
		"24h_volume_usd": "72855700.0", 
		"market_cap_usd": "9080883500.0", 
		"available_supply": "15844176.0", 
		"total_supply": "15844176.0", 
		"percent_change_1h": "0.04", 
		"percent_change_24h": "-0.3", 
		"percent_change_7d": "-0.57", 
		"last_updated": "1472762067"
	}
]				
Sample Error Response:
{
	"error": "id not found"
}								

Global Data
Endpoint: /global/
Method: GET
Optional parameters:
(string) convert - return 24h volume, and market cap in terms of another currency. Valid values are: 
"AUD", "BRL", "CAD", "CHF", "CNY", "EUR", "GBP", "HKD", "IDR", "INR", "JPY", "KRW", "MXN", "RUB"
Example: https://api.coinmarketcap.com/v1/global/
Example: https://api.coinmarketcap.com/v1/global/?convert=EUR
Sample Response:
{
	"total_market_cap_usd": 12756692479.0, 
	"total_24h_volume_usd": 135078435.0, 
	"bitcoin_percentage_of_market_cap": 83.34, 
	"active_currencies": 653, 
	"active_assets": 59, 
	"active_markets": 1995
}						

Limits
Please limit requests to no more than 10 per minute.
Endpoints update every 5 minutes.
Documentation Last Updated
March 15th, 2017
Questions?
Please fill out the request form.
     */
}
