package com.example.javagyakorlat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class F1Controller {
    @Autowired private gpRepo gpRepo;
    @Autowired private pilotaRepo pilotaRepo;
    @Autowired private eredmenyRepo eredmenyRepo;
    @Autowired private messageRepo messageRepo;

    @GetMapping("/")
    public String standard(Model model) {
        String str="";
        model.addAttribute("str",str);
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/db")
    public String db(Model model) {
        model.addAttribute("eredmenyek",eredmenyRepo.findAll());
        return "db";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("message", new message());
        return "contact";
    }

    @GetMapping("/messages")
    public String messages(Model model) {
        model.addAttribute("messages", messageRepo.findAll());
        return "messages";
    }

    @GetMapping("/diagram")
    public String diagram(Model model) {
        return "diagram";
    }

    @GetMapping("/crud")
    public String crud(Model model) {
        model.addAttribute("eredmenyek",eredmenyRepo.findAll());
        return "crud";
    }

    @PostMapping(value="/send")
    public String saveRes(@ModelAttribute message message) {
        messageRepo.save(message);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newRes(Model model) {
        model.addAttribute("eredmeny", new eredmeny());
        return "new";
    }

    @PostMapping(value="/save")
    public String saveRes(@ModelAttribute eredmeny eredmeny) {
        eredmenyRepo.save(eredmeny);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editRes(@PathVariable(name="id")int id,Model model) {
        model.addAttribute("eredmeny",eredmenyRepo.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editRes(@ModelAttribute eredmeny eredmeny) {
        eredmenyRepo.save(eredmeny);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteRes(@PathVariable(name = "id") int id) {
        eredmenyRepo.delete(eredmenyRepo.findById(id).get());
        return "redirect:/";
    }

    @GetMapping("/rest")
    public String rest(Model model) {
        return "rest";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/passtest")
    @ResponseBody
    public String jelszóTeszt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode("jelszo1");
    }

    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "register";
    }

    @Autowired
    private UserRepo userRepo;
    @PostMapping("/reg_compute")
    public String Register(@ModelAttribute User user, Model model) {
        for(User user2:userRepo.findAll())
            if(user2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "Email already exists");
                return "regerror";
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("ROLE_Felhasznalo");
            userRepo.save(user);
            model.addAttribute("id", user.getId());
            return "regsuccess";

    }
}
