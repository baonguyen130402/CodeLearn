package com.env.gs.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.env.gs.configuration.Jwt.JwtTokenProvider;
import com.env.gs.domain.User;
import com.env.gs.request.LoginRequest;
import com.env.gs.request.UserCreateRequest;
import com.env.gs.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/v3/auth")
@Tag(name = "Account-API")
public class AuthenticationController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String email = jwtTokenProvider.getUserEmailFromJwt(request.getToken());
        User user = userService.findUserByName(email);
        UserCreateRequest newUser = new UserCreateRequest();

        if (user != null) {
            return ResponseEntity.ok(jwtTokenProvider.generateToken(user));
        } else {
            newUser.setEmail(email);
            newUser.setRoleId(1);
            newUser.setFullName("user");
        }

        return ResponseEntity.ok(jwtTokenProvider.generateToken(userService.addUser(newUser)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.addUser(request));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
