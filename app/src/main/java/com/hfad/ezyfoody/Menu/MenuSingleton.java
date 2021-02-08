package com.hfad.ezyfoody.Menu;

import java.util.ArrayList;

public class MenuSingleton {
    public ArrayList<MenuItem> menuItem;
    public static MenuSingleton instance;


    public MenuSingleton(){
        menuItem = new ArrayList<MenuItem>();
    }

    public static MenuSingleton getInstance(){
        if(instance == null){
            instance = new MenuSingleton();
        }
        return instance;
    }
}

