package com.hfad.ezyfoody.Activities.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfoody.Activities.HistoryActivity;
import com.hfad.ezyfoody.Activities.MyOrderActivity;
import com.hfad.ezyfoody.Activities.OrderActivity;
import com.hfad.ezyfoody.R;

public class DrinksActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.ezyfoody.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }

    public void clickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void clickMineralWater(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Mineral Water";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickMangoJuice(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Mango Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickAvocadoJuice(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Avocado Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickAppleJuice(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Apple Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }
}