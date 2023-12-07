package com.example.onepiecelogin2.data.remote.response


import com.google.gson.annotations.SerializedName

class IndodaxResponse : ArrayList<IndodaxResponseItem>()

data class IndodaxResponseItem(
    @SerializedName("base_currency")
    val baseCurrency: String,
    @SerializedName("cmc_id")
    val cmcId: Int,
    @SerializedName("coingecko_id")
    val coingeckoId: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("has_memo")
    val hasMemo: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_maintenance")
    val isMaintenance: Int,
    @SerializedName("is_market_suspended")
    val isMarketSuspended: Int,
    @SerializedName("memo_name")
    val memoName: Boolean,
    @SerializedName("old_ticker_id")
    val oldTickerId: String,
    @SerializedName("price_precision")
    val pricePrecision: Double,
    @SerializedName("price_round")
    val priceRound: Int,
    @SerializedName("pricescale")
    val pricescale: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("ticker_id")
    val tickerId: String,
    @SerializedName("trade_fee_percent")
    val tradeFeePercent: Double,
    @SerializedName("trade_fee_percent_maker")
    val tradeFeePercentMaker: Double,
    @SerializedName("trade_fee_percent_taker")
    val tradeFeePercentTaker: Double,
    @SerializedName("trade_min_base_currency")
    val tradeMinBaseCurrency: Int,
    @SerializedName("trade_min_traded_currency")
    val tradeMinTradedCurrency: Double,
    @SerializedName("traded_currency")
    val tradedCurrency: String,
    @SerializedName("traded_currency_unit")
    val tradedCurrencyUnit: String,
    @SerializedName("url_logo")
    val urlLogo: String,
    @SerializedName("url_logo_png")
    val urlLogoPng: String,
    @SerializedName("volume_precision")
    val volumePrecision: Int
)