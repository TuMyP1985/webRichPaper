package com.example.web.utils;

import com.example.web.model.RichPaper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

public class ExecutValue {
    public static List<RichPaper> lists = new ArrayList<>();

    public static void instance(){

        addValues("GAZP", "Газпром");
        addValues("SBER", "Сбербанк ПАО");
        addValues("SBERP","Сбербанк (прив.) ");
        addValues("MGNT", "ОАО Магнит");
        addValues("LKOH", "НК Лукойл ПАО");
        addValues("GMKN", "ГМК Норильский Никель ПАО");
        addValues("YNDX", "Яндекс Н.В.");
        addValues("VTBR", "ВТБ RTS ПАО");
        addValues("AFLT", "ОАО Аэрофлот");
    }

    public static void addValues(String name, String description){
        lists.add(new RichPaper(name, description));
    }

    public static void doRepeat(){
        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        //ДЕЛАЕМ: на будущее, получать  курсы ЦБ

                        Thread.sleep(1000); //1000 - 1 сек
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        run.start(); // заводим
    }

    public static String lastPrice(String val) {

        String rez = "";
        try {
            String url = "https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/" + val + ".json?iss.meta=off&iss.only=marketdata&marketdata.columns=SECID,LAST";

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String jsonString = response.toString();

            JSONObject obj1 = new JSONObject(jsonString);
            rez = ((JSONArray)
                    ((JSONArray)
                            ((JSONObject) obj1.get("marketdata"))
                    .get("data"))
                    .get(0))
                    .get(1)
                    .toString();


        }catch (Exception e){rez = e.getMessage()}
//        https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/SBER.xml?iss.meta=off&iss.only=marketdata&marketdata.columns=LAST
//
        return rez;
    }
}
