package com.hfad.ezyfoody.Activities.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ezyfoody.Activities.HistoryActivity;
import com.hfad.ezyfoody.Activities.MyOrderActivity;
import com.hfad.ezyfoody.Activities.OrderActivity;
import com.hfad.ezyfoody.R;

public class FoodActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.ezyfoody.ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void clickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void clickSoup(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Soup";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickRice(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Fried Rice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickRamen(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Ramen";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickPorridge(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Porridge";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }


}