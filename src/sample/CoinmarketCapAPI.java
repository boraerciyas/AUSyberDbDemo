package sample;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class CoinmarketCapAPI {

    public static final String baseURL = "https://api.coinmarketcap.com/v1/";

    public CoinmarketCapAPI()   {

    }
    public CoinmarketCapAPI(String currency)   {

        String currencySelectionString = baseURL + "ticker/?convert=" + currency +
                "&limit=10";
        try {
            URL url = new URL(currencySelectionString);
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext())    {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (currency)
        {
            case "AUD":
        }

    }
}
