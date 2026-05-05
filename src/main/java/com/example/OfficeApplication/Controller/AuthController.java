package com.example.OfficeApplication.Controller;

import com.example.OfficeApplication.Entity.User;
import com.example.OfficeApplication.Security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if ("manager".equals(user.getUsername())) {
            return jwtUtil.generateToken("manager", "ROLE_MANAGER");
        }

        return jwtUtil.generateToken("dev", "ROLE_DEVELOPER");
    }
}