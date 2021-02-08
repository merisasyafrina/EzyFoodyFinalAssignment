package com.hfad.ezyfoody.CompleteOrder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.ezyfoody.Menu.MenuItem;
import com.hfad.ezyfoody.R;

import java.util.ArrayList;

public class CompleteOrderAdapter extends BaseAdapter {
    Context context;
    ArrayList<MenuItem> menuItem = new ArrayList<>();

    public CompleteOrderAdapter(Context context, ArrayList<MenuItem> menuItem) {
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_complete_order_list, parent, false);
        }

        MenuItem tempMenuItem = (MenuItem) getItem(position);

        ImageView imgItem = (ImageView)convertView.findViewById(R.id.imgItem);
        TextView txtItem = (TextView)convertView.findViewById(R.id.txtItem);
        TextView priceItem = (TextView)convertView.findViewById(R.id.priceItem);
        TextView qtyItem = (TextView)convertView.findViewById(R.id.qtyItem);

        String quantity = String.valueOf(tempMenuItem.getQty());
        String price = "Rp. " + String.valueOf(tempMenuItem.getPrice());

        if (tempMenuItem.getName().equals("Mineral Water")) {
            imgItem.setImageResource(R.drawable.drink);
        } else if (tempMenuItem.getName().equals("Mango Juice")) {
            imgItem.setImageResource(R.drawable.mango);
        } else if (tempMenuItem.getName().equals("Avocado Juice")) {
            imgItem.setImageResource(R.drawable.avocado);
        } else if (tempMenuItem.getName().equals("Apple Juice")) {
            imgItem.setImageResource(R.drawable.apple);
        } else if (tempMenuItem.getName().equals("Soup")) {
            imgItem.setImageResource(R.drawable.soup);
        } else if (tempMenuItem.getName().equals("Fried Rice")) {
            imgItem.setImageResource(R.drawable.friedrice);
        } else if (tempMenuItem.getName().equals("Ramen")) {
            imgItem.setImageResource(R.drawable.ramen);
        } else if (tempMenuItem.getName().equals("Porridge")) {
            imgItem.setImageResource(R.drawable.porridge);
        } else if (tempMenuItem.getName().equals("Chips")) {
            imgItem.setImageResource(R.drawable.chips);
        } else if (tempMenuItem.getName().equals("French Fries")) {
            imgItem.setImageResource(R.drawable.frenchfries);
        } else if (tempMenuItem.getName().equals("Cinnamon Roll")) {
            imgItem.setImageResource(R.drawable.cinnamonroll);
        } else if (tempMenuItem.getName().equals("Taco")) {
            imgItem.setImageResource(R.drawable.taco);
        }

        txtItem.setText(tempMenuItem.getName());
        priceItem.setText(price);
        qtyItem.setText(quantity);

        return convertView;
    }
}
