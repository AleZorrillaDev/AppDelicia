package com.example.appdelicia01.data;

import com.example.appdelicia01.R;
import com.example.appdelicia01.domain.model.Product;
import java.util.Arrays;
import java.util.List;

public class SampleData {
    public static List<Product> products() {
        return Arrays.asList(
                new Product("p1","Torta de Chocolate","Bizcocho húmedo con cobertura",45.5, R.drawable.torta_chocolate),
                new Product("p2","Cheesecake de Fresas","Cremoso con fresas frescas",39.9, R.drawable.cheesecake_fresas),
                new Product("p3","Pie de Manzana","Clásico con canela",32.0, R.drawable.pie_manzana),
                new Product("p4","Cheesecake de Oreo","Con galletas Oreo trituradas",36.0, R.drawable.cheesecake_oreo),
                new Product("p5","Torta Tres Leches","Suave y húmeda",40.0, R.drawable.torta_tres_leches),
                new Product("p6","Pie de Piña","Relleno tropical",30.0, R.drawable.pie_pina),
                new Product("p7","Tiramisú","Tradicional italiano",42.0, R.drawable.tiramisu),
                new Product("p8","Cupcake Vainilla","Decorado con frosting",15.0, R.drawable.cupcake_vainilla),
                new Product("p9","Brownie de Chocolate","Con chispas de chocolate",20.0, R.drawable.brownie_chocolate),
                new Product("p10","Alfajores","Dulces rellenos de manjar",18.0, R.drawable.alfajores)
        );

    }
}
