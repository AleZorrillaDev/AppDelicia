package com.example.appdelicia01.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdelicia01.R;
import com.example.appdelicia01.data.SampleData;
import com.example.appdelicia01.domain.model.Product;
import com.example.appdelicia01.ui.cart.CartActivity;
import com.example.appdelicia01.ui.cart.CartManager;

import java.util.List;

public class CatalogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_catalog);

        // Cargar productos
        List<Product> items = SampleData.products();

        // Indexar productos en el CartManager
        CartManager.get().indexProducts(items);

        // Configurar RecyclerView
        RecyclerView rv = findViewById(R.id.rvProducts);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ProductAdapter(items, new ProductAdapter.Listener() {
            @Override
            public void onAdd(Product p) {
                CartManager.get().add(p.getId());
                Toast.makeText(CatalogActivity.this,
                        "Agregado: " + p.getName(),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CatalogActivity.this, CartActivity.class);
                startActivity(intent);
            }

            @Override
            public void onShare(Product p) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,
                        p.getName() + " – S/ " + p.getPrice());
                startActivity(Intent.createChooser(share, "Compartir producto"));
            }
        }));
    }
}
