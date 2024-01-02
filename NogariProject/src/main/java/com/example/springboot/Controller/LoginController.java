package com.example.springboot.Controller;

import com.example.springboot.Controller.Request.LoginRequest;
import com.example.springboot.Controller.Request.UserSignupRequest;
import com.example.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class LoginController {

    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public String singUp(@RequestBody @Valid UserSignupRequest userSignupRequest){
        return userService.userSignup(userSignupRequest);

    }


    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @GetMapping("/myInfo")
    public String myInfo(@RequestBody @Valid) {

    }
}
