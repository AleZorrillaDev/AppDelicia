package com.example.appdelicia01.ui.payment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdelicia01.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_payment);

        findViewById(R.id.btnPayCard).setOnClickListener(v -> {
            Toast.makeText(this, "Pago con tarjeta procesado", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        });

        findViewById(R.id.btnPayCash).setOnClickListener(v -> {
            Toast.makeText(this, "Pago en efectivo registrado", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        });
    }
}
