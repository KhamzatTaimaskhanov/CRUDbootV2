package web.CRUDbootV2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.CRUDbootV2.models.User;
import web.CRUDbootV2.service.UserService;


@Controller
public class ControllerUser {
    private final UserService userService;
    @Autowired
    public ControllerUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Transactional
    public String index(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "user/index";
    }
    @GetMapping("/{id}")
    @Transactional
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user/show";
    }
    @GetMapping("/new")
    @Transactional
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "user/new";
    }
    @PostMapping("/")
    @Transactional
    public String create(@ModelAttribute("user") User user){
        userService.saveUserByUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    @Transactional
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUserById(id));
        return "user/edit";
    }
    @PatchMapping("/{id}")
    @Transactional
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.updateUserByUserAndId(user,id);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    @Transactional
    public String delete(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
