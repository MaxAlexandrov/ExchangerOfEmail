package com.exchanger.controller;

import com.exchanger.model.Message;
import com.exchanger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping
    public String getPage(Model model){
        return "admin-room";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        List<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findAll();
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("all_message", messages);
        return "admin-room";
    }
}
