package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfoody.CompleteOrder.CompleteOrderAdapter;
import com.hfad.ezyfoody.History.HistoryItem;
import com.hfad.ezyfoody.History.HistorySingleton;
import com.hfad.ezyfoody.Menu.MenuAdapter;
import com.hfad.ezyfoody.Menu.MenuItem;
import com.hfad.ezyfoody.Menu.MenuList;
import com.hfad.ezyfoody.Menu.MenuSingleton;
import com.hfad.ezyfoody.R;
import com.hfad.ezyfoody.Saldo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyOrderActivity extends AppCompatActivity {

    ArrayList<MenuItem> menuItemList = MenuSingleton.getInstance().menuItem;
    HistorySingleton historySingleton = HistorySingleton.getInstance();

    Saldo saldo = Saldo.getInstance();
    CompleteOrderAdapter completeOrderAdapter;
    ListView menuListView;
    private double tempTotal;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Intent intent = getIntent();
        address = intent.getStringExtra(MapsActivity.ADDRESS);

        TextView textView = findViewById(R.id.address);
        textView.setText(address);

        menuListView = (ListView)findViewById(R.id.listView);
        TextView totalPrice = (TextView)findViewById(R.id.totalPrice);

        totalPrice.setText(getTotalPrice());;
        completeOrderAdapter = new CompleteOrderAdapter(this, menuItemList);
        menuListView.setAdapter(completeOrderAdapter);
    }

    private String getTotalPrice() {
        tempTotal = 0;
        String totalPrice = "";
        for(MenuItem menuItem: menuItemList){
            tempTotal += (menuItem.getPrice()*menuItem.getQty());
        }

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        totalPrice = kursIndonesia.format(tempTotal);

        return totalPrice;
    }

    public void clickPayNow(View view) {
        if(tempTotal > saldo.getSaldo()){
            Toast.makeText(this, "Insufficient balance!", Toast.LENGTH_SHORT).show();
        }else{
            Date tempDate = Calendar.getInstance().getTime();
            String date = tempDate.toString().substring(0,19);

            historySingleton.historyItem.add(new HistoryItem(historySingleton.historyItem.size(), address, date, menuItemList));
            historySingleton.historyItem.get(historySingleton.historyItem.size()-1).itemList.addAll(menuItemList);

            tempTotal = saldo.getSaldo() - tempTotal;
            saldo.setSaldo(tempTotal);

            menuItemList.clear();
            Toast toast = Toast.makeText(getApplicationContext(),"Thank you, your order is successfully paid.", Toast.LENGTH_SHORT);toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}