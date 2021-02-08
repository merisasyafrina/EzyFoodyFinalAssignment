package com.hfad.ezyfoody.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.ezyfoody.Menu.MenuItem;
import com.hfad.ezyfoody.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class HistoryDetailAdapter extends BaseAdapter {
    Context context;
    ArrayList<MenuItem> item = new ArrayList<>();

    MenuItem tempItem;

    public HistoryDetailAdapter(Context context, ArrayList<MenuItem> item) {
        this.context = context;
        this.item = item;
    }
    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_complete_order_list, parent,false);
        }

        tempItem = (MenuItem) getItem(position);

        TextView txtItem = (TextView)convertView.findViewById(R.id.txtItem);
        TextView txtQty = (TextView)convertView.findViewById(R.id.qtyItem);
        TextView txtPrice = (TextView)convertView.findViewById(R.id.priceItem) ;
        ImageView img = (ImageView)convertView.findViewById(R.id.imgItem);

        String quantity = String.valueOf(tempItem.getQty());

        double harga = tempItem.getPrice();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String price = kursIndonesia.format(harga);

        if(tempItem.getName().equals("Mineral Water")){
            img.setImageResource(R.drawable.drink);
        }else if(tempItem.getName().equals("Mango Juice")){
            img.setImageResource(R.drawable.mango);
        }else if(tempItem.getName().equals("Avocado Juice")){
            img.setImageResource(R.drawable.avocado);
        }else if(tempItem.getName().equals("Apple Juice")){
            img.setImageResource(R.drawable.apple);
        }else if(tempItem.getName().equals("Soup")){
            img.setImageResource(R.drawable.soup);
        }else if(tempItem.getName().equals("Fried Rice")){
            img.setImageResource(R.drawable.friedrice);
        }else if(tempItem.getName().equals("Ramen")){
            img.setImageResource(R.drawable.ramen);
        }else if(tempItem.getName().equals("Porridge")){
            img.setImageResource(R.drawable.porridge);
        }else if(tempItem.getName().equals("Chips")){
            img.setImageResource(R.drawable.chips);
        }else if(tempItem.getName().equals("French Fries")){
            img.setImageResource(R.drawable.frenchfries);
        }else if(tempItem.getName().equals("Cinnamon Roll")){
            img.setImageResource(R.drawable.cinnamonroll);
        }else if(tempItem.getName().equals("Taco")){
            img.setImageResource(R.drawable.taco);
        }

        txtItem.setText(tempItem.getName());
        txtQty.setText(quantity);
        txtPrice.setText(price);

        return convertView;
    }
}
