package com.offcn.user.controller;

import com.offcn.user.bean.User;
import com.offcn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    @InitBinder
    public void convDate(WebDataBinder wbd) {
        wbd.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        us.saveUser(user);
        return "redirect:/user/findUsers";
    }

    @RequestMapping("/delUser/{id}")
    public String delUser(@PathVariable(name = "id") Integer id) {
        us.delUser(id);
        return "redirect:/user/findUsers";
    }

    @RequestMapping("/updUser")
    public String updUser(User user) {
        us.updUser(user);
        return "redirect:/user/findUsers";
    }

    @RequestMapping("/findUsers")
    public String findUsers(Model m) {
        List<User> users = us.findUsers();
        m.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/toEdit/{id}")
    public String findUser(Model m, @PathVariable(name = "id") Integer id) {
        User user = us.findUser(id);
        m.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }
}
