package com.example.invent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(HttpServletRequest request, Model model, HttpSession session, @RequestParam String firstName, @RequestParam  String lastName, @RequestParam String password, @RequestParam String username){
        User newUser = userRepository.findUserByUsername(username);
        model.addAttribute("username", username);
        if(newUser == null){
            User user = new User(encoder.encode(password), firstName, lastName, username);
            Role role = roleRepository.findById(2L).get();
            user.addRole(role);
            role.addUser(user);
            userRepository.save(user);
            roleRepository.save(role);

            try {
                request.login(username, password);
            } catch (ServletException e) {
                e.printStackTrace();
            }

            return "redirect:/";
        }
        else{
            model.addAttribute("message", "You already have an account.");
            return "register";

        }
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout";
    }
}
