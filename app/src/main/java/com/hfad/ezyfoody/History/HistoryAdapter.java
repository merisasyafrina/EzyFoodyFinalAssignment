package com.hfad.ezyfoody.History;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.ezyfoody.Activities.DetailHistoryActivity;
import com.hfad.ezyfoody.R;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<HistoryItem> history = new ArrayList<>();
    public static final String ID = "com.example.binusezyfood.ID";

    public HistoryAdapter(Context context, ArrayList<HistoryItem> history) {
        this.context = context;
        this.history = history;
    }

    @Override
    public int getCount() {
        return history.size();
    }

    @Override
    public Object getItem(int position) {
        return history.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_history_list, parent,false);
        }

        HistoryItem tempHistory = (HistoryItem) getItem(position);

        TextView date = (TextView)convertView.findViewById(R.id.transactionDate);
        TextView address = (TextView)convertView.findViewById(R.id.transactionAddress);
        Button buttonDetails = (Button)convertView.findViewById(R.id.btnDetails);

        buttonDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailHistoryActivity.class);

                int id = (int) getItemId(position);
                intent.putExtra(ID, id);

                context.startActivity(intent);
            }
        });

        date.setText(tempHistory.getDate());
        address.setText(tempHistory.getAddress());

        return convertView;
    }

}
