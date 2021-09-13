package com.example.invent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InventController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String goToHomePage(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }


    @PostMapping("/")
    String addProduct(HttpSession session, Product product){
        List<Product> products = (List<Product>)session.getAttribute("products");
        //List<Product> products = (List<Product>)productService.getAllProducts();
        if (products== null){
            products = new ArrayList<>();
            session.setAttribute("products", products);

        }

        productService.addProductToRepository(product);
        products.add(product);

        return "index";
    }
}
