package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfoody.Activities.MenuActivity.DrinksActivity;
import com.hfad.ezyfoody.R;

public class OrderActivity extends AppCompatActivity {
    public static final String NAME = "com.example.ezyfoody.NAME";
    public static final String QUANTITY = "com.example.ezyfoody.QUANTITY";
    public static final String PRICE = "com.example.ezyfoody.PRICE";

    public String name = "";
    public String price = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        String item = intent.getStringExtra(DrinksActivity.ITEM);

        ImageView imgItem = findViewById(R.id.imgItem);

        TextView txtItem = findViewById(R.id.txtItem);
        txtItem.setText(item);

        TextView priceItem = findViewById(R.id.priceItem);



        if(item.equals("Mineral Water")){
            imgItem.setImageResource(R.drawable.drink);
            name = item;
            priceItem.setText("Rp 5000");
            price = "5000";
        }else if(item.equals("Mango Juice")){
            imgItem.setImageResource(R.drawable.mango);
            name = item;
            priceItem.setText("Rp 20000");
            price = "20000";
        }else if(item.equals("Avocado Juice")){
            imgItem.setImageResource(R.drawable.avocado);
            name = item;
            priceItem.setText("Rp 20000");
            price = "20000";
        }else if(item.equals("Apple Juice")){
            imgItem.setImageResource(R.drawable.apple);
            name = item;
            priceItem.setText("Rp 20000");
            price = "20000";
        }else if(item.equals("Soup")){
            imgItem.setImageResource(R.drawable.soup);
            name = item;
            priceItem.setText("Rp 10000");
            price = "10000";
        }else if(item.equals("Fried Rice")){
            imgItem.setImageResource(R.drawable.friedrice);
            name = item;
            priceItem.setText("Rp 20000");
            price = "20000";
        }else if(item.equals("Ramen")){
            imgItem.setImageResource(R.drawable.ramen);
            name = item;
            priceItem.setText("Rp 15000");
            price = "15000";
        }else if(item.equals("Porridge")){
            imgItem.setImageResource(R.drawable.porridge);
            name = item;
            priceItem.setText("Rp 20000");
            price = "20000";
        }else if(item.equals("Chips")){
            imgItem.setImageResource(R.drawable.chips);
            name = item;
            priceItem.setText("Rp 5000");
            price = "5000";
        }else if(item.equals("French Fries")){
            imgItem.setImageResource(R.drawable.frenchfries);
            name = item;
            priceItem.setText("Rp 10000");
            price = "10000";
        }else if(item.equals("Cinnamon Roll")){
            imgItem.setImageResource(R.drawable.cinnamonroll);
            name = item;
            priceItem.setText("Rp 10000");
            price = "10000";
        }else if(item.equals("Taco")){
            imgItem.setImageResource(R.drawable.taco);
            name = item;
            priceItem.setText("Rp 10000");
            price = "10000";
        }
    }

    public void clickInputQty(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        EditText editText = findViewById(R.id.insertQty);
        String qty = editText.getText().toString();

        if(qty.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(),"Min. 1 Item Has to Be Inserted",Toast.LENGTH_SHORT);
            toast.show();
        }else if(Integer.parseInt(qty) < 1){
            Toast toast = Toast.makeText(getApplicationContext(),"Min. 1 Item Has to Be Inserted",Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Quantity Successfully Inserted",Toast.LENGTH_SHORT);
            toast.show();

            intent.putExtra(NAME, name);
            intent.putExtra(QUANTITY, qty);
            intent.putExtra(PRICE, price);

            startActivity(intent);
        }
    }

    public void clickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void clickOrderMore(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}