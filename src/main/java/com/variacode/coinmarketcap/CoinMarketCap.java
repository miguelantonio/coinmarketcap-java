package com.variacode.coinmarketcap;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.util.List;
import java.net.URL;

/**
 *
 * @author miguel@variacode.com
 */
public class CoinMarketCap {

    private final Gson gson = new Gson();

    //TODO: control 10 calls per minute
    //TODO: tests
    //TODO: last updated to date
    public enum CurrencyConvert {
        AUD, BRL, CAD, CHF, CNY, EUR, GBP, HKD, IDR, INR, JPY, KRW, MXN, RUB
    }

    public class Ticker {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("rank")
        @Expose
        private Integer rank;
        @SerializedName("price_usd")
        @Expose
        private BigDecimal priceUsd;
        @SerializedName("price_btc")
        @Expose
        private BigDecimal priceBtc;
        @SerializedName("24h_volume_usd")
        @Expose
        private BigDecimal _24hVolumeUsd;
        @SerializedName("market_cap_usd")
        @Expose
        private BigDecimal marketCapUsd;
        @SerializedName("available_supply")
        @Expose
        private BigDecimal availableSupply;
        @SerializedName("total_supply")
        @Expose
        private BigDecimal totalSupply;
        @SerializedName("percent_change_1h")
        @Expose
        private BigDecimal percentChange1h;
        @SerializedName("percent_change_24h")
        @Expose
        private BigDecimal percentChange24h;
        @SerializedName("percent_change_7d")
        @Expose
        private BigDecimal percentChange7d;
        @SerializedName("last_updated")
        @Expose
        private Long lastUpdated;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public BigDecimal getPriceUsd() {
            return priceUsd;
        }

        public void setPriceUsd(BigDecimal priceUsd) {
            this.priceUsd = priceUsd;
        }

        public BigDecimal getPriceBtc() {
            return priceBtc;
        }

        public void setPriceBtc(BigDecimal priceBtc) {
            this.priceBtc = priceBtc;
        }

        public BigDecimal get24hVolumeUsd() {
            return _24hVolumeUsd;
        }

        public void set24hVolumeUsd(BigDecimal _24hVolumeUsd) {
            this._24hVolumeUsd = _24hVolumeUsd;
        }

        public BigDecimal getMarketCapUsd() {
            return marketCapUsd;
        }

        public void setMarketCapUsd(BigDecimal marketCapUsd) {
            this.marketCapUsd = marketCapUsd;
        }

        public BigDecimal getAvailableSupply() {
            return availableSupply;
        }

        public void setAvailableSupply(BigDecimal availableSupply) {
            this.availableSupply = availableSupply;
        }

        public BigDecimal getTotalSupply() {
            return totalSupply;
        }

        public void setTotalSupply(BigDecimal totalSupply) {
            this.totalSupply = totalSupply;
        }

        public BigDecimal getPercentChange1h() {
            return percentChange1h;
        }

        public void setPercentChange1h(BigDecimal percentChange1h) {
            this.percentChange1h = percentChange1h;
        }

        public BigDecimal getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(BigDecimal percentChange24h) {
            this.percentChange24h = percentChange24h;
        }

        public BigDecimal getPercentChange7d() {
            return percentChange7d;
        }

        public void setPercentChange7d(BigDecimal percentChange7d) {
            this.percentChange7d = percentChange7d;
        }

        public Long getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(Long lastUpdated) {
            this.lastUpdated = lastUpdated;
        }
    }

    public class Global {

    }

    private class Error {

        public String error;
    }

    private String getParamSuffix(String[][] params) {
        String str = null;
        for (String[] p : params) {
            str = (p != null && p.length > 1 && p[1] != null && p[0] != null) ? (str == null ? ("?" + p[0] + "=" + p[1]) : (str + "&" + p[0] + "=" + p[1])) : str;
        }
        return str;
    }

    private String getJsonResponse(final String url) throws CoinMarketCapException {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            final int responseCode = con.getResponseCode();

            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            if (responseCode != 200) {
                final Error error = gson.fromJson(response.toString(), Error.class);
                throw new CoinMarketCapException(responseCode, error == null ? null : error.error);
            }
            return response.toString();
        } catch (IOException ex) {
            throw new CoinMarketCapException(ex.getCause());
        }
    }

    public class CoinMarketCapException extends Exception {

        private final Integer status;

        public int getStatus() {
            return status;
        }

        public CoinMarketCapException(final int status, final String message) {
            super(message);
            this.status = status;
        }

        public CoinMarketCapException(Throwable cause) {
            super(cause);
            this.status = null;
        }

    }

    public List<Ticker> getTicker(final Integer limit, final CurrencyConvert convert) throws CoinMarketCapException {
        final String[][] params = {{"limit", (limit == null ? "" : limit + "")}, {"convert", (convert == null ? "" : convert + "")}};
        return gson.fromJson(getJsonResponse("https://api.coinmarketcap.com/v1/ticker/" + getParamSuffix(params)), new TypeToken<List<Ticker>>() {
        }.getType());
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
