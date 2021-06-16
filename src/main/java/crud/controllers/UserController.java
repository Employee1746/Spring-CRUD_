package crud.controllers;

import crud.Model.User;
import crud.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

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
}
