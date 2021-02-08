package com.hfad.ezyfoody.History;

import com.hfad.ezyfoody.Menu.MenuItem;

import java.util.ArrayList;

public class HistorySingleton {
    public ArrayList<HistoryItem> historyItem;
    public ArrayList<MenuItem> menuItems;
    private static HistorySingleton instance;

    private HistorySingleton(){
        historyItem = new ArrayList<HistoryItem>();
        menuItems = new ArrayList<>();
    }

    public static HistorySingleton getInstance(){
        if(instance == null){
            instance = new HistorySingleton();
        }
        return instance;
    }
}
