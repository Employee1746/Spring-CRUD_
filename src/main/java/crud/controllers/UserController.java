package crud.controllers;

import crud.Model.User;
import crud.userService.UserService;
import crud.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("allUsers", userList);
        return "all-users";
    }
}
