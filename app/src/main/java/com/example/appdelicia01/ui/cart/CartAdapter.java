package com.example.appdelicia01.ui.cart;

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
import java.util.Map;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.VH> {

    public interface Listener {
        void onRemove(Product p);
    }

    private final List<Product> products;           // Productos únicos
    private final Map<String, Integer> quantities;  // Cantidades por ID
    private final Listener listener;

    public CartAdapter(List<Product> products, Map<String, Integer> quantities, Listener listener) {
        this.products = products;
        this.quantities = quantities;
        this.listener = listener;
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price, qty;
        MaterialButton remove;

        VH(View v) {
            super(v);
            image = v.findViewById(R.id.cartItemImage);
            name = v.findViewById(R.id.cartItemName);
            price = v.findViewById(R.id.cartItemPrice);
            qty = v.findViewById(R.id.cartItemQty);
            remove = v.findViewById(R.id.btnRemove);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Product p = products.get(position);
        int quantity = quantities.getOrDefault(p.getId(), 0);

        holder.name.setText(p.getName());
        holder.price.setText(String.format(Locale.getDefault(), "S/ %.2f", p.getPrice()));
        holder.qty.setText("Cantidad: " + quantity);

        // Imagen real del producto
        holder.image.setImageResource(p.getImageResId());

        // Botón para quitar 1 unidad
        holder.remove.setOnClickListener(v -> listener.onRemove(p));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
