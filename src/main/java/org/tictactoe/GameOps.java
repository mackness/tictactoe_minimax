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

import java.util.*;
import java.util.stream.Collectors;

public class GameOps {
  public static String input(String message) {
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static void print(String message) {
    System.out.println(message);
  }

  public static Position parseMove(String input) throws NumberFormatException {
    int row = 0;
    int column = 0;

    try {
      String[] split = input.split(",");
      row = Integer.parseInt(split[0]);
      column = Integer.parseInt(split[1]);
    } catch (Exception e) {
      GameOps.print("Failed to parse move input with " + e);
      System.exit(1);
    }

    return new Position(row, column);
  }

  public static TicTacToe.Player nextPlayer(TicTacToe.Player currentPlayer) {
    if (currentPlayer.equals(TicTacToe.Player.X)) {
      return TicTacToe.Player.O;
    }
    return TicTacToe.Player.X;
  }

  private static Integer rowCardinality(List<Cell> row) {
    HashSet<TicTacToe.Player> rowSet =
        row.stream().map(Cell::getPlayer).collect(Collectors.toCollection(HashSet::new));

    if (rowSet.iterator().next() != TicTacToe.Player.NONE) {
      return rowSet.size();
    } else {
      return -1;
    }
  }

  private static List<List<Cell>> rotateBoard90Deg(List<List<Cell>> board) {
    List<List<Cell>> vBoard = new ArrayList<>();

    for (int row = 0; row <= board.size() - 1; row++) {
      vBoard.add(new ArrayList<>());
      for (int col = 0; row <= board.size() - 1; row++) {
        vBoard.get(0).add(board.get(row).get(col));
      }
    }

    return vBoard;
  }

  private static Boolean verticalWinner(List<List<Cell>> board) {
    boolean hasWinner = false;
    List<List<Cell>> rotatedBoard = GameOps.rotateBoard90Deg(board);

    for (int row = 0; row <= rotatedBoard.size() - 1; row++) {
      if (GameOps.rowCardinality(rotatedBoard.get(row)) == 1) {
        hasWinner = true;
        break;
      }
    }

    return hasWinner;
  }

  private static Boolean horizontalWinner(List<List<Cell>> board) {
    boolean hasWinner = false;

    for (int row = 0; row <= board.size() - 1; row++) {
      if (GameOps.rowCardinality(board.get(row)) == 1) {
        hasWinner = true;
        break;
      }
    }

    return hasWinner;
  }

  private static Boolean diagonalWinner(List<List<Cell>> board) {
    List<Cell> diagonalRow = new ArrayList<>();

    diagonalRow.add(board.get(0).get(0));
    diagonalRow.add(board.get(1).get(1));
    diagonalRow.add(board.get(2).get(2));

    return GameOps.rowCardinality(diagonalRow) == 1;
  }

  private static Boolean reverseDiagonalWinner(List<List<Cell>> board) {
    List<Cell> reverseDiagonalRow = new ArrayList<>();

    reverseDiagonalRow.add(board.get(0).get(2));
    reverseDiagonalRow.add(board.get(1).get(1));
    reverseDiagonalRow.add(board.get(2).get(0));

    return GameOps.rowCardinality(reverseDiagonalRow) == 1;
  }

  public static Optional<TicTacToe.Player> getWinner(List<List<Cell>> board) {
    if (GameOps.horizontalWinner(board)
        || GameOps.verticalWinner(board)
        || GameOps.diagonalWinner(board)
        || GameOps.reverseDiagonalWinner(board)) {
      return Optional.of(TicTacToe.State.currentPlayer);
    }
    return Optional.empty();
  }
}
