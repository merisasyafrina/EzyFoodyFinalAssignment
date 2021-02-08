package com.hfad.ezyfoody.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ezyfoody.R;
import com.hfad.ezyfoody.Saldo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TopUpActivity extends AppCompatActivity {
    Saldo saldo = Saldo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        TextView textView = findViewById(R.id.textViewBalance);

        double tempSaldo = Saldo.getInstance().getSaldo();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String balance = kursIndonesia.format(tempSaldo);
        textView.setText(balance);
    }

    public void clickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void clickTopUp(View view) {
        EditText editText =  findViewById(R.id.editTextAmount);

        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter the desired amount!", Toast.LENGTH_SHORT).show();
        }else{
            double amount = Double.parseDouble(editText.getText().toString());
            if(amount > 2000000){
                Toast.makeText(this, "Can't add more than 2 million", Toast.LENGTH_SHORT).show();
            }else if(amount < 1){
                Toast.makeText(this, "Please enter the desired amount!", Toast.LENGTH_SHORT).show();
            } else{
                amount += saldo.getSaldo();
                saldo.setSaldo(amount);
                Toast.makeText(this, "Money successfully added to your balance!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TopUpActivity.class);
                startActivity(intent);
            }
        }
    }

}