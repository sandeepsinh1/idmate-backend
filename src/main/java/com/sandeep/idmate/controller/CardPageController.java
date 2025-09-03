package com.sandeep.idmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.repository.CardRepository;
import com.sandeep.idmate.service.CardService;


@Controller
@RequestMapping("/car")

public class CardPageController {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public String getCardPage(@PathVariable("id") Long id, Model model) {
        CardEntity card = cardRepository.findById(id).orElseThrow();
        model.addAttribute("card", card);
        return "card-page"; // card.html (Thymeleaf)
    }
    

    @GetMapping("cd/{phone}")
    public String getCardPage(@PathVariable("phone") String id, Model model) {
        CardEntity card = cardService.getCardDetails(id).orElseThrow();
        model.addAttribute("card", card);
        return "card-page"; // card.html (Thymeleaf)
    }
    @PostMapping("/insertDetail")
    public String createCard1(@RequestBody CardEntity card, @RequestParam Long userId) {
        // 1. Save card
        cardService.insertDetail(card, userId);

        // 2. Redirect to a unique URL (example: /card/{userId})
        return "redirect:/car/card/" + userId;
    }

    @GetMapping("/card/{userId}")
    public String getCardPage1(@PathVariable Long userId, Model model) {
        CardEntity card = cardRepository.findById(userId).orElseThrow();
        model.addAttribute("card", card);
        return "card-page"; // Thymeleaf template card-page.html
    }
     

}
