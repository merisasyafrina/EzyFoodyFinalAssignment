package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.hfad.ezyfoody.History.HistoryAdapter;
import com.hfad.ezyfoody.History.HistoryItem;
import com.hfad.ezyfoody.History.HistorySingleton;
import com.hfad.ezyfoody.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    public static final String ID = "com.example.ezyfoody.ID";
    ArrayList<HistoryItem> historyList = HistorySingleton.getInstance().historyItem;

    HistoryAdapter historyAdapter;
    ListView historyListV;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyListV = (ListView)findViewById(R.id.listVHistory);

        if(historyList.isEmpty()){
            Toast.makeText(this, "No transaction yet.", Toast.LENGTH_SHORT).show();
        }else{
            historyAdapter = new HistoryAdapter(this, historyList);
            historyListV.setAdapter(historyAdapter);
        }
    }
}