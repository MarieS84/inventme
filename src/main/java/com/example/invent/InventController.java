package com.example.invent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InventController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String goToHomePage() {
        return "index";
    }

    @PostMapping("/")
    String item(HttpSession session, @RequestParam String productCategory, @RequestParam String item, @RequestParam String expiryDate) {
        List<String> list = (List<String>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("list", list);
        }

        list.add(item);
        list.add(expiryDate);
        list.add(productCategory);
        return "index";
    }

    @GetMapping("/register")
    String register() {
        return "register";
    }

    @PostMapping("/register")
    String reg(HttpSession session, Model model, User user, @RequestParam String email, @RequestParam String password) {
        if(!email.equals(null) && !password.equals(null)){
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        userService.addUserToRepository(user);
        model.addAttribute("users", userService.getAllUsers());
        }

        return "index";
    }
}
