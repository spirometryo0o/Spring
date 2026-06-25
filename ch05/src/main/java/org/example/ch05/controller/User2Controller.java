package org.example.ch05.controller;


import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.User2DTO;
import org.example.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {

    // @RequiredArgsConstructor 어노테이션으로 의존객체 주입 ⭐⭐⭐⭐⭐
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model){

        // 조회 서비스 요청
        List<User2DTO> dtoList = service.getAll();

        // 모델참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        System.out.println(dto);

        // 등록 서비스 호출
        service.register(dto);


        return "redirect:/user2/list?register=success";
    }

    @GetMapping("/user2/modify")
    public String modify(String userid, Model model){
        System.out.println(userid);

        // 수정 조회 서비스 호출
        User2DTO dto = service.getById(userid);

        // 모델참조
        model.addAttribute(dto); // 키값 생략하면 해당 객체 소문자로 시작하는 타입명

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto){
        System.out.println(dto);

        // 수정 서비스 요청
        service.modify(dto);

        // 수정 후 목록 이동
        return "redirect:/user2/list?modify=success";
    }

    @GetMapping("/user2/remove")
    public String remove(String userid){
        System.out.println(userid);

        // 삭제 서비스 요청
        service.remove(userid);

        // 삭제 후 목록 이동
        return "redirect:/user2/list?remove=success";
    }


}