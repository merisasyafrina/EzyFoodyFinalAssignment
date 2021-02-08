package com.hfad.ezyfoody.History;

import com.hfad.ezyfoody.Menu.MenuItem;

import java.util.ArrayList;

public class HistoryItem {
    private int historyId;
    private String address;
    private String date;
    public ArrayList<MenuItem> itemList;

    public HistoryItem(int historyId, String address, String date, ArrayList<MenuItem> itemList) {
        this.historyId = historyId;
        this.address = address;
        this.date = date;

        itemList = new ArrayList<>();
        this.itemList = itemList;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
