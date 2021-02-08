package com.hfad.ezyfoody;

public class Saldo {
    private double saldo;
    private static Saldo instance;

    private Saldo() {
        this.saldo = 20000;
    }

    public static Saldo getInstance(){
        if(instance == null){
            instance = new Saldo();
        }
        return instance;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
