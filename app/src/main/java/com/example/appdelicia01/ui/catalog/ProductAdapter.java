package com.example.appdelicia01.ui.catalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdelicia01.R;
import com.example.appdelicia01.domain.model.Product;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.VH> {
    public interface Listener {
        void onAdd(Product p);
        void onShare(Product p);
    }

    private final List<Product> data;
    private final Listener listener;

    public ProductAdapter(List<Product> data, Listener l) {
        this.data = data;
        this.listener = l;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView name, price;
        MaterialButton add, share;
        ImageView img;

        VH(View v){
            super(v);
            name = v.findViewById(R.id.txtName);
            price = v.findViewById(R.id.txtPrice);
            add = v.findViewById(R.id.btnAdd);
            share = v.findViewById(R.id.btnShare);
            img = v.findViewById(R.id.imgProduct);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup p, int vt){
        return new VH(LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_product, p, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int i){
        Product p = data.get(i);
        h.name.setText(p.getName());
        h.price.setText(String.format(Locale.getDefault(),"S/ %.2f", p.getPrice()));
        h.img.setImageResource(p.getImageResId());

        h.add.setOnClickListener(v -> listener.onAdd(p));
        h.share.setOnClickListener(v -> listener.onShare(p));
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
