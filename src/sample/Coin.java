package sample;

import javafx.beans.property.SimpleStringProperty;

public class Coin {
    private SimpleStringProperty
            id,
            name,
            symbol,
            rank,
            price_usd,
            price_btc,
            volume_usd_24h,
            market_cap_usd,
            available_supply,
            total_supply,
            max_supply,
            percent_change_1h,
            percent_change_24h,
            percent_change_7d,
            last_updated;

    public Coin(SimpleStringProperty id, SimpleStringProperty name, SimpleStringProperty symbol, SimpleStringProperty rank, SimpleStringProperty price_usd, SimpleStringProperty price_btc, SimpleStringProperty volume_usd_24h, SimpleStringProperty market_cap_usd, SimpleStringProperty available_supply, SimpleStringProperty total_supply, SimpleStringProperty max_supply, SimpleStringProperty percent_change_1h, SimpleStringProperty percent_change_24h, SimpleStringProperty percent_change_7d, SimpleStringProperty last_updated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.volume_usd_24h = volume_usd_24h;
        this.market_cap_usd = market_cap_usd;
        this.available_supply = available_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.last_updated = last_updated;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSymbol() {
        return symbol.get();
    }

    public SimpleStringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    //Rank will return an integer value.
    public int getRank() {
        return Integer.valueOf(rank.get());
    }

    public SimpleStringProperty rankProperty() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank.set(rank);
    }

    public String getPrice_usd() {
        return price_usd.get();
    }

    public SimpleStringProperty price_usdProperty() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd.set(price_usd);
    }

    public String getPrice_btc() {
        return price_btc.get();
    }

    public SimpleStringProperty price_btcProperty() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc.set(price_btc);
    }

    public String getVolume_usd_24h() {
        return volume_usd_24h.get();
    }

    public SimpleStringProperty volume_usd_24hProperty() {
        return volume_usd_24h;
    }

    public void setVolume_usd_24h(String volume_usd_24h) {
        this.volume_usd_24h.set(volume_usd_24h);
    }

    public String getMarket_cap_usd() {
        return market_cap_usd.get();
    }

    public SimpleStringProperty market_cap_usdProperty() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd.set(market_cap_usd);
    }

    public String getAvailable_supply() {
        return available_supply.get();
    }

    public SimpleStringProperty available_supplyProperty() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply.set(available_supply);
    }

    public String getTotal_supply() {
        return total_supply.get();
    }

    public SimpleStringProperty total_supplyProperty() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply.set(total_supply);
    }

    public String getMax_supply() {
        return max_supply.get();
    }

    public SimpleStringProperty max_supplyProperty() {
        return max_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply.set(max_supply);
    }

    public String getPercent_change_1h() {
        return percent_change_1h.get();
    }

    public SimpleStringProperty percent_change_1hProperty() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h.set(percent_change_1h);
    }

    public String getPercent_change_24h() {
        return percent_change_24h.get();
    }

    public SimpleStringProperty percent_change_24hProperty() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h.set(percent_change_24h);
    }

    public String getPercent_change_7d() {
        return percent_change_7d.get();
    }

    public SimpleStringProperty percent_change_7dProperty() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d.set(percent_change_7d);
    }

    public String getLast_updated() {
        return last_updated.get();
    }

    public SimpleStringProperty last_updatedProperty() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated.set(last_updated);
    }
}
