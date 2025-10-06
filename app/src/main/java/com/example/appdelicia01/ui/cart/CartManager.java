package com.example.appdelicia01.ui.cart;

import com.example.appdelicia01.domain.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartManager {

    private static CartManager instance;

    // Productos disponibles en el catálogo (id → producto)
    private final Map<String, Product> allProducts = new HashMap<>();

    // Carrito: id de producto → cantidad
    private final Map<String, Integer> cart = new HashMap<>();

    private CartManager() {}

    public static CartManager get() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    // Registrar productos desde el catálogo
    public void indexProducts(List<Product> products) {
        for (Product p : products) {
            allProducts.put(p.getId(), p);
        }
    }

    // Agregar al carrito
    public void add(String productId) {
        int qty = cart.getOrDefault(productId, 0);
        cart.put(productId, qty + 1);
    }

    // Quitar 1 del carrito
    public void remove(String productId) {
        if (cart.containsKey(productId)) {
            int qty = cart.get(productId);
            if (qty <= 1) {
                cart.remove(productId);
            } else {
                cart.put(productId, qty - 1);
            }
        }
    }

    // Vaciar carrito
    public void clear() {
        cart.clear();
    }

    // Lista completa (con productos repetidos según cantidad)
    public List<Product> getProductsInCart() {
        List<Product> items = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String id = entry.getKey();
            int qty = entry.getValue();
            Product p = allProducts.get(id);
            if (p != null) {
                for (int i = 0; i < qty; i++) {
                    items.add(p);
                }
            }
        }
        return items;
    }

    // Devuelve productos únicos (1 por id, sin repetir)
    public List<Product> getUniqueProducts() {
        List<Product> items = new ArrayList<>();
        for (String id : cart.keySet()) {
            Product p = allProducts.get(id);
            if (p != null) items.add(p);
        }
        return items;
    }

    // Devuelve el mapa interno (id → cantidad)
    public Map<String, Integer> getCartMap() {
        return new HashMap<>(cart);
    }

    // Calcular total
    public double getTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            Product p = allProducts.get(entry.getKey());
            if (p != null) {
                total += p.getPrice() * entry.getValue();
            }
        }
        return total;
    }

    // Cantidad total de ítems en el carrito
    public int getCount() {
        int count = 0;
        for (int qty : cart.values()) {
            count += qty;
        }
        return count;
    }

    // Verificar si el carrito está vacío
    public boolean isEmpty() {
        return cart.isEmpty();
    }
}
