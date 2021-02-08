package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.hfad.ezyfoody.History.HistoryDetailAdapter;
import com.hfad.ezyfoody.History.HistoryItem;
import com.hfad.ezyfoody.History.HistorySingleton;
import com.hfad.ezyfoody.Menu.MenuItem;
import com.hfad.ezyfoody.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class DetailHistoryActivity extends AppCompatActivity {
    HistoryDetailAdapter historyDetailAdapter;
    ListView itemListView;

    ArrayList<HistoryItem> historyList = HistorySingleton.getInstance().historyItem;
    ArrayList<MenuItem> itemList = new ArrayList<>();
    Intent intent;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);
        TextView transactionDate = findViewById(R.id.transactionDate);
        TextView address = findViewById(R.id.address);
        TextView totalPrice = findViewById(R.id.totalPrice);

        intent = getIntent();
        int id = intent.getIntExtra(HistoryActivity.ID, 0);

        itemList = historyList.get(id).itemList;

        transactionDate.setText(historyList.get(id).getDate());
        address.setText(historyList.get(id).getAddress());
        totalPrice.setText(getTotal());

        itemListView = (ListView)findViewById(R.id.listViewHistoryDetail);
        historyDetailAdapter = new HistoryDetailAdapter(this, itemList);
        itemListView.setAdapter(historyDetailAdapter);
    }

    private String getTotal() {
        double tempTotal = 0;
        String totalPrice = "";

        for(MenuItem item: itemList){
            tempTotal += (item.getPrice()*item.getQty());
        }

        DecimalFormat kursIndo = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndo.setDecimalFormatSymbols(formatRp);

        totalPrice = kursIndo.format(tempTotal);

        return totalPrice;
    }
}