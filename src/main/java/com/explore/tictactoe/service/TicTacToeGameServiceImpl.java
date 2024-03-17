/**
 * Created by Fahmi on 16/03/24, fahmiokta2405@gmail.com
 * Project: tictactoe
 * Copyright (c) 2024 Fahmi. All rights reserved.
 **/
package com.explore.tictactoe.service;

import com.explore.tictactoe.model.Game;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class TicTacToeGameServiceImpl extends GameService implements TicTacToeGameService {
    @Override
    public Game createGame(int size) {
        // Create a new game with the given size
        List<List<Integer>> board = IntStream.range(0, size)
                .mapToObj(i -> Collections.nCopies(size, 0))
                .toList();

        // Set the game size, board size, and player
        Game game = new Game();
        game.setSize(size);
        game.setBoardSize(board);
        game.setPlayer(true);
        return game;
    }

    @Override
    public Game playGame(Map<String, String> request) {
        Game game = new Game();

        //Get Size
        game.setSize(Integer.parseInt(request.get("size")));
        request.remove("size");

        //Get Player
        game.setPlayer(!Boolean.parseBoolean(request.get("player")));
        request.remove("player");

        game.setStatus(Integer.parseInt(request.get("status")));
        request.remove("status");

        //Calculate the move
        game.setMove(calculateMove(request, game.getSize()));

        //Check the winner
        game = checkWinner(game, request.containsValue("0"));

        //Recreate the board
        game.setBoardSize(this.reCreateBoard(request, game.getSize()));
        return game;
    }

    @Override
    public Game checkWinner(Game game, boolean isEmpty) {
        //generate the string to validate the winner
        String validatePlayer1 = "1".repeat(game.getSize());
        String validatePlayer2 = "2".repeat(game.getSize());

        // Iterate over the moves made in the game
        for (String j : game.getMove()) {
            // If score === size, then player 2 is the winner
            if (j.equals(validatePlayer1)) {
                game.setStatus(1);
                return game;
            }
            // If score === size*2, then player 2 is the winner
            if (j.equals(validatePlayer2)) {
                game.setStatus(2);
                return game;
            }
        }
        // If no winner is found and the board is empty, set the size of the game to 0 (GAME STILL ON GOING)
        // If the board is not empty, set the size of the game to -1 (DRAW)
        game.setStatus(isEmpty ? 0 : -1);
        return game;
    }

    @Override
    public String[] calculateMove(Map<String, String> request, int size) {
        String[] arrResult = new String[(size * 2) + 2];
        // Initialize the array with empty strings
        Arrays.fill(arrResult, "");

        //Calculate the move
        request.forEach((key, value) -> {
            String[] idx = key.split("\\.");
            int row = Integer.parseInt(idx[1]);
            int col = Integer.parseInt(idx[2]);
            arrResult[row] += value;
            arrResult[size + col] += value;
            if (row == col) {
                arrResult[size * 2] += value;
            }
            if (row + col == size - 1) {
                arrResult[(size * 2) + 1] += value;
            }
        });

        return arrResult;
    }
}
