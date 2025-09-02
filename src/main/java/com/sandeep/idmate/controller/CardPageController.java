package com.sandeep.idmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.repository.CardRepository;


@Controller
@RequestMapping("/car")

public class CardPageController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/{id}")
    public String getCardPage(@PathVariable("id") Long id, Model model) {
        CardEntity card = cardRepository.findById(id).orElseThrow();
        model.addAttribute("card", card);
        return "card-page"; // card.html (Thymeleaf)
    }
}
