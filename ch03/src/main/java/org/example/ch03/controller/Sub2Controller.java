package org.example.ch03.controller;

import org.example.ch03.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public  String register(){
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDTO userDTO){
        System.out.println(userDTO);

        return "redirect:/index";
    }


    @GetMapping("/sub2/param")
    public String param(@RequestParam("name") String name, int age){ // 파라미터 이름에 맞게 매개변수 선언

        System.out.println("name : " + name);
        System.out.println("age : " + age);

        // 리다이렉트
        return "redirect:/index";

    }

}
