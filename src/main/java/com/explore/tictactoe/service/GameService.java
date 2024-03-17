/**
 * Created by Fahmi on 16/03/24, fahmiokta2405@gmail.com
 * Project: tictactoe
 * Copyright (c) 2024 Fahmi. All rights reserved.
 **/
package com.explore.tictactoe.service;

import com.explore.tictactoe.model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GameService {
    public abstract Game createGame(int size);
    public abstract Game playGame(Map<String, String> request);

    public abstract Game checkWinner(Game game, boolean isEmpty);

    public List<List<Integer>> reCreateBoard(Map<String, String> request, int size) {
        List<List<Integer>> boardSize = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(Integer.parseInt(request.get("idx." + i + "." + j)));
            }
            boardSize.add(row);
        }
        return boardSize;
    }
}
