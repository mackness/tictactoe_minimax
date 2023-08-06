/*
 * Copyright (C) 2023 Mack Solomon
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
import java.util.stream.Collectors;
import org.tictactoe.TicTacToe.*;

public class Board {

  private final List<List<Cell>> board;

  public Board() {
    this.board = this.makeBoard();
  }

  public Board(List<List<Cell>> board) {
    this.board = board;
  }

  public List<List<Cell>> getBoard() {
    return board;
  }

  private List<List<Cell>> makeBoard() {
    List<List<Cell>> board = new ArrayList<>();

    for (int row = 0; row <= 2; row++) {
      board.add(new ArrayList<>());
      for (int column = 0; column <= 2; column++) {
        board.get(row).add(new Cell(row, column, Player.NONE));
      }
    }

    return board;
  }

  public static List<List<Cell>> nextBoard(List<List<Cell>> board, Position move, Player player) {
    return board.stream()
        .map(
            row ->
                row.stream()
                    .map(
                        cell -> {
                          Position pos = cell.getPosition();
                          if (pos.getRow().equals(move.getRow())
                              && pos.getColumn().equals(move.getColumn())) {
                            return new Cell(pos.getRow(), pos.getColumn(), player);
                          } else {
                            return cell;
                          }
                        })
                    .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  public static void renderBoard(List<List<Cell>> board) {
    board.stream()
        .map(
            row ->
                row.stream()
                    .map(
                        cell -> {
                          switch (cell.getPlayer()) {
                            case O:
                              return "O";
                            case X:
                              return "X";
                            default:
                              return " ";
                          }
                        }))
        .map(row -> row.collect(Collectors.toList()).toString())
        .forEach(GameOps::print);
  }

  public static boolean isBoardFull(List<List<Cell>> board) {
    for (List<Cell> cells : board) {
      for (Cell cell : cells) {
        if (cell.getPlayer().equals(Player.NONE)) {
          return false;
        }
      }
    }
    return true;
  }
}
