package com.example.invent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired ProductRepository productRepo;

    Product addProductToRepository(Product p) {
        productRepo.addProduct(p);
        return p;
    }

    public List<Product> getAllProducts() {
        return productRepo.getProducts();
    }


}
