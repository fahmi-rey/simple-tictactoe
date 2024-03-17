/**
 * Created by Fahmi on 16/03/24, fahmiokta2405@gmail.com
 * Project: tictactoe
 * Copyright (c) 2024 Fahmi. All rights reserved.
 **/
package com.explore.tictactoe.service;

import java.util.Map;

public interface TicTacToeGameService {
    String[] calculateMove(Map<String, String> request, int size);
}
