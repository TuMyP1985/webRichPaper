package com.example.web.utils;

import com.example.web.model.RichPaper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutValue {
    public static List<RichPaper> lists = new ArrayList<>();

    public static void instance(){

        addValues("GAZP", "Газпром");
        addValues("SBER", "Сбербанк ПАО");
        addValues("SBER_p","Сбербанк (прив.) ");
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

    public static String lastPrice(String val){

//        https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/SBER.xml?iss.meta=off&iss.only=marketdata&marketdata.columns=LAST
//        "https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/"+val+".json?iss.meta=off&iss.only=marketdata&marketdata.columns=SECID,LAST"
        return "123321";
    }
}
