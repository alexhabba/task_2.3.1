package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.MyService;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping(value = "/")
    public String showIndex(ModelMap model) {
        model.addAttribute("listUsers", myService.listUsers());
        return "index";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        myService.addUser(user);
        return "added";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, ModelMap modelMap) {
        User user = myService.getUserById(id);
        modelMap.addAttribute("user", user);
        System.out.println(user);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("user") User user) {
        myService.updateUser(user);
        return "edited";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        myService.removeById(id);
        return "delete";
    }
}
