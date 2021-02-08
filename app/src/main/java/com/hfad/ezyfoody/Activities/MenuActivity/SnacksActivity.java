package com.hfad.ezyfoody.Activities.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfoody.Activities.OrderActivity;
import com.hfad.ezyfoody.Activities.HistoryActivity;
import com.hfad.ezyfoody.Activities.MyOrderActivity;
import com.hfad.ezyfoody.R;

public class SnacksActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.ezyfoody.ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
    }

    public void clickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void clickChips(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Chips";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickFries(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "French Fries";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickRoll(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Cinnamon Roll";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickTaco(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Taco";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }
}