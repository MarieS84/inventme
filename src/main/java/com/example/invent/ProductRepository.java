package com.example.invent;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public Product addProduct(Product product) {
        Product lastProduct = products.get(products.size() - 1);
        product.setProductId(lastProduct.getProductId() + 1);
        products.add(product);
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }
}
