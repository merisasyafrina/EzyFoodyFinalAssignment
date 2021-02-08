package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.hfad.ezyfoody.CompleteOrder.CompleteOrderAdapter;
import com.hfad.ezyfoody.Menu.MenuItem;
import com.hfad.ezyfoody.Menu.MenuSingleton;
import com.hfad.ezyfoody.R;

import java.util.ArrayList;

public class CompleteOrderActivity extends AppCompatActivity {
    ArrayList<MenuItem> menuItemList = MenuSingleton.getInstance().menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        ListView listView = (ListView)findViewById(R.id.listView);
        TextView grandTotal = (TextView)findViewById(R.id.grandTotal);

        grandTotal.setText("Rp" + getTotal());;
        CompleteOrderAdapter completeOrderAdapter = new CompleteOrderAdapter(this, menuItemList);
        listView.setAdapter(completeOrderAdapter);
    }

    private String getTotal() {
        int totalTemp = 0;
        String totalPrice = "";
        for(MenuItem menuItem : menuItemList){
            totalTemp += (menuItem.getPrice()* menuItem.getQty());
        }
        totalPrice = String.valueOf(totalTemp);
        return totalPrice;
    }
}