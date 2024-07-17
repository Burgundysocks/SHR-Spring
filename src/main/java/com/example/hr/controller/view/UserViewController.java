package com.example.hr.controller.view;

import com.example.hr.domain.dto.UserDTO;
import com.example.hr.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserViewController {

    @Autowired
    private UserService uservice;

    @GetMapping("/join")
    public String showJoinForm() {
        return "user/join";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam String userId, Model model) {
        UserDTO user = uservice.getUser(userId); // 추가된 메소드
        model.addAttribute("user", user);
        return "user/update";
    }

    @GetMapping("/delete")
    public String showDeleteForm() {
        return "user/delete";
    }
}
