package crud.controllers;

import crud.Model.User;
import crud.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("users", userList);
        return "all-users";
    }

    @GetMapping("/create")
    public String createForm(@ModelAttribute("user") User user) {
        return "create-form";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";

    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.userById(id);
        model.addAttribute("user", user); //юзер будет передан при помощи модели в форму
        return "/user-update";
    }

    //id не нужен тк откуда-то получу данные
    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}

