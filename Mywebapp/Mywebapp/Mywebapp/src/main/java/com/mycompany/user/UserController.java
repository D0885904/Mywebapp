package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Service
public class UserController {
    @Autowired
    private UserService service;
    private UserPost userPost;
    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewFrom(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_from";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users";
    }
    /**
     * Immplementation of updated and delete
     */
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");

            return "user_from";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The user id" + id + "has been deleted");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

    /*@GetMapping("/users/check")
    public String Usercheck(String user_email, String user_password, HttpSession session){
        try{
            System.out.println(user_email + user_password);
            List<User> user_info = service.listAll();
            for(int i  = 0; i < user_info.size(); i++){
                if(user_info.get(i).getUser_email().equal(user_email).&& user_info.get(i).getUser_password().equals(user_password)){
                    System.out.println("User: " + user_info.get(i).getUser_email() + "Login Successfully!");
                    session.setAttribute("UserSession", user_info.get(i));
                    return "redirect:/" + user_info.get(i).getID();
                }
            }
        }catch (Exception e){
            System.out.println("User not found");
        }
        return "redirect:/user/login";
    }*/

}
