/*
 * Copyright (C) 2023 Mack Solomon LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.tictactoe;

import java.util.ArrayList;
import java.util.List;
import org.tictactoe.TicTacToe.*;

public class BoardFixture {
  public static List<List<Cell>> NO_WINNER_BOARD() {
    List<List<Cell>> board = new ArrayList<>();

    board.add(new ArrayList<>());
    board.get(0).add(new Cell(0, 0, Player.NONE));
    board.get(0).add(new Cell(0, 0, Player.NONE));
    board.get(0).add(new Cell(0, 0, Player.NONE));

    board.add(new ArrayList<>());
    board.get(1).add(new Cell(0, 0, Player.NONE));
    board.get(1).add(new Cell(0, 0, Player.NONE));
    board.get(1).add(new Cell(0, 0, Player.NONE));

    board.add(new ArrayList<>());
    board.get(2).add(new Cell(0, 0, Player.NONE));
    board.get(2).add(new Cell(0, 0, Player.NONE));
    board.get(2).add(new Cell(0, 0, Player.NONE));

    return board;
  }

  public static List<List<Cell>> HORIZONTAL_WINNER_BOARD() {
    List<List<Cell>> board = new ArrayList<>();

    board.add(new ArrayList<>());
    board.get(0).add(new Cell(0, 0, Player.X));
    board.get(0).add(new Cell(0, 1, Player.X));
    board.get(0).add(new Cell(0, 2, Player.X));

    board.add(new ArrayList<>());
    board.get(1).add(new Cell(1, 0, Player.NONE));
    board.get(1).add(new Cell(1, 1, Player.NONE));
    board.get(1).add(new Cell(1, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(2).add(new Cell(2, 0, Player.NONE));
    board.get(2).add(new Cell(2, 1, Player.NONE));
    board.get(2).add(new Cell(2, 2, Player.NONE));

    return board;
  }

  public static List<List<Cell>> VERTICAL_WINNER_BOARD() {
    List<List<Cell>> board = new ArrayList<>();

    board.add(new ArrayList<>());
    board.get(0).add(new Cell(0, 0, Player.X));
    board.get(0).add(new Cell(0, 1, Player.NONE));
    board.get(0).add(new Cell(0, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(1).add(new Cell(1, 0, Player.X));
    board.get(1).add(new Cell(1, 1, Player.NONE));
    board.get(1).add(new Cell(1, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(2).add(new Cell(2, 0, Player.X));
    board.get(2).add(new Cell(2, 1, Player.NONE));
    board.get(2).add(new Cell(2, 2, Player.NONE));

    return board;
  }

  public static List<List<Cell>> DIAGONAL_WINNER_BOARD() {
    List<List<Cell>> board = new ArrayList<>();

    board.add(new ArrayList<>());
    board.get(0).add(new Cell(0, 0, Player.X));
    board.get(0).add(new Cell(0, 1, Player.NONE));
    board.get(0).add(new Cell(0, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(1).add(new Cell(1, 0, Player.NONE));
    board.get(1).add(new Cell(1, 1, Player.X));
    board.get(1).add(new Cell(1, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(2).add(new Cell(2, 0, Player.NONE));
    board.get(2).add(new Cell(2, 1, Player.NONE));
    board.get(2).add(new Cell(2, 2, Player.X));

    return board;
  }

  public static List<List<Cell>> REVERSE_DIAGONAL_WINNER_BOARD() {
    List<List<Cell>> board = new ArrayList<>();

    board.add(new ArrayList<>());
    board.get(0).add(new Cell(0, 0, Player.NONE));
    board.get(0).add(new Cell(0, 1, Player.NONE));
    board.get(0).add(new Cell(0, 2, Player.X));

    board.add(new ArrayList<>());
    board.get(1).add(new Cell(1, 0, Player.NONE));
    board.get(1).add(new Cell(1, 1, Player.X));
    board.get(1).add(new Cell(1, 2, Player.NONE));

    board.add(new ArrayList<>());
    board.get(2).add(new Cell(2, 0, Player.X));
    board.get(2).add(new Cell(2, 1, Player.NONE));
    board.get(2).add(new Cell(2, 2, Player.NONE));

    return board;
  }
}
