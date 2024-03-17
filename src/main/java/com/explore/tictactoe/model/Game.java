/**
 * Created by Fahmi on 16/03/24, fahmiokta2405@gmail.com
 * Project: tictactoe
 * Copyright (c) 2024 Fahmi. All rights reserved.
 **/
package com.explore.tictactoe.model;

import java.util.List;

public class Game {
    private int size;

    private List<List<Integer>> boardSize;


    private String[] move;

    private boolean player;

    private int status;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Integer>> getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(List<List<Integer>> boardSize) {
        this.boardSize = boardSize;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String[] getMove() {
        return move;
    }

    public void setMove(String[] move) {
        this.move = move;
    }
}
