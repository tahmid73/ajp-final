package com.controller;

import com.model.User;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String sortKey) {
        List<User> users = new ArrayList<>();
        if (sortKey != null) {
            int field = Integer.parseInt(sortKey);
            users = userService.sort(field);
        }
        else {
            users = userService.getAll();
        }
        model.addAttribute("users", users);
        return "user-list";
    }

    @RequestMapping("/user-create-form")
    public String userCreateForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-user-form";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/user-update-form")
    public String userUpdateForm(@RequestParam("userId") int id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "update-user-form";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(name = "searchValue", required = false) String firstname, Model model) {
        List<User> users = new ArrayList<>();
        if (firstname == null) {
            users = userService.getAll();
        }
        else {
            users = userService.getAll(firstname);
        }
        model.addAttribute("users", users);
        return "user-list";
    }
}
