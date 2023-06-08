package ru.rumyantsev.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rumyantsev.SpringBoot.entity.User;
import ru.rumyantsev.SpringBoot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public String showAllUser (Model model){
        model.addAttribute("fromUser", userService.getAllUsers());
        return "all-user";
    }
    @GetMapping("/addUser")
    public String addUser (Model model){
        model.addAttribute("addUser", new User());
        return "addUser";
    }
    @PostMapping("/saveUser")
    public String saveUser (@ModelAttribute("addUser") User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("pages/{id}")
    public String find(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "IdUser";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.removeUserById(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id")Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
