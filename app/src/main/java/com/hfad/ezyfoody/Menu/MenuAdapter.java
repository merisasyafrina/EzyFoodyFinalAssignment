package com.hfad.ezyfoody.Menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.ezyfoody.Activities.MyOrderActivity;
import com.hfad.ezyfoody.R;

import java.util.ArrayList;


public class MenuAdapter extends BaseAdapter {
    Context context;
    ArrayList<MenuItem> menuItem = new ArrayList<>();

    public MenuAdapter(Context context, ArrayList<MenuItem> menuItem) {
        this.context = context;
        this.menuItem = menuItem;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(ArrayList<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }


    @Override
    public int getCount() {
        return menuItem.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_drinks_list, parent,false);
        }

        MenuItem menuItemTemp = (MenuItem) getItem(position);

        ImageView imgItem = (ImageView)convertView.findViewById(R.id.imgItem);
        TextView txtItem = (TextView)convertView.findViewById(R.id.txtItem);
        TextView priceItem = (TextView)convertView.findViewById(R.id.priceItem);
        TextView qtyItem = (TextView)convertView.findViewById(R.id.qtyItem);
        Button deleteItem = (Button)convertView.findViewById(R.id.deleteItem);

        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuItem remove = menuItem.get(position);
                menuItem.remove(remove);

                Intent intent = new Intent(context, MyOrderActivity.class);
                context.startActivity(intent);
            }
        });

        String price = "Rp. " + String.valueOf(menuItemTemp.getPrice());
        String qty = String.valueOf(menuItemTemp.getQty());

        if(menuItemTemp.getName().equals("Mineral Water")){
            imgItem.setImageResource(R.drawable.drink);
        }else if(menuItemTemp.getName().equals("Avocado Juice")){
            imgItem.setImageResource(R.drawable.avocado);
        }else if(menuItemTemp.getName().equals("Apple Juice")){
            imgItem.setImageResource(R.drawable.apple);
        }else if(menuItemTemp.getName().equals("Mango Juice")){
            imgItem.setImageResource(R.drawable.mango);
        }

        txtItem.setText(menuItemTemp.getName());
        priceItem.setText(price);
        qtyItem.setText(qty);

        return convertView;
    }

}
