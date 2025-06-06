package com.newsSummeriser.ui;

import com.newsSummeriser.dto.UserDto;
import com.newsSummeriser.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserControllerPage {

    @Autowired
    private UserService userService;

    // 🧾 Show Profile Page
    @GetMapping("/profile")
    public String getUserProfile(Model model) {
        UserDto userDto = userService.viewProfile();
        model.addAttribute("user", userDto);
        return "profile"; // maps to src/main/resources/templates/profile.html
    }

    // 🔐 Show Update Password Form
    @GetMapping("/update-password")
    public String showUpdatePasswordForm() {
        return "update-password"; // maps to src/main/resources/templates/update-password.html
    }

    // 🔐 Handle Update Password Submission
    // @PostMapping("/update-password")
    // public String updatePassword(@RequestParam String oldPassword,
    //                              @RequestParam String newPassword,
    //                              Model model) {
    
    //     boolean updated = userService.updatePassword(oldPassword, newPassword);
    
    //     if (updated) {
    //         model.addAttribute("successMessage", "Password updated successfully.");
    //     } else {
    //         model.addAttribute("errorMessage", "Old password is incorrect.");
    //     }
    
    //     return null; // renders templates/index.html directly with message
    // }

}