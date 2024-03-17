/**
 * Created by Fahmi on 15/03/24, fahmiokta2405@gmail.com
 * Project: tictactoe
 * Copyright (c) 2024 Fahmi. All rights reserved.
 **/
package com.explore.tictactoe.controller;

import com.explore.tictactoe.service.TicTacToeGameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    private final TicTacToeGameServiceImpl ticTacToeGameService;

    @Autowired
    public GameController(
            TicTacToeGameServiceImpl ticTacToeGameService
    ) {
        this.ticTacToeGameService = ticTacToeGameService;
    }

    @GetMapping("/")
    public String game() {
        return "index";
    }

    @GetMapping("/play")
    public String play(@RequestParam(name="size") int size, Model model) {
        model.addAttribute("object", ticTacToeGameService.createGame(size));
        return "play";
    }

    @PostMapping("/play")
    public String play(@RequestParam Map<String, String> request, Model model) {
        model.addAttribute("object", ticTacToeGameService.playGame(request));
        return "play";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
